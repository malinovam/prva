package izbrisiParnoPojavuvanje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    public SLL<E> succ;
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + " ";
            }
        } else
            ret = "";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first ==node){
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            }
        }
        return first;
    }
}


public class ExamTerm2 {
    public static void deleteEven(SLL<Integer> list1, SLL<Integer> list2) {
        //todo: enter code here
        SLLNode<Integer> prva = list1.getFirst();
        SLLNode<Integer> vtora = list2.getFirst();
        int p1=0;
        int p2=0;
        int suma=0;
        while (prva!=null){
            p1=p1 * 10 + prva.element;
            prva=prva.succ;
        }
        while (vtora!=null){
            p2=p2 * 10 + vtora.element;
            vtora=vtora.succ;
        }
       suma=p1+p2;
        System.out.println(suma);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here
        String s = scanner.nextLine();
        String [] temp = s.split(" ");
        for (int i=0;i<n;i++){
            list1.insertLast(Integer.parseInt(temp[i]));
        }
        Scanner scanner2 = new Scanner(System.in);
        int n2 = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list2 = new SLL<Integer>();

        //todo: enter code here
        String s2 = scanner2.nextLine();
        String [] temp2 = s2.split(" ");
        for (int i=0;i<n2;i++){
            list2.insertLast(Integer.parseInt(temp2[i]));
        }
        deleteEven(list1,list2);
        //todo: enter code here
        //System.out.println(list1);
    }
}





 /*Во дадена еднострана поврзана листа избришете ги сите јазли чии вредности се
        jавуваат парен број пати. Смеете да користите само ЕДНА листа.

        Влез:

        9
        1->10->2->3->5->2->10->3->3
        Излез:  1->3->5->3->3
        SLLNode<Integer> jazol = list1.getFirst();
        SLLNode<Integer> temp = list1.getFirst();
        int brojac = 0;

        while (temp != null){
            while (jazol != null){
                if (temp.element == jazol.element){
                    brojac++;
                }
                jazol = jazol.succ;
            }
            jazol = list1.getFirst();

            if (brojac%2==0){
                while (jazol!=null){
                    if (jazol.element == temp.element){
                        list1.delete(jazol);
                    }
                    jazol = jazol.succ;
                }
            }
            jazol = list1.getFirst();
            temp = temp.succ;
        }
        */
/*
SLLNode<Integer> dvizi = list1.getFirst();
    SLLNode<Integer> jazol = list1.getFirst();
    int b=0;
    while (jazol != null){
       b=0;
       while (dvizi != null){
           if (jazol.element == dvizi.element){
               b++;
           }
           dvizi = dvizi.succ;
       }
       dvizi=list1.getFirst();
       if (b%2==0){
           while (dvizi != null){
               if (dvizi.element == jazol.element) {
                   list1.delete(dvizi);
               }
               dvizi = dvizi.succ;
           }
       }
       dvizi=list1.getFirst();
       jazol=jazol.succ;
     }
 */
