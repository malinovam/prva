//package lab;
//
//class SLLJoinLists<Integer extends Comparable<Integer>>{
//    public SLL<Integer> spojlisti(SLL<Integer> prva, SLL<Integer> vtora){
//
//        SLL<Integer> rezultat=new SLL<Integer>();
//        SLLNode<Integer> temp1=prva.getFirst();
//        SLLNode<Integer> temp2=vtora.getFirst();
//
//        while(temp1 != null && temp2 != null){
//
//            if(temp1.element.compareTo(temp2.element) < 0 ){
//                rezultat.insertLast(temp1.element);
//                temp1=temp1.succ;
//            }
//            else{
//                rezultat.insertLast(temp2.element);
//                temp2=temp2.succ;
//            }
//        }
//
//        while(temp1 != null){
//            rezultat.insertLast(temp1.element);
//            temp1=temp1.succ;
//        }
//        while(temp2 != null){
//            rezultat.insertLast(temp2.element);
//            temp2=temp2.succ;
//        }
//        return rezultat;
//    }
//}