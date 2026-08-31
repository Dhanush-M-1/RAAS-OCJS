#include<iostream>
#define r(i,n) for(int i=0;i<n;i++)
using namespace std;
int main(void){
  int n;
  while(cin>>n,n){
    int a[n],sum=0;
    r(i,n)cin>>a[i];
    r(i,n)for(int j=1;j<n;j++){
      if(a[j-1]>a[j]){
        swap(a[j-1],a[j]);
        sum++;
      }
    }
    cout<<sum<<endl;
  }
}