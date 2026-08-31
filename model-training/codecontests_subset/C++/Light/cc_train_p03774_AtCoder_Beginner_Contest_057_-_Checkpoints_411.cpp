#include <bits/stdc++.h>
using namespace std;
int N,M;
long a[50],b[50],c[50],d[50];
int main()
{
    cin>>N>>M;
    for(int i=0;i<N;++i){
        cin>>a[i]>>b[i];
    }
    for(int i=0;i<M;++i){
        cin>>c[i]>>d[i];
    }
    for(int i=0;i<N;++i){
        int p=0;
        for(int j=0;j<M;++j){
            if(abs(a[i]-c[j])+abs(b[i]-d[j])<abs(a[i]-c[p])+abs(b[i]-d[p])){
                p=j;
            }
        }
        cout<<p+1<<endl;
    }
}