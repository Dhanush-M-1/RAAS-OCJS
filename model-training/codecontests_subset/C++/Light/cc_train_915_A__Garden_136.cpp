#include <bits/stdc++.h>
using namespace std;
int n, k, a, d;
void solve() {
  cin >> n >> k;
  d = 1;
  for (int i = 1; i <= n; i++) {
    cin >> a;
    if (k % a == 0 && a >= d) d = a;
  }
  cout << (k / d) << "\n";
}
int main() {
  std::ios::sync_with_stdio(0);
  cin.tie(0);
  solve();
  return 0;
}
