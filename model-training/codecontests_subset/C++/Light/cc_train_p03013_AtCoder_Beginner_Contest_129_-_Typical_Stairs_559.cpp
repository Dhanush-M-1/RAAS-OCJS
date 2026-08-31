#include <algorithm>
#include <cstdio>

using namespace std ;

const int N=1e6+10 ;
const int P=1e9+7 ;

int f[N] , ban[N] ;
int n , m ;
int main ()
{
    int i , x ;
    scanf("%d%d",&n,&m);
    for ( i=1 ; i<=m ; i++ ) scanf("%d",&x),ban[x]=1;
    f[0]=1;
    if ( !ban[1] ) f[1]=1;
    for ( i=2 ; i<=n ; i++ ) 
        if ( !ban[i] ) f[i]=(f[i-1]+f[i-2])%P;
    printf("%d\n",f[n]);
    return 0 ;
}