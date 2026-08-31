#include<bits/stdc++.h>

using namespace std;

using int64 = long long;
const int INF = 1 << 30;

int main() {
  // な
  // 　な　た
  // 　　めて
  // 　よこまるた
  // 　　　るる
  // 　　　た　た

  int N, A[1000];
  cin >> N;
  for(int i = 0; i < N; i++) {
    cin >> A[i];
  }
  for(int i = 0; i < N; i++) {
    for(int j = i + 1; j < N; j++) {
      if(abs(A[i] - A[j]) % (N - 1) == 0) {
        cout << A[i] << " " << A[j] << endl;
        return (0);
      }
    }
  }
}
