package sporediPrvPosledenZbirDLL;

/*  Задача со ДЛЛ листа, внесуваме низа и сега ги споредуваме првиот и
последниот,најпрво нивниот збир го ставаме да биде напред во листата,
па после глеаме кој е поголем и тиа го ставаме, го бришиме првиот шо е од левата страна....
 Пример внесуваме n=5, input:1 2 3 4 5, output 6,5,6,4,3,4,5. */
import java.util.Scanner;

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
            ret += tmp + "<->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "<->";
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
public class aa {
    public  static  void rotiraj(DLL<Integer> lista)
    {
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();
        while (prv != null && posleden != null){
            int suma = 0;
            if (prv == posleden){
                break;
            }
            suma = prv.element + posleden.element;
            lista.insertBefore(suma,prv);

            if (prv.element > posleden.element){
                lista.insertBefore(prv.element, prv);
                lista.delete(posleden);
            }
            else {
                lista.insertBefore(posleden.element, prv);
                lista.delete(prv);
            }
            if (prv.succ == posleden){
                lista.delete(posleden);
                break;
            }
            prv = prv.succ;
            posleden = posleden.pred;
        }
    }
    public static void main(String[] args) {
        DLL<Integer> lista=new DLL<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            lista.insertLast(sc.nextInt());
        }
        rotiraj(lista);
        System.out.println(lista);
    }
}
/*
DLLNode<Integer> dvizi=lista.getFirst();
        DLLNode<Integer> posleden=lista.getLast();
        while (dvizi!=null&& posleden!=null)
        {
            if(dvizi==posleden)
            {
                break;
            }
            int suma= dvizi.element+ posleden.element;
            lista.insertBefore(suma,dvizi);

            if(dvizi.element>=posleden.element)
            {
                lista.insertBefore(dvizi.element, dvizi);
                lista.delete(dvizi);
            }
            else
            {
                lista.insertBefore(posleden.element,dvizi);
                lista.delete(dvizi);
            }
            if(dvizi.succ==posleden)
            {
                lista.delete(posleden);
                break;
            }

            dvizi=dvizi.succ;
            posleden=posleden.pred;
        }
 */
