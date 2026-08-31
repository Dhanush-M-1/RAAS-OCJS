#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
long long mod = 1000000007;
const int MX = 0x3f3f3f;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, i, u, v;
  cin >> n;
  vector<int> adj[n];
  for (i = 0; i <= n - 2; i++) {
    cin >> u >> v;
    adj[u - 1].emplace_back(v - 1);
    adj[v - 1].emplace_back(u - 1);
  }
  if (n == 2) {
    cout << "YES";
    return 0;
  }
  for (i = 0; i <= n - 1; i++) {
    if (adj[i].size() == 1) continue;
    if (adj[i].size() < 3) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
