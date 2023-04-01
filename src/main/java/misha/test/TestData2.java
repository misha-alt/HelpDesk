package misha.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestData2 {
    public static void main(String[] args) throws ParseException {

        StringDataSort stringDataSort1 = new StringDataSort("02/10/2022", "first");
        StringDataSort stringDataSort2 = new StringDataSort("02/09/2022", "second");



        SimpleDateFormat Sformat = new SimpleDateFormat();
        Sformat.applyPattern("dd/MM/yyyy");
        System.out.println(Sformat.parse(stringDataSort1.getDate()));


        DataCompare dataCompare = new DataCompare();
        List list = new ArrayList();
        list.add(stringDataSort1);
        list.add(stringDataSort2);
        list.sort(dataCompare);
        System.out.println(list);

      }

       /* if (Sformat.parse(stringDataSort1.getDate()).compareTo(Sformat.parse(stringDataSort1.getDate()))){

        }*/

        /*DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);

        System.out.println(dateFormat.format(Sformat.parse(s))+"sfsfsf345");*/
    }

