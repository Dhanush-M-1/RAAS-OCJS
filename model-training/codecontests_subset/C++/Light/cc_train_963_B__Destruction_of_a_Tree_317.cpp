#include <bits/stdc++.h>
const long long INF = 1000000000;
const long long N = 300005;
const long long MOD = 1000000007;
const long long MAXN = 100005;
const long long rootval = 319;
using namespace std;
vector<long long> adj[N];
vector<long long> v;
long long dfs(long long u, long long par) {
  long long curr = 1;
  for (auto v : adj[u]) {
    if (v == par) {
      continue;
    }
    curr = curr + dfs(v, u);
  }
  if (curr % 2 == 0) {
    cout << u + 1 << endl;
  } else {
    v.push_back(u + 1);
  }
  return curr;
}
int main() {
  long long n;
  cin >> n;
  long long p[n + 1];
  for (long long i = 0; i < n; i++) {
    cin >> p[i];
    if (p[i] == 0) {
      continue;
    }
    adj[p[i] - 1].push_back(i);
    adj[i].push_back(p[i] - 1);
  }
  if (n % 2 == 0) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    dfs(0, -1);
    if (!v.empty()) {
      reverse(v.begin(), v.end());
      for (long long i = 0; i < v.size(); i++) {
        cout << v[i] << endl;
      }
    }
  }
}
