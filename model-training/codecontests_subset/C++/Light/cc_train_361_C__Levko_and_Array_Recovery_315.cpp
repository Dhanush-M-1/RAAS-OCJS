#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> re(n, 1000000000);
  vector<int> plus(n, 0);
  vector<int> A(m), B(m), C(m), D(m);
  for (int i = 0; i < m; i++) {
    cin >> A[i] >> B[i] >> C[i] >> D[i];
    int a = A[i], b = B[i], c = C[i], d = D[i];
    if (a == 1) {
      for (int k = b - 1; k < c; k++) {
        plus[k] += d;
      }
    } else {
      bool found = false;
      for (int k = b - 1; k < c; k++) {
        int most = d - plus[k];
        if (most <= re[k]) {
          re[k] = most;
          found = true;
        }
      }
      if (!found) {
        cout << "NO";
        return 0;
      }
    }
  }
  vector<int> p(n, 0);
  for (int i = 0; i < m; i++) {
    int a = A[i], b = B[i], c = C[i], d = D[i];
    if (a == 1) {
      for (int k = b - 1; k < c; k++) {
        p[k] += d;
      }
    } else {
      bool found = false;
      for (int k = b - 1; k < c; k++) {
        int most = d - p[k];
        if (most <= re[k]) {
          found = true;
        }
      }
      if (!found) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i : re) {
    cout << i << " ";
  }
}
