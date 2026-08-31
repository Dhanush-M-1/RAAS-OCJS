#include <bits/stdc++.h>
using namespace std;

int main() {
  int N;
  cin >> N;
  vector<int> A(N);
  for (int i = 0; i < N; i++) cin >> A[i];
  int ret = 0;
  for (int i = 0; i < N; i++) {
    int minj = i;
    for (int j = i+1; j < N; j++) {
      if (A[j] < A[minj]) minj = j;
    }
    if (minj != i) {
      swap(A[i], A[minj]);
      ret++;
    }
  }
  cout << A[0];
  for (int i = 1; i < N; i++) cout << ' ' << A[i];
  cout << endl;
  cout << ret << endl;
}
