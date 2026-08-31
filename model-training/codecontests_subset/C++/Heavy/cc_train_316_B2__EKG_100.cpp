#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3fffffff;
const int PRIME = 999983;
const int MOD = 1000000007;
const int MULTI = 1000000007;
const double EPS = 1e-8;
inline bool isodd(int x) { return x & 1; }
inline bool isodd(long long x) { return x & 1; }
bool vis[100010];
class DisjointSet {
 public:
  int parent[100010], sum[100010];
  void init(int n) {
    for (int i = 0; i <= n; i++) parent[i] = i, sum[i] = 1;
  }
  int find(int x) { return x == parent[x] ? x : (parent[x] = find(parent[x])); }
  void merger(int x, int y) {
    int rtx = find(x);
    int rty = find(y);
    parent[rtx] = rty;
    sum[rty] += sum[rtx];
    vis[rty] = vis[rtx] || vis[rty];
  }
} ds;
set<int> ans;
vector<int> d;
int dp[1100];
int main() {
  int n, x, a;
  scanf("%d%d", &n, &x);
  ds.init(n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a);
    if (a && a != x) {
      ds.merger(a, i);
    }
    if (a == x) vis[ds.find(i)] = true;
  }
  int tmp;
  tmp = ds.sum[ds.find(x)];
  for (int i = 1; i <= n; i++) {
    if (ds.parent[i] != i || i == ds.find(x) || vis[i]) continue;
    d.push_back(ds.sum[i]);
  }
  memset(dp, -1, sizeof(dp));
  dp[0] = 1;
  for (int i = 0; i < d.size(); i++) {
    for (int j = n; j >= d[i]; j--) {
      if (dp[j - d[i]] != -1) dp[j] = 1;
    }
  }
  for (int i = 0; i <= n; i++)
    if (dp[i] != -1) printf("%d\n", i + tmp);
  return 0;
}
