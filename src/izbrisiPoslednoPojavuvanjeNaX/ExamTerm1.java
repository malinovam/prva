package izbrisiPoslednoPojavuvanjeNaX;

import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

public class ExamTerm1 {
    public static void deleteDuplicates(SLL<Integer> list1, int key) { // 1 2 1 1 2 3 5 2
        //todo: enter code here
        SLLNode<Integer> dvizi = list1.getFirst();
        SLLNode<Integer> tmp=null;
        int brojac=0;
        int flag=0;
        while (dvizi != null){
            if (dvizi.element == key){
                brojac++;
                   if (flag==0) {
                        tmp = dvizi;
                        flag = 1;
                    }
            }
            dvizi=dvizi.succ;
        }
        if (brojac%2!=0){
            list1.insertLast(tmp.element);
            list1.delete(tmp);
        }

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
        int key = Integer.parseInt(scanner.nextLine());
        deleteDuplicates(list1,key);
        //todo: enter code here
        System.out.println(list1);

    }
}
/*
Дадена е еднострана поврзана листа и елемент кој треба да се избрише.
Ваша задача е да го избришете последното појавување на елементот.
Листата може да содржи дупликати. Дозволено е користење на ЕДНА поврзана листа. .

Пример:

Влез:   1->2->3->5->2->10, key = 2

Излез:  1->2->3->5->10

Забелешка:

Даден е целосниот код на структурата која што треба да се користи.
Потребно е да направат дополнувања во main функцијата и да се имплементирана
void deleteDuplicates(SLL list1, int key) функцијата. Притоа, бришењето
треба да биде имплементирано како бришење на цел јазел. Промените (пр. бришење)
не треба да се однесуваат на информациите во самите јазли туку во промени на врските помеѓу јазлите.

 SLLNode<Integer> jazol = list1.getFirst();
        SLLNode<Integer> temp = list1.getFirst();

        while (jazol != null){
            if (jazol.element == key){
                temp = jazol;
            }
            jazol = jazol.succ;
        }
        jazol = list1.getFirst();

        while (jazol != null){
            if (temp == jazol){
                list1.delete(jazol);
            }
            jazol = jazol.succ;
        }
        */
/*
 SLLNode<Integer> dvizi = list1.getFirst();
       SLLNode<Integer> tmp=null, vtoro = null;
      // int flag=0;
       int znak=0;
       int brojac=0;
       int pombrojac=0;
       while (dvizi != null){

           if (dvizi.element == key){
//               if (flag == 0){
//                   tmp=dvizi;
//                   flag=1;
//               }
               pombrojac++;
               if (znak == 0) {
                   if (pombrojac == 2) {
                       vtoro = dvizi;
                       znak = 1;
                   }
               }
               brojac++;
           }
           dvizi=dvizi.succ;
       }
       if (brojac%2!=0) {
           list1.insertLast(vtoro.element);
           list1.delete(vtoro);
       }
 */
/*
 int dolzina=list1.length();
        int sredina=dolzina/2;
        int start=sredina - (key/2);
        int end = start+key;
      if (start >= 0 && end <=dolzina){
          SLLNode<Integer> curr = list1.getFirst();
          for (int i=0;i<start;i++){
              curr=curr.succ;
          }
          for (int i=start;i<end;i++){
              list1.delete(curr);
              curr=curr.succ;
          }
      }
 */