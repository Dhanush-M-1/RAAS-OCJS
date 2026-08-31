#include<iostream>
#include<cstdio>
#include<time.h>
using namespace std;
#define N 314159
int a[N],t[N];
long long ans=0;
void marge_count(int s,int g){
  if(s+1==g)return;
  int m= (s+g)/2;
  marge_count(s,m);
  marge_count(m,g);
  int p=s,q=m,r=s;
  while(p<m&&q<g){
    if(a[p]<=a[q]){
      t[r++]=a[p++];
    }else{
      t[r++]=a[q++];
      ans+=m-p;
    }
  }
  if(p<m){
    while(p<m)t[r++]=a[p++];
  }else{
    while(q<g){
      t[r++]=a[q++];
    }
  }
  for(int i=s;i<g;i++){
    a[i]=t[i];
  }
}
int n;
int main(){
    while(cin>>n&&n){ans=0;
  for(int i=0;i<n;i++)cin>>a[i];
  marge_count(0,n);
   cout<<ans<<endl;}
  return 0;
}