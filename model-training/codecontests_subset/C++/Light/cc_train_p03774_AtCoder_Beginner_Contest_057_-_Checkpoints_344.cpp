#include <bits/stdc++.h>
#include<stdio.h>
using namespace std;
 
int main(){
int n,m;
long long a[51],b[51],c[51],d[51];
cin>>n>>m;
for(int i=0;i<n;i++){
cin>>a[i]>>b[i];
}
for(int i=0;i<m;i++){
cin>>c[i]>>d[i];
}
for(int i=0;i<n;i++){
long long ans=10000000000;
int an=0;
for(int j=0;j<m;j++){
if(abs(a[i]-c[j])+abs(b[i]-d[j])<ans)an=j;
ans=min(abs(a[i]-c[j])+abs(b[i]-d[j]),ans);
}
cout<<an+1<<endl;
}
 
}