#include <iostream>
using namespace std;

int main(){
  int n;
  int a[100];
  cin>>n;
  for (int i=0; i<n; i++) cin>>a[i];
  int counter=0;
  
  for (int i=0; i<n; i++){
    int minj=i;
    for (int j=i; j<n; j++){
      if (a[j]<a[minj]){
        minj=j;
      }
    }
    if (a[i]!=a[minj]){
      swap(a[i],a[minj]);
      counter++;
    }
  }
  for (int i=0; i<n; i++){
    if (i) cout<<" ";
    cout<<a[i];
  }
  cout<<endl;
  cout<<counter<<endl;
}
  
        
      
