#include<bits/stdc++.h>
using namespace std; 
 
 int main()
 { 
     int kkkk;
 int t=0; 
 cin>>t; 
 while(t-->0){ 
 int n; 
 cin>>n; 
 vector<long long>a(n),b(n),c(n,0); 
 for(int i=0;i<n;i++) cin>>a[i]; 
 for(int i=0;i<n;i++) cin>>b[i];  
 
 for(int i=1;i<n;i++){ 
 for(int j=i-1;j>=0;j--){  
 if(a[i]==a[j]) continue;
 long long x=c[i],y=c[j],z=abs(b[i]-b[j]);
 c[i]=max(c[i],y+z); 
 c[j]=max(c[j],x+z); } 
 } 
 cout<<*max_element(c.begin(),c.end())<<endl; 
 } 
 return 0; }