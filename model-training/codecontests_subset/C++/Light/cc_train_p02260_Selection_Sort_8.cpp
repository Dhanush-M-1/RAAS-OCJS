#include<iostream>
#include<algorithm>
using namespace std;
int main(){
  int n,a[100],cnt=0,j;
  cin>>n;
  for(int i=0;i<n;i++)cin>>a[i];
  for(int i=0;i<n;i++){
    int minj=i;
    for(j=i;j<n;j++)if(a[j]<a[minj])minj=j;
    if(minj!=i){swap(a[minj],a[i]);cnt++;}
  }
  for(int i=0;i<n;i++){
    cout<<a[i];
    i==n-1?cout<<endl:cout<<" ";
  }
  cout<<cnt<<endl;
  return 0;
}