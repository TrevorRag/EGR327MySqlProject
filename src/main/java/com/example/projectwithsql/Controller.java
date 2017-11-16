package com.example.projectwithsql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Stack;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@RestController
public class Controller {

    @Autowired //we will cover this later
    private GreetingDAO greetingDao;

    @RequestMapping(value = "/createGreeting", method = RequestMethod.POST)
    public Greeting createGreeting(@RequestBody String name) throws IOException {
        Greeting newGreeting = new Greeting(name);
        greetingDao.create(newGreeting);
        return newGreeting;
    }

    @RequestMapping(value = "/getGreeting/{id}", method = RequestMethod.GET)
    public Greeting getGreeting(@PathVariable("id") int id) throws IOException {
        return greetingDao.getById(id); }

    private static final String FILENAME = "./inventory.txt";
    private Stack<Vehicle> latest = new Stack<Vehicle>();


//    @RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
//    public Vehicle addVehicle(@RequestBody Vehicle newVehicle)throws IOException{
//        ObjectMapper mapper  = new ObjectMapper();
//        FileWriter output = new FileWriter(FILENAME,true);
//        mapper.writeValue(output, newVehicle);
//        FileUtils.writeStringToFile(new File(FILENAME),System.lineSeparator(),true);
//        latest.push(newVehicle);
//        return newVehicle;
//    }
//
//    @RequestMapping(value = "/getVehicle/{id}", method = RequestMethod.GET)
//    public Vehicle getVehicle(@PathVariable("id") int id)throws IOException{
//        return scanFile(FILENAME, id);
//    }
//
//    @RequestMapping(value = "/updateVehicle", method = RequestMethod.PUT)
//    public Vehicle updateVehicle(@RequestBody Vehicle newVehicle) throws IOException{
//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File(FILENAME);
//        FileWriter output = new FileWriter(file,true);
//        if(removeLine(file,newVehicle.getId())){
//            mapper.writeValue(output, newVehicle);
//            FileUtils.writeStringToFile(file,System.lineSeparator(),true);
//            return newVehicle;
//        }else{
//            return null;
//        }
//    }
//
//    @RequestMapping(value = "/deleteVehicle/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<String> deleteVehicle(@PathVariable("id") int id)throws IOException{
//        File file = new File(FILENAME);
//        if(removeLine(file,id)){
//            return new ResponseEntity<String>("Deleted", HttpStatus.OK);
//        }else {
//            return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @RequestMapping(value = "/getLatestVehicles", method = RequestMethod.GET)
//    public List<Vehicle> getLatestVehicles()throws IOException{
//        List<Vehicle> list = new ArrayList<>(10);
//        for(int i = 0; i <10; i++){
//            list.add(i,latest.pop());
//        }
//        Collections.reverse(list);
//        return list;
//    }



    //     HELPERS
//    private Vehicle scanFile(String filename, int id){
//        Vehicle vehicle = new Vehicle();
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            List<String> fileLines = FileUtils.readLines(new File(filename));
//            for (String line : fileLines) {
//                //if the line is written like "id":(id of newVehicle)
//                if (line.contains("\"id\":" + id + ",")) {
//                    vehicle = mapper.readValue(line, Vehicle.class);
//                }
//            }
//            FileUtils.writeLines(new File(FILENAME),fileLines);
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return vehicle;
//    }
//
//    private Boolean removeLine(File file, int id){
//        boolean found = false;
//        int index = 0;
//        try {
//            List<String> fileLines = FileUtils.readLines(file);   //List of the lines of the file as Strings
//            for (String line :
//                    fileLines) {
//                //if the line is written like "id":(id of newVehicle)
//                if (line.contains("\"id\":" + id + ",")) {
//                    found = true;
//                    index = fileLines.lastIndexOf(line);
//                }
//            }
//            if(index != 0)
//                fileLines.remove(index);
//            FileUtils.writeLines(file,fileLines);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return found;
//    }
//
//
//    //      GREETING
//    public static int count = 0;

//    @RequestMapping("/greeting")
//    public Greeting greeting() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        String message = FileUtils.readFileToString(new File("/Users/T-Raww/IdeaProjects/Project/message.txt"));
//        return mapper.readValue(message, Greeting.class);
//    }

//    @RequestMapping(value = "/createGreeting", method = RequestMethod.POST)
//    public Greeting createGreeting(@RequestBody String content) throws IOException{
//        Greeting newGreeting = new Greeting(count++,content);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new File("/Users/T-Raww/IdeaProjects/Project/message.txt"),newGreeting);
//        return newGreeting;
//    }
//    @RequestMapping(value = "/updateGreeting", method = RequestMethod.PUT)
//    public Greeting updateGreeting(@RequestBody String newMessage) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        String message = FileUtils.readFileToString(new File("/Users/T-Raww/IdeaProjects/Project/message.txt"));
//        Greeting newGreeting = mapper.readValue(message, Greeting.class);
//        newGreeting.setContent(newMessage);
//        mapper.writeValue(new File("/Users/T-Raww/IdeaProjects/Project/message.txt"), newGreeting);
//        return newGreeting;
//    }
//
//    @RequestMapping(value = "/deleteGreeting", method = RequestMethod.DELETE)
//    public void deleteGreeting(@RequestBody int id) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        String message = FileUtils.readFileToString(new File("/Users/T-Raww/IdeaProjects/Project/message.txt"));
//        Greeting greeting = mapper.readValue(message, Greeting.class);
//        if(greeting.getId() == id) {
//            FileUtils.writeStringToFile(new File("/Users/T-Raww/IdeaProjects/Project/message.txt"),"");
//        }
//    }
}
