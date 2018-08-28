public class numerosInteiros {
    public static long calculaDivisores(long n){
        long i,q=0;
        for(i=1;i<=n;++i){
            if (n%i==0)
                ++q;
        }
        return(q);
    }
    public static long calculaDivisores(long n, long inicio, long fim){
        long i,q=0;
        for(i=inicio; i<=fim; ++i){
            if (n%i==0)
                ++q;
        }
        return(q);
    }
}
