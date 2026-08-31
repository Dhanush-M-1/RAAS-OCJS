#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
const int M = 22;
long long mod = 1e9 + 7;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return a * (b / gcd(a, b)); }
bool is_vowel(char c) {
  if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return 1;
  return 0;
}
long long extended_euclidean(long long a, long long b, long long &x,
                             long long &y) {
  if (b == 0) {
    x = 1;
    y = 0;
    return a;
  }
  long long g = extended_euclidean(b, a % b, y, x);
  y -= (a / b) * x;
  return g;
}
long long power(long long base, long long p, long long mod) {
  if (p == 1) return base;
  if (!p) return 1ll;
  long long ret = power(base, p / 2, mod);
  ret *= ret;
  ret %= mod;
  if (p & 1) ret *= base;
  return ret % mod;
}
float Trianglearea(int x1, int y1, int x2, int y2, int x3, int y3) {
  return abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
}
pair<int, int> operator+(pair<int, int> a, pair<int, int> b) {
  pair<int, int> ret = a;
  ret.first += b.first;
  ret.second += b.second;
  return ret;
}
int dsu[N], head[N], sz[N], n, depth[N], cnt[N], par[N], k;
vector<int> adj[N], adj2[N];
int get(int node) {
  return dsu[node] == node ? node : dsu[node] = get(dsu[node]);
}
void merge(int a, int b) {
  a = get(a);
  b = get(b);
  if (a == b) return;
  if (sz[a] < sz[b]) swap(a, b);
  dsu[b] = a;
  cnt[a] += cnt[b];
  head[a] = depth[head[a]] < depth[head[b]] ? head[a] : head[b];
}
void dfs(int node, int p = 0) {
  depth[node] = depth[p] + 1;
  par[node] = p;
  if (adj[node].empty()) cnt[node]++;
  for (auto i : adj[node]) {
    dfs(i, node);
  }
}
void dfs2(int node) {
  for (auto i : adj[node]) {
    dfs2(i);
  }
  if (adj[node].empty()) {
    merge(get(node), get(par[node]));
    int cur = par[head[get(node)]];
    while (cur && depth[cur] + k >= depth[node]) {
      merge(get(node), get(cur));
      cur = par[head[get(node)]];
    }
  }
}
int solve(int node) {
  int ret = 0;
  for (int i : adj2[node]) {
    ret = max(solve(i), ret);
  }
  return ret + cnt[get(node)];
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = (1); i <= (n); ++i) {
    head[i] = dsu[i] = i;
    sz[i] = 1;
  }
  for (int i = (2); i <= (n); ++i) {
    int p;
    scanf("%d", &p);
    adj[p].push_back(i);
  }
  dfs(1);
  dfs2(1);
  for (int i = (1); i <= (n); ++i) {
    for (int j : adj[i]) {
      if (get(i) != get(j)) adj2[get(i)].push_back(get(j));
    }
  }
  cout << solve(get(1));
  return 0;
}
