package com.jap.collectiondemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MobileStore {


    private List<Mobile> allMobiles;
    private String record = "";
    private String splitBy = ",";
    public MobileStore()
    {
        allMobiles = new ArrayList<>();
    }

    //Write logic to read the fileName that is "mobile.csv"
    //read all the lines one by one
    //Create Mobile class object and store data from file in the respective attributes of Mobile class
    // ex - Store brandName - Samsung in  mobile.setBrandName(brandName);
    //add mobile object in the List object and return the List
    //handle all the exceptions
    public List<Mobile> readMobileData(String fileName)
    {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
             fileReader = new FileReader("mobile.csv");
             bufferedReader=new BufferedReader(fileReader);
             String line;
             fileReader = new FileReader("mobile.csv");
             bufferedReader=new BufferedReader(fileReader);
             bufferedReader.readLine();
             while((line=bufferedReader.readLine())!=null)
             {
                 Mobile mobile=new Mobile();
                //allMobiles=new ArrayList<>();
                 String[]split=line.split(",");
                 mobile.setBrandName(split[0]);
                 mobile.setModelName(split[1]);
                 mobile.setCost(Double.parseDouble(split[2]));
                 mobile.setScreenSize(split[3]);
                 mobile.setBatteryLife(split[4]);
                 mobile.setStorageSpace(split[5]);
                 mobile.setCameraPixels(Integer.parseInt(split[6]));
                 allMobiles.add(mobile);
             }
            for (Mobile allMobile : allMobiles) {
                System.out.println(allMobile);
            }
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return allMobiles;
    }

    //Iterate the List created in the above method and retrieve the bandName
    //Return the List with specific Mobile having brandName coming from method parameter
    public List<Mobile> findPhoneByBrand(String brandName)
    {
        List<Mobile> mobilesByBrand = new ArrayList<>();
        for (Mobile allMobile : allMobiles) {
            if(allMobile.getBrandName().equals(brandName))
            {
                mobilesByBrand.add(allMobile);

            }
        }
        for (Mobile mobile : mobilesByBrand) {
            System.out.println("mobilesByBrand = "+mobile);
        }


        return mobilesByBrand;
    }

    //Iterate through the List created in the first method
    //Return the List of Mobile whose cost is more than $500
    public List<Mobile> findPhoneCostMoreThan$500()
    {
        List<Mobile> mobilesMoreThan500 = new ArrayList<>();
        for (Mobile allMobile : allMobiles) {
           if(allMobile.getCost()>500)
           {
               mobilesMoreThan500.add(allMobile);

           }
        }
        for (Mobile mobile : mobilesMoreThan500) {
            System.out.println("mobileMoreThan500 = " + mobile);
        }

        return mobilesMoreThan500;
    }

    //Iterate through the List created in the first method
    //Return the List of Mobile whose Pixel is more than 12MP
    public List<Mobile> findPhonePixelMoreThan12MP()
    {
        List<Mobile> mobilesMoreThan12MP = new ArrayList<>();
        for (Mobile allMobile : allMobiles) {
            if(allMobile.getCameraPixels()>12)
            {
                mobilesMoreThan12MP.add(allMobile);
            }
        }
        for (Mobile mobile : mobilesMoreThan12MP) {
            System.out.println("findPhonePixelMoreThan12MP = "+mobile);
        }
        return mobilesMoreThan12MP;
    }

    public static void main(String[] args) {
        MobileStore m=new MobileStore();
        m.readMobileData("mobile.csv");
        m.findPhoneByBrand("Samsung");
        m.findPhoneCostMoreThan$500();
        m.findPhonePixelMoreThan12MP();
    }
}

