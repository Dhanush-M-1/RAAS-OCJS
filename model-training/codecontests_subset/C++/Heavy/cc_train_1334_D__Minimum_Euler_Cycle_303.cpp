#include <bits/stdc++.h>
using namespace std;
long long n, l, r, curr;
void solve(long long depth = 0) {
  if (depth == n) {
    if ((curr <= r)) cout << 1 << " ";
    return;
  }
  if ((curr + 2 * (n - depth - 1) - 1) < l) {
    curr += 2 * (n - depth - 1);
    solve(depth + 1);
    return;
  } else if ((curr > r)) {
    return;
  } else {
    for (int i = 1; i <= 2 * (n - depth - 1); i++) {
      if ((curr >= l) && (curr <= r)) {
        if (curr % 2) {
          cout << (1 + depth) << " ";
        } else {
          cout << (i / 2) + depth + 1 << " ";
        }
      }
      curr++;
    }
    solve(depth + 1);
    return;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    curr = 1;
    cin >> n >> l >> r;
    solve();
    cout << endl;
  }
  return 0;
}
