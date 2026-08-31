#include <bits/stdc++.h>
using namespace std;
int m[1005];
void solve() {
  int n, m1;
  cin >> n >> m1;
  for (int i = 1; i <= 1003; i++) m[i] = 0;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    m[x]++;
  }
  int y = 0;
  for (int i = 1; i <= m1; i++) {
    int x;
    cin >> x;
    if (m[x] > 0) {
      y = x;
    }
  }
  if (y == 0)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    cout << 1 << ' ' << y << endl;
  }
}
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  cin >> t;
  for (int i = 1; i <= t; i++) {
    solve();
  }
}
