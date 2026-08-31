#include <bits/stdc++.h>
inline int two(int n) { return 1 << n; }
inline int test(int n, int b) { return (n >> b) & 1; }
inline void set_bit(int& n, int b) { n |= two(b); }
inline void unset_bit(int& n, int b) { n &= ~two(b); }
inline int last_bit(int n) { return n & (-n); }
inline int ones(int n) {
  int res = 0;
  while (n && ++res) n -= n & (-n);
  return res;
}
long long int gcd(long long int a, long long int b) {
  return (a ? gcd(b % a, a) : b);
}
long long int modPow(long long int a, long long int b, long long int MOD) {
  long long int x = 1, y = a;
  while (b > 0) {
    if (b % 2 == 1) {
      x = (x * y) % MOD;
    }
    b /= 2;
    y = (y * y) % MOD;
  }
  return x;
}
long long int modInverse(long long int a, long long int p) {
  return modPow(a, p - 2, p);
}
using namespace std;
const int N = 2e5 + 5;
vector<int> adj[N];
set<pair<int, int> > myset;
int degree[N], level[N], marked[N], deleted[N];
void dfs(int src, int lvl) {
  marked[src] = 1;
  level[src] = lvl;
  if (degree[src] % 2 == 0) myset.insert({-level[src], src});
  for (auto child : adj[src]) {
    if (!marked[child]) dfs(child, (lvl + 1));
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, u, v, i, root;
  cin >> n;
  for (auto i = (1); i <= (n); i++) {
    cin >> u;
    if (u) {
      adj[u].push_back(i);
      adj[i].push_back(u);
      degree[u]++;
      degree[i]++;
    } else
      root = i;
  }
  dfs(root, 0);
  vector<int> res;
  while (!myset.empty()) {
    auto itr = myset.begin();
    res.push_back(itr->second);
    deleted[itr->second] = 1;
    for (auto x : adj[itr->second]) {
      if (!deleted[x]) {
        degree[x]--;
        degree[itr->second]--;
        if (degree[x] % 2 == 0)
          myset.insert({-level[x], x});
        else
          myset.erase(myset.find({-level[x], x}));
      }
    }
    myset.erase(itr);
  }
  for (auto i = (1); i <= (n); i++) {
    if (degree[i]) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES\n";
  for (auto i = 0; i < (n); i++) cout << res[i] << "\n";
  return 0;
}
