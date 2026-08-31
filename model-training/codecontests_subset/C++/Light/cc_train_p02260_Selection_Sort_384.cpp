#include<iostream>
#include<math.h>
#include<algorithm>
using namespace std;

int main(){
  int A[110], N, minj, cnt=0;
  cin>>N;
  for(int i=0;i<N;i++) cin>>A[i];
  for(int i=0;i<N;i++){
    minj = i;
    for(int j=i+1;j<N;j++){
      if(A[j]<A[minj]) minj = j;
    }
    if(minj != i){
      int v = A[i];
      A[i] = A[minj];
      A[minj] = v;
      cnt += 1;
    }
  }
  for(int i=0;i<N-1;i++) cout<<A[i]<<" ";
  cout<<A[N-1]<<endl;
  cout<<cnt<<endl;
  return 0;
}

