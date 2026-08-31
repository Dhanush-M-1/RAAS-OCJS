#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int n, m, x, y, i, j, ans = 0, c = 0, sum = 0;
  cin >> n;
  unordered_map<long long int, long long int> mp;
  for (i = 0; i < n; i++) {
    cin >> x;
    sum += x;
  }
  long long int sumb = 0;
  for (i = 0; i < n - 1; i++) {
    cin >> x;
    sumb += x;
  }
  cout << sum - sumb << "\n";
  sum = 0;
  for (i = 0; i < n - 2; i++) {
    cin >> x;
    sum += x;
  }
  cout << sumb - sum << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
