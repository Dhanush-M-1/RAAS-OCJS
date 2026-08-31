#include <vector>
#include <iostream>
using namespace std;

int main(){
  int N;
  cin >> N;
  vector<int> A(N);
  for(int i = 0; i < N; ++i) cin >> A[i];
  for(int i = 0; i < N; ++i){
    for(int j = 0; j < i; ++j){
      if(abs(A[i]-A[j])%(N-1)) continue;
      cout << A[j] << " " << A[i] << endl;
      return 0;
    }
  }
}

