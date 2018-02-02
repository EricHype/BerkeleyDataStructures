package com.ericheitmuller.week4;

public class SerializeTree {


    public static void main(String[] args) {


        Node<Integer> test = new Node<>(5);
        test.leftChild = new Node(3);
        test.rightChild = new Node(7);

        System.out.println(serializeTree(test));


        Node reserialized = deSerializeTree("{ value: 5, left: { value: 3, left: {}, right: {} }, right: { value: 7, left: {}, right: {} } }");
        System.out.println(reserialized.value);
    }


    public static String serializeTree(Node current){

        if(current == null){
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        sb.append("value: " + current.value + ", ");
        sb.append("left: " + serializeTree(current.leftChild) + ", ");
        sb.append("right: " + serializeTree(current.rightChild) + "");
        sb.append(" }");

        return sb.toString();
    }


    public static Node deSerializeTree(String value){


        //value:5, left: { value :3, left: {}, right: {} }, right: { value :7, left: {}, right: {} }
        if(value.equals("{}")){
            return null;
        }

        String workload = value.substring(value.indexOf("{")+1, value.lastIndexOf("}") - 1);

        String val = workload.substring(workload.indexOf("value: ")+7, workload.indexOf(","));
        Node node = new Node<Integer>(Integer.parseInt(val));

        workload = workload.substring(workload.indexOf("left: ")+ 6);
        //{ value :3, left: {}, right: {} }, right: { value :7, left: {}, right: {} }
        int endOfLeft = findIndexOfClosingBrace(workload);
        node.leftChild = deSerializeTree(workload.substring(0, endOfLeft+1));

        workload = workload.substring(endOfLeft + 2);
        //right: { value :7, left: {}, right: {} }
        workload = workload.substring(workload.indexOf("right: ") + 7);
        //{ value :7, left: {}, right: {} }
        node.rightChild = deSerializeTree(workload);

        return node;

    }


    public static Integer findIndexOfClosingBrace(String input){

        char[] chars = input.toCharArray();
        int openBraces =1;
        for(int i=1; i< chars.length; i++){
            if(chars[i] == '{'){
                openBraces++;
            }
            if (chars[i] =='}'){
                openBraces--;
            }

            if(openBraces ==0){
                return i;
            }
        }

        return -1;
    }
}
