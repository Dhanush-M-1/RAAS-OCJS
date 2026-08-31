#include <bits/stdc++.h>
using namespace std;
const long long int inf = 1e18, M = 1e9 + 7;
const long long int N = 1e5 + 5;
vector<long long int> v[N];
void solve() {
  long long int n;
  cin >> n;
  long long int a, b;
  for (long long int i = 1; i < n; ++i) {
    cin >> a >> b;
    v[a].push_back(b);
    v[b].push_back(a);
  }
  for (long long int i = 1; i <= n; ++i) {
    if (v[i].size() == 2ll) {
      cout << "NO";
      return;
    }
  }
  cout << "YES";
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
