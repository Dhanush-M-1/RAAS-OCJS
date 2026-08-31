#include <bits/stdc++.h>
using namespace std;
const int INF = (int)2e9;
const long long INFL = (long long)9e18;
const int MAXINT = ((~0) ^ (1 << 31));
const long long MAXLL = ((~0) ^ ((long long)1 << 63));
template <class T>
inline T pow2(T a) {
  return a * a;
}
template <class T>
inline bool mineq(T& a, T b) {
  return (a > b) ? (a = b, true) : false;
}
template <class T>
inline bool maxeq(T& a, T b) {
  return (a < b) ? (a = b, true) : false;
}
const int maxn = 4e5;
long long n, mark[maxn], p, r, val[maxn], d[maxn];
vector<long long> g[maxn];
deque<long long> dq, ans;
void dfs(long long v, long long p) {
  dq.push_front(v);
  mark[v] = 1;
  for (int i = 0; i < g[v].size(); i++) {
    if (!mark[g[v][i]]) {
      dfs(g[v][i], v);
      val[v] += val[g[v][i]];
    }
  }
  val[v]++;
  if (d[v] % 2 == 0) {
    for (int i = val[v] - 1; i >= 0; i--) ans.push_back(dq[i]);
    for (int i = 0; i < val[v]; i++) dq.pop_front();
    d[p]--;
    val[v] = 0;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> p;
    if (p == 0)
      r = i;
    else {
      g[p].push_back(i);
      g[i].push_back(p);
    }
  }
  for (int i = 1; i <= n; i++) d[i] = g[i].size();
  dfs(r, 0);
  if (ans.size() != n)
    cout << "NO";
  else {
    cout << "YES" << endl;
    for (int i = 0; i < n; i++) cout << ans[i] << endl;
  }
}
