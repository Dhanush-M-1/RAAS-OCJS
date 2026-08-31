#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
const int N = 1e5 + 7;
const int xinc[] = {0, 0, 1, -1};
const int yinc[] = {1, -1, 0, 0};
void solve() {
  long long n, i, a, b;
  cin >> n;
  ;
  std::vector<long long> adj[n + 1];
  std::vector<bool> visited(n + 1, false);
  queue<long long> q;
  for (i = 0; i < n - 1; i++) {
    cin >> a >> b;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  q.push(1);
  visited[1] = true;
  while (!q.empty()) {
    long long curr = q.front();
    q.pop();
    long long deg = adj[curr].size();
    if (!(deg == 1 || deg > 2)) {
      cout << "NO";
      return;
    }
    for (auto nei : adj[curr]) {
      if (!visited[nei]) {
        q.push(nei);
        visited[nei] = true;
      }
    }
  }
  cout << "YES";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  t = 1;
  while (t--) solve();
  return 0;
}
