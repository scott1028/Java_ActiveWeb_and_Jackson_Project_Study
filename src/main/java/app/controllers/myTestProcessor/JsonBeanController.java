/*
Copyright 2009-2010 Igor Polevoy 

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License. 
*/

package app.controllers.myTestProcessor;

import org.javalite.activeweb.AppController;

import org.javalite.activejdbc.LazyList;
import app.models.Book;

import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;

/**
 * @author Igor Polevoy
 */
public class JsonBeanController extends AppController {
    // jsonWriter

    private class Customer {
        String id;
        String address;
        Date birthday;

        public String getId(){
            return this.id;
        }

        public void setId(String id){
            this.id = id;
        }

        public String getAddress(){
            return this.address;
        }

        public void setAddress(String address){
            this.address = address;
        }

        public Date getBirthday(){
            return this.birthday;
        }

        public void setBirthday(Date birthday){
            this.birthday = birthday;
        }
    }

    private class Store {
        String id;
        String name;
        List<Customer> customerList;

        public String getId(){
            return this.id;
        }

        public void setId(String id){
            this.id = id;
        }

        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }

        public List<Customer> getCustomerList(){
            return this.customerList;
        }

        public void setCustomerList(List<Customer> customerList){
            this.customerList = customerList;
        }
    };

    public void index () throws Exception{
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        ObjectWriter ow = om.writer().withDefaultPrettyPrinter();

        Store store = new Store();
        store.setId("1");
        store.setName("test");

        List<Customer> customerList = new ArrayList<Customer>();
        Customer customer1 = new Customer();
        customer1.setId("1");
        customer1.setAddress("a");
        Customer customer2 = new Customer();
        customer2.setId("2");
        customer2.setAddress("b");
        customer2.setBirthday(new Date());
        customerList.add(customer1);
        customerList.add(customer2);
        store.setCustomerList(customerList);

        respond(ow.writeValueAsString(store)).contentType("application/json").status(201);
    }
}
