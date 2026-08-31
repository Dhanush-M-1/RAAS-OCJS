#include <bits/stdc++.h>
using namespace std;
void solve();
int main() {
  ios::sync_with_stdio(0);
  solve();
  return 0;
}
void solve() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  long long cnt = 0;
  for (int i = 0; i <= b; i++) {
    for (int j = 0; j <= c; j++) {
      int v = n - i - 2 * j;
      if (v >= 0) {
        v *= 2;
        if (v <= a) ++cnt;
      }
    }
  }
  cout << cnt << '\n';
}
