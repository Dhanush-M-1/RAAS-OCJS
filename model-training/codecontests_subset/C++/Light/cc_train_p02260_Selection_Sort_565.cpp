#include <iostream>
#include <algorithm>
using namespace std;

int main(){
  int n,i,j,count=0,min;
  cin>>n;
  int a[n];
  for (i=0;i<n;i++)cin>>a[i];

  for (i=0;i<n;i++){
    min=i;
    for (j=i;j<n;j++){
      if (a[j]<a[min])min=j;
    }
    swap(a[i],a[min]);
    count+=(min!=i);
  }
  for (i=0;i<n;i++){
    if (i)cout<<' ';
    cout<<a[i];
  }
  cout<<endl;
  cout<<count<<endl;
}

