#include <bits/stdc++.h>
using namespace std;
void fastIO() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
void solve() {
  long long int l, r, d;
  cin >> l >> r >> d;
  if (d < l) {
    cout << d << "\n";
    return;
  } else {
    long long int rem = r % d;
    rem = d - rem;
    cout << r + rem << "\n";
    return;
  }
  return;
}
int main() {
  fastIO();
  int q;
  cin >> q;
  while (q--) {
    solve();
  }
  return 0;
}
