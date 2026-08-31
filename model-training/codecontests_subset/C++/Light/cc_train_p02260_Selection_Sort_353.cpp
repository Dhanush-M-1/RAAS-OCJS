#include <iostream>
using namespace std;

int isort(int A[],int N){
  int minj,sw=0;
  for(int i=0;i<N;i++){
    minj=i;
    for(int j=i;j<N;j++){
      if(A[minj]>A[j]) minj=j;
    }
    swap(A[i],A[minj]);
    if(i!=minj)sw++;
  }
  return sw;
}

int main(){
  int A[100],N,sw;
  cin>>N;

  for(int i=0;i<N;i++) cin>>A[i];

  sw=isort(A,N);

  for(int i=0;i<N;i++){
    if(i!=0) cout<<" ";
    cout<<A[i];
  }
  cout<<endl;
  cout<<sw<<endl;
  return 0;
}