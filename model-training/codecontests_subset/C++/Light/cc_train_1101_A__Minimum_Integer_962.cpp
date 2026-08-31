#include <bits/stdc++.h>
using namespace std;
const int INF = 1 << 29;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  int q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l || d > r) {
      cout << d << endl;
      continue;
    } else {
      cout << (r / d) * d + d << endl;
    }
  }
  return 0;
}
