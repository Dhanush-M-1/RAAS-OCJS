#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5e5 + 10, MAXM = 2e6 + 10;
const int INF = INT_MAX, SINF = 0x3f3f3f3f;
const long long llINF = LLONG_MAX;
const int MOD = 1e9 + 7, mod = 998244353;
long long tr[MAXN], tot, n, t[MAXN];
void add(int x, long long val) {
  while (x <= n) {
    tr[x] += val;
    t[x] += 1;
    x += x & -x;
  }
}
pair<long long, long long> query(int x) {
  long long ans = 0, ans1 = 0;
  while (x) {
    ans += tr[x];
    ans1 += t[x];
    x -= x & -x;
  }
  return {ans, ans1};
}
struct Node {
  long long x, v;
  bool operator<(const Node &rhs) const { return x < rhs.x; }
} e[MAXN];
vector<long long> v;
map<long long, long long> mp;
int main() {
  scanf("%lld", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &e[i].x);
  for (int i = 1; i <= n; i++) scanf("%lld", &e[i].v), v.push_back(e[i].v);
  sort(e + 1, e + n + 1);
  sort(v.begin(), v.end());
  v.resize(unique(v.begin(), v.end()) - v.begin());
  for (int i = 0; i < ((int)v.size()); i++) mp[v[i]] = i + 1;
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    pair<long long, long long> tmp = query(mp[e[i].v]);
    ans += e[i].x * tmp.second - tmp.first;
    add(mp[e[i].v], e[i].x);
  }
  printf("%lld", ans);
  return 0;
}
