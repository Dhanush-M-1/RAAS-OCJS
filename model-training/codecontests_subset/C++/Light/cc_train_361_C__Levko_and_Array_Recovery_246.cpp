#include <bits/stdc++.h>
using namespace std;
int T[5001], L[5001], R[5001], D[5001], A[5001], B[5001], n, m, i, j;
int main() {
  cin >> n >> m;
  for (i = 1; i <= n; i++) A[i] = 5e7;
  for (i = 1; i <= m; i++) cin >> T[i] >> L[i] >> R[i] >> D[i];
  for (i = m; i >= 1; i--) {
    if (T[i] == 1) {
      for (j = L[i]; j <= R[i]; j++) A[j] -= D[i];
    } else {
      for (j = L[i]; j <= R[i]; j++) A[j] = min(A[j], D[i]);
    }
  }
  for (i = 1; i <= n; i++) B[i] = A[i];
  for (i = 1; i <= m; i++) {
    if (T[i] == 1) {
      for (j = L[i]; j <= R[i]; j++) B[j] += D[i];
    } else {
      for (j = L[i]; j <= R[i]; j++)
        if (B[j] == D[i]) break;
      if (j > R[i]) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (i = 1; i <= n; i++) cout << A[i] << " ";
  cout << endl;
  return 0;
}
