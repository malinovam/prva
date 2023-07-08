package parnNeparni;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            DLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if(after==last){
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if(before == first){
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        // else throw Exception
        return null;
    }

    public E delete(DLLNode<E> node) {
        if(node==first){
            deleteFirst();
            return node.element;
        }
        if(node==last){
            deleteLast();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + " ";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp + "<->";
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

    public void izvadiDupliIPrebroj(){

    }
}
class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

public class ParniSoParni {

    public static void ParniSoParni(DLL<Integer> lista1,DLL<Integer> lista2,DLL<Integer> nova) {
        DLLNode<Integer> a = lista1.getFirst();
        DLLNode<Integer> b = lista2.getFirst();
        while(a != null && b != null){
            if (a.succ.succ != null){
                nova.insertLast(a.element);
                a=a.succ;
                nova.insertLast(a.element);
                a=a.succ;
            }

            if (b.succ.succ != null){
                nova.insertLast(b.element);
                b=b.succ;
                nova.insertLast(b.element);
                b=b.succ;
            }

        }

           if(a.succ != null) {
               nova.insertLast(a.element);
               a = a.succ;
               nova.insertLast(a.element);
           }
           if(a!=null){
               nova.insertLast(a.element);
           }

        while (b!=null){
            nova.insertLast(b.element);
            b=b.succ;
        }

        while (b!=null){
            nova.insertLast(b.element);
            b=b.succ;
        }
    }


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        DLL<Integer> nova=new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        DLL<Integer> lista1=new DLL<Integer>();

        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }
        s = stdin.readLine();
        int M = Integer.parseInt(s);
        s = stdin.readLine();
        DLL<Integer> lista2=new DLL<Integer>();

        pomniza = s.split(" ");
        for (int i = 0; i < M; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        ParniSoParni(lista1,lista2,nova);
        System.out.println(nova);
    }

}
/*
  DLLNode<Integer> p = lista1.getFirst();
        DLLNode<Integer> q = lista2.getLast();
        while(p!=null && q!=null)
        {
            if(p.element%2==0) {
                nova.insertLast(p.element);
            }
            p=p.succ;

            if(q.element%2==0) {
                nova.insertLast(q.element);
            }
            q=q.pred;
        }

        while(p!=null) {
            if(p.element%2==0) {
                nova.insertLast(p.element);
            }
            p=p.succ;
        }

        while(q!=null) {
            if(q.element%2==0) {
                nova.insertLast(q.element);
            }
            q=q.pred;
        }
        p=lista1.getFirst();
        while(p!=null) {
            if(p.element%2!=0) {
                nova.insertLast(p.element);
            }
            p=p.succ;
        }

        q=lista2.getLast();
        while(q!=null)
        {
            if(q.element%2!=0) {
                nova.insertLast(q.element);
            }
            q=q.pred;
        }
 */
/*
 while (a != null && b != null){
            if (a.element % 2 == 0){
                nova.insertLast(a.element);
            }
            a = a.succ;
            if (b.element % 2 == 0){
                nova.insertLast(b.element);
            }
            b = b.pred;
        }
        while (a != null){
            if (a.element%2==0){
                nova.insertLast(a.element);
            }
            a = a.succ;
        }
        while (b != null){
            if (b.element%2==0){
                nova.insertLast(b.element);
            }
            b = b.pred;
        }
        a = lista1.getFirst();
        while (a != null){
            if (a.element %2 != 0){
                nova.insertLast(a.element);
            }
            a=a.succ;
        }
        b = lista2.getLast();
        while (b != null){
            if (b.element%2!=0){
                nova.insertLast(b.element);
            }
            b=b.pred;
        }
 */