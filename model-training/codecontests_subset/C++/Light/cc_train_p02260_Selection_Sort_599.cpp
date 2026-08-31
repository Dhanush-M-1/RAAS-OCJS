#include <bits/stdc++.h>
using namespace std;


int main(){
  int n,sw=0;
  cin>>n;
  int A[n];
  for(int i=0;i<n;i++){
    cin>>A[i];
  }
  for(int i=0;i<n-1;i++){
    int minj=i;
    for(int j=i+1;j<n;j++){
      if(A[minj]>A[j]){
        minj=j;
      }
    }
    if(minj!=i){
      swap(A[minj],A[i]);
      sw++;
    }
  }
  for(int i=0;i<n;i++){
    if(i){cout << " ";}
    cout << A[i];
  }
  cout << endl<<sw<<endl;
}
