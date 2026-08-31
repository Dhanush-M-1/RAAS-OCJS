#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
const int N = 1e5 + 5e4 + 2;
const int inf = 2e9;
const long long linf = 4e18;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cerr.tie(0);
  int n, k;
  cin >> n >> k;
  vector<int> alice, bob, common;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a && b)
      common.push_back(t);
    else if (a)
      alice.push_back(t);
    else if (b)
      bob.push_back(t);
  }
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  priority_queue<int, vector<int>, greater<int>> q;
  for (int i = 0; i < common.size(); i++) q.push(common[i]);
  for (int i = 0; i < min(alice.size(), bob.size()); i++)
    q.push(alice[i] + bob[i]);
  if (q.size() < k) {
    cout << -1;
    return 0;
  }
  int ans = 0;
  while (k--) {
    ans += q.top();
    q.pop();
  }
  cout << ans;
  return 0;
}
