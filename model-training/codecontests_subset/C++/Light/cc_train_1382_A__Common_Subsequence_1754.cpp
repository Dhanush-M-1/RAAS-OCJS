#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, i, j, c, n, m, flag;
  int A[10000], B[10000];
  cin >> t;
  while (t--) {
    cin >> n >> m;
    for (i = 0; i < n; i++) cin >> A[i];
    for (i = 0; i < m; i++) cin >> B[i];
    flag = 0;
    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) {
        if (A[i] == B[j]) {
          c = A[i];
          flag = 1;
          break;
        }
      }
    }
    if (flag == 0)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << 1 << " " << c << endl;
    }
  }
}
