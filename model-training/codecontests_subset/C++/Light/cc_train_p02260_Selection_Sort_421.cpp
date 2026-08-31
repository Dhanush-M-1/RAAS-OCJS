#include <iostream>
using namespace std;

int main() {
  int N;
  cin>>N;
  int A[N];
  for (int i=0; i<N; i++) {
    cin>>A[i];
  }
  int sw=0;
  for (int i=0; i<N; i++) {
    int minj=i;
    for (int j=i; j<N; j++) {
      if (A[j]<A[minj]) {
        minj=j;
      }
    }
    swap(A[i],A[minj]);
    if (i!=minj) {
      sw++;
    }
  }
  for (int i=0; i<N; i++) {
    cout<<(i==0?"":" ")<<A[i]<<flush;
  }
  cout<<endl;
  cout<<sw<<endl;
  return 0;
}

