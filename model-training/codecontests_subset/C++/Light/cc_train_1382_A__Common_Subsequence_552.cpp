#include <bits/stdc++.h>
using namespace std;
int n, m;
int A[1006], B[1006];
void solve() {
  unordered_map<int, int> mp;
  for (int i = 1; i <= n; i++) mp[A[i]]++;
  for (int i = 1; i <= m; i++) {
    if (mp[B[i]] != 0) {
      cout << "YES\n";
      cout << 1 << " " << B[i] << "\n";
      return;
    }
  }
  cout << "NO\n";
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> A[i];
    for (int i = 1; i <= m; i++) cin >> B[i];
    solve();
  }
  return 0;
}
