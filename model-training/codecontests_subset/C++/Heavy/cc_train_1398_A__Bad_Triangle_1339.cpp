#include <bits/stdc++.h>
using namespace std;
const long long int modu = 1e9 + 7;
int noofdig(int N) { return floor(log10(N)) + 1; }
int bits_count(unsigned int u) {
  unsigned int uCount;
  uCount = u - ((u >> 1) & 033333333333) - ((u >> 2) & 011111111111);
  return ((uCount + (uCount >> 3)) & 030707070707) % 63;
}
long long int f(long long int a) { return 0; }
void pre() {}
void solve() {
  int n;
  cin >> n;
  vector<int> a(n);
  for (auto &t : a) cin >> t;
  if (a[0] + a[1] <= a[n - 1]) {
    cout << 1 << " " << 2 << " " << n << '\n';
    return;
  }
  cout << -1 << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
}
