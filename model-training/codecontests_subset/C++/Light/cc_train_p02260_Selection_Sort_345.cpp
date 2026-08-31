#include<bits/stdc++.h>
using namespace std;
int main(){
  int x=0,n,a[100];
  cin>>n;
  for(int i = 0 ; i < n; i++){
    cin>>a[i];
  }
  for(int i=0;i<n-1;i++){
    int min=i;
    for(int j=i;j<n;j++){
      if(a[min]>a[j]) min=j;
    }
    if(min==i) 1;
    else {
      int tmp;
      tmp=a[i];
      a[i]=a[min];
      a[min]=tmp;
      x++;
    }
  }
  for(int i=0; i<n;i++){
    if(i!=0) cout<<" ";
    cout<<a[i];
  }
  cout<<endl<<x<<endl;
  return 0;
}

