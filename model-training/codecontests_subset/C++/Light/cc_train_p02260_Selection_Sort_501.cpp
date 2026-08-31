#include<iostream>
using namespace std;

int ssort(int A[],int N){
  int i,j,t,sw=0,minj;
  for(i=0;i<N-1;i++){
    minj=i;
    for(j=i;j<N;j++){
      if(A[j]<A[minj]) minj=j;
    }
    t=A[i]; A[i]=A[minj]; A[minj]=t;
    if(i!=minj) sw++;
  }
  return sw;
}
int main(){
  int i,A[100],N,sw;

  cin>>N;
  for(i=0;i<N;i++) cin>>A[i];
  sw=ssort(A,N);
  for(i=0;i<N;i++){
    if(i>0) cout<<(" ");
    cout<<A[i];
  }
  cout<<endl;
  cout<<sw<<endl;

  return 0;
}