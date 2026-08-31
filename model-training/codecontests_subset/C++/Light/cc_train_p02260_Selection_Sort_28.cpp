#include <bits/stdc++.h>
using namespace std;
 
int main(){
  int n,count=0;
  cin>> n;
  int a[n];
  for(int i=0;i<n;i++){
    cin >> a[i];
  }
  for(int i=0;i<n;i++){
    int minj=i;
    for(int j=i;j<n;j++){
      if(a[minj]>a[j])minj=j;
    }
    swap(a[i],a[minj]);
    if(i!=minj)count++;
  }
  for(int i=0;i<n;i++){
    cout <<a[i];
    if(i!=n-1)cout<<' ';
  }
  cout<<endl<<count<<endl;
  return 0;
}
      
