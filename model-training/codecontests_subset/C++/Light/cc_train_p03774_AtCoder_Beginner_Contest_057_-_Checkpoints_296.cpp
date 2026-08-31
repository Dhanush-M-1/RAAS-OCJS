#include <bits/stdc++.h>
using namespace std;
int main(){
    int N,M;
    cin>>N>>M;
    int a[N],b[N],c[M],d[M];
    for(int i=0;i<N;i++){
        cin>>a[i]>>b[i];
    }
    for(int i=0;i<M;i++){
        cin>>c[i]>>d[i];
    }
    for(int i=0;i<N;i++){
        int P=0;
        int D=500000000;
        int pD;
        for(int j=0;j<M;j++){
            pD=abs(a[i]-c[j])+abs(b[i]-d[j]);
            if(pD<D){P=j+1;D=pD;}
        }
        cout<<P<<endl;
    }
}