#include<bits/stdc++.h>
using namespace std;
int a[60],b[60],c[60],d[60];
int main(){
    int n,m;
    cin>>n>>m;
    for(int i=1;i<=n;i++)cin>>a[i]>>b[i];
    for(int i=1;i<=m;i++)cin>>c[i]>>d[i];
    for(int i=1;i<=n;i++){
        int ans=1000000000;
        int k;
        for(int j=1;j<=m;j++){
            int t=abs(a[i]-c[j])+abs(b[i]-d[j]);
            if(t<ans){ans=t;k=j;}
        }
        cout<<k<<endl;
    }
    return 0;
} 