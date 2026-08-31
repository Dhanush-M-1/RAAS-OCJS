#include<iostream>
#include<cassert>
#include <algorithm>
using namespace std;
int a[201],w[201],n;
int merge_and_count(int l,int r){
  if(l+1>=r)return 0;
  if(l+2==r){
    if(a[l]<=a[l+1])return 0;
    else{
      swap(a[l],a[l+1]);
      return 1;
    }
  }
  int m= (l+r)/2;
  int cl=merge_and_count(l,m);
  int cr=merge_and_count(m,r);
  int ret=cl+cr;
  int i=l,j=m,k=l;
  while(i<m&&j<r&&k<r){
    if(a[i]<=a[j])w[k++]=a[i++];
    else{
      w[k++]=a[j++];
      ret+=m-i;
    }
  }
  while(i<m)w[k++]=a[i++];
  while(j<r)w[k++]=a[j++];
  assert(k==r);
  for(i=l;i<r;i++){
    a[i]=w[i];
  }
  //cout<<"marge"<<l<<" "<<r<<" "<<ret<<endl;
  return ret;
}
int main(){
  while(cin>>n&&n){
    for(int i=0;i<n;i++){
      cin>>a[i];
    }
    cout<<merge_and_count(0,n)<<endl;
  }
}