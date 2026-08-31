#include <iostream>
using namespace std;
int main(){

  int n,a[100],result=0,i,j;

  cin>>n;
  for(i=0;i<n;i++) cin>>a[i];

  for(i=0;i<n-1;i++){
    int now,minnum=101;
    for(j=i;j<n;j++) if(minnum>a[j]){
        now=j;
        minnum=a[j];
      }
    if(i!=now){
      swap(a[i],a[now]);
      result++;
    }
  }
  for(i=0;i<n-1;i++) cout<<a[i]<<" ";
  cout<<a[n-1]<<endl;

  cout<<result<<endl;
  return 0;
}