#include <bits/stdc++.h>
using namespace std;
int main() {
  int N, A[33][2], i, j, Res;
  Res = 0;
  cin >> N;
  for (i = 0; i < N; i++) {
    cin >> j;
    A[i][0] = j;
    cin >> j;
    A[i][1] = j;
  }
  for (i = 0; i < N; i++) {
    for (j = 0; j < N; j++) {
      if (i != j) {
        if (A[i][0] == A[j][1]) {
          Res++;
        }
      }
    }
  }
  cout << Res;
  return 0;
}
