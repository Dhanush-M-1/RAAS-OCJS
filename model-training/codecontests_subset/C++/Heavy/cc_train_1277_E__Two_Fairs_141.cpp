#include <bits/stdc++.h>
#pragma optimization_level 3
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math,O3")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
const long long MOD = 1e+9 + 7;
const int INFi = 0x7f7f7f7f;
const long long MAXN = 2e+5 + 7;
vector<long long> adj[MAXN];
long long visit[MAXN] = {};
int dx8[] = {0, 1, 1, 1, 0, -1, -1, -1}, dy8[] = {1, 1, 0, -1, -1, -1, 0, 1};
int dx4[] = {0, 1, 0, -1}, dy4[] = {1, 0, -1, 0};
int qq;
long long n = 0, m, a, b, x, y;
long long ct = 0;
void dfs(long long child, long long no) {
  visit[child] = 1;
  ct++;
  for (auto it : adj[child]) {
    if (!visit[it] && it != no) dfs(it, no);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout << fixed;
  cout << setprecision(10);
  ;
  mt19937 rnd(chrono::steady_clock::now().time_since_epoch().count());
  ;
  cin >> qq;
  while (qq--) {
    long long cnt1 = 0, cnt2 = 0;
    for (long long i = (1); i <= n; i++) adj[i].clear();
    cin >> n >> m >> a >> b;
    for (long long i = 0; i < m; i++) {
      cin >> x >> y;
      adj[x].push_back(y);
      adj[y].push_back(x);
    }
    fill_n(visit, n + 1, 0);
    dfs(a, b);
    cnt1 = n - ct - 1;
    ct = 0;
    fill_n(visit, n + 1, 0);
    dfs(b, a);
    cnt2 = n - ct - 1;
    ct = 0;
    cout << cnt1 * cnt2;
    cout << "\n";
  }
}
