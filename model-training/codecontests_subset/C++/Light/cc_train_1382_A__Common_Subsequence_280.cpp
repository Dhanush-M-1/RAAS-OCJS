#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, i, m, A[1000], B[1000], note, f = 0;
    cin >> n >> m;
    for (i = 0; i < n; i++) {
      cin >> A[i];
    }
    for (i = 0; i < m; i++) cin >> B[i];
    sort(B, B + m);
    for (i = 0; i < n; i++) {
      if (binary_search(B, B + m, A[i])) {
        note = A[i];
        f = 1;
        break;
      }
    }
    if (f == 0)
      cout << "NO";
    else {
      cout << "YES\n";
      cout << "1 " << note;
    }
    cout << "\n";
  }
}
