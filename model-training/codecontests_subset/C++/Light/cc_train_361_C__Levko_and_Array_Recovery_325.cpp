#include <bits/stdc++.h>
using namespace std;
const int maxn = 5005;
const int INF = 1e9;
struct s {
  int t, li, ri, d;
  s(){};
  s(int t1, int l1, int r1, int d1) { t = t1, li = l1, ri = r1, d = d1; }
};
vector<s> Q;
int A[maxn], B[maxn];
int diff[maxn];
inline void solve(void) {
  int n, m, x, l, r, f;
  cin >> n >> m;
  for (int i = (0); i < (m); i++) {
    cin >> x >> l >> r >> f;
    Q.push_back(s(x, l, r, f));
  }
  for (int i = 1; i <= n; i++) A[i] = INF;
  for (int i = 0; i < m; i++) {
    int t = Q[i].t, l = Q[i].li, r = Q[i].ri, m = Q[i].d;
    if (t == 2) {
      for (int j = l; j <= r; j++) A[j] = min(A[j], m - diff[j]);
    }
    if (t == 1) {
      for (int j = l; j <= r; j++) diff[j] += m;
    }
  }
  for (int i = 1; i <= n; i++) B[i] = A[i];
  for (int i = 0; i < m; i++) {
    int t = Q[i].t, l = Q[i].li, r = Q[i].ri, m = Q[i].d;
    if (t == 1)
      for (int j = l; j <= r; j++) A[j] += m;
    if (t == 2) {
      int M = -INF;
      for (int j = l; j <= r; j++) M = max(A[j], M);
      if (M != m) {
        cout << "NO\n";
        return;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; i++) cout << B[i] << " ";
}
void init() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
}
int main(int argc, const char* argv[]) {
  init();
  solve();
  return 0;
}
