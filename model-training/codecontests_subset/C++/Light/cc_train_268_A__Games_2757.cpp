#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, cnt = 0;
  cin >> n;
  vector<int> A(n);
  vector<int> B(n);
  for (int i = 0; i < n; i++) {
    cin >> A[i] >> B[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i != j) {
        if (A[i] == B[j]) {
          cnt++;
        }
      }
    }
  }
  cout << cnt;
  return 0;
}
