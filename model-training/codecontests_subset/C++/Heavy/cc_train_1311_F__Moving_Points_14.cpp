#include <bits/stdc++.h>
#pragma optimization_level 3
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math,O3")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx")
using namespace std;
const long long N = 1e6 + 5;
const long long M = 1e8;
const long long mod = 1e9 + 7;
const long long INF = 0x7f7f7f7f7f7f7f7f;
const int INFi = 0x7f7f7f7f;
long long test = 1, n, a[N], v[N], ct = 1;
vector<long long> sp;
vector<pair<long long, long long> > x;
map<long long, long long> ind;
long long tree[N][2] = {};
void update(int idx, int val, int first) {
  idx++;
  while (idx <= n + 1) {
    tree[idx][first] += val;
    idx += idx & (-idx);
  }
}
long long query(int idx, int first) {
  idx++;
  long long sum = 0;
  while (idx > 0) {
    sum += tree[idx][first];
    idx -= idx & (-idx);
  }
  return sum;
}
void solve() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) cin >> v[i], sp.push_back(v[i]);
  sort(sp.begin(), sp.end());
  for (auto it : sp)
    if (ind[it] == 0) ind[it] = ct++;
  for (int i = 1; i <= n; i++) v[i] = ind[v[i]], x.push_back({a[i], v[i]});
  sort(x.begin(), x.end());
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    ans += query(x[i].second, 0) * x[i].first - query(x[i].second, 1);
    update(x[i].second, 1, 0);
    update(x[i].second, x[i].first, 1);
  }
  cout << ans << " "
       << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout << fixed;
  cout << setprecision(10);
  ;
  for (int i = 1; i <= test; i++) {
    solve();
  }
}
