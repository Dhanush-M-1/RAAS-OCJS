#include <iostream>
using namespace std;
int main(void){
    long long N,M,i,j,mod;
    mod=1e9+7;
    cin>>N>>M;
    long long a[N+1],b[N+1];
    for(i=0;i<N+1;i++){
        a[i]=1;
    }
    for(i=0;i<M;i++){
        cin>>j;
        a[j]=0;
    }
    b[0]=1;b[1]=a[1];
    for(i=2;i<N+1;i++){
        b[i]=((b[i-2]+b[i-1])*a[i])%mod;
    }
    cout<<b[N]<<endl;
}