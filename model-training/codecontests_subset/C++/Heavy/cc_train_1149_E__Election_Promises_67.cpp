#include <bits/stdc++.h>
using namespace std;
const int M = 1000000007;
const int MM = 998244353;
const long double PI = acos(-1);
template <typename T, typename U>
static inline void amin(T &x, U y) {
  if (y < x) x = y;
}
template <typename T, typename U>
static inline void amax(T &x, U y) {
  if (x < y) x = y;
}
template <typename T, typename U>
ostream &operator<<(ostream &os, const pair<T, U> &p) {
  return os << '(' << p.first << "," << p.second << ')';
}
const int N = 200005;
vector<int> v[N];
long long h[N];
int mex[N];
bitset<N> vis;
vector<int> mexv[N];
void dfs(int s) {
  vis[s] = 1;
  set<int> st;
  for (auto &j : v[s]) {
    if (!vis[j]) dfs(j);
    st.insert(mex[j]);
  }
  for (int i = 0;; ++i) {
    if (!st.count(i)) {
      mex[s] = i;
      break;
    }
  }
  mexv[mex[s]].push_back(s);
}
int _runtimeTerror_() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) cin >> h[i];
  for (int i = 1; i <= m; ++i) {
    int x, y;
    cin >> x >> y;
    v[x].push_back(y);
  }
  for (int i = 1; i <= n; ++i) {
    if (!vis[i]) dfs(i);
  }
  int win = -1;
  for (int i = 0;; ++i) {
    if (mexv[i].empty()) break;
    long long Xor = 0;
    for (auto &j : mexv[i]) Xor ^= h[j];
    if (Xor != 0) amax(win, i);
  }
  if (win == -1) {
    cout << "LOSE\n";
    return 0;
  }
  cout << "WIN\n";
  vector<long long> ans(n + 1);
  for (int i = 1; i <= n; ++i) ans[i] = h[i];
  long long Xor = 0;
  for (auto &j : mexv[win]) Xor ^= h[j];
  for (auto &j : mexv[win]) {
    if ((Xor ^ h[j]) < h[j]) {
      ans[j] = Xor ^ h[j];
      vector<int> x(win, -1);
      for (int i : v[j]) {
        if (mex[i] > win) continue;
        if (x[mex[i]] == -1) x[mex[i]] = i;
      }
      for (int i = win - 1; i >= 0; --i) {
        long long y = 0;
        for (auto &k : mexv[i]) y ^= h[k];
        ans[x[i]] = y ^ h[x[i]];
      }
      break;
    }
  }
  for (int i = 1; i <= n; ++i) cout << ans[i] << " ";
  cout << "\n";
  return 0;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int TESTS = 1;
  while (TESTS--) _runtimeTerror_();
  return 0;
}
