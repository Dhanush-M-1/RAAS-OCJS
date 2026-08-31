#include<bits/stdc++.h>
using namespace std;
int a[60],b[60],c[60],d[60];
int main(){
    int n,m;
    cin>>n>>m;
    for(int i=0;i<n;i++)  cin>>a[i]>>b[i];
    for(int i=0;i<m;i++)  cin>>c[i]>>d[i];
    for(int i=0;i<n;i++){
        int maxx=1000000000;
        int k;
        for(int j=0;j<m;j++){
            int t=abs(a[i]-c[j])+abs(b[i]-d[j]);
            if(t<maxx){
                maxx=t;
                k=j+1;
            }
        }
        cout<<k<<endl;
    }
    return 0;
}