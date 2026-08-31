#include <iostream>
using namespace std;
int main(){
  int Q, N;
  cin >> Q;
  while(Q--){
    cin >> N;

    int count = 0;
    while(N >= 10){
      count++;
      int best = 0;
      int p = 1;
      while(p < N){
        best = max(best, (N % p) * (N / p));
        p *= 10;
      }
      N = best;
    }
    cout << count << endl;
  }
}