#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,minj,num=0;
  cin>>n;
  int a[n];
  for(int i=0;i<n;i++)
    cin>>a[i];
  for(int i=0;i<n;i++){
    minj=i;
    for(int j=i;j<n;j++){
      if(a[j]<a[minj])
	minj=j;
    }
    if(minj!=i){
      int tmp=a[i];
      a[i]=a[minj];
      a[minj]=tmp;
      num++;
    }
  }
  for(int i=0;i<n;i++){
    cout<<a[i];
    if(i!=n-1)
      cout<<" ";
  }
  cout<<endl;
  cout<<num<<endl;
  return 0;
}