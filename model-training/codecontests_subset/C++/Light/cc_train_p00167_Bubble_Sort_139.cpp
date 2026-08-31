#include<iostream>
using namespace std;
int main(){
long n,a[100],t,i,j,k;
while(cin>>n){
if(n==0)break;
for(i=0;i<n;i++)cin>>a[i];
for(k=0,j=n-1;j>0;j--)
for(i=0;i<j;i++){
if(a[i]>a[i+1]){t=a[i];a[i]=a[i+1];a[i+1]=t;k++;}
}
cout<<k<<endl;
}
return 0;
}