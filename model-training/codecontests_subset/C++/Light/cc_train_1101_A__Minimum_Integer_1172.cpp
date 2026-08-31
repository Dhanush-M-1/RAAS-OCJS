#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios::sync_with_stdio(false);
  int Q;
  cin >> Q;
  while (Q--) {
    int L, R, D;
    cin >> L >> R >> D;
    if (D < L)
      cout << D << endl;
    else {
      int64_t u = R / D * D;
      while (u <= R) u += D;
      cout << u << endl;
    }
  }
  return 0;
}
