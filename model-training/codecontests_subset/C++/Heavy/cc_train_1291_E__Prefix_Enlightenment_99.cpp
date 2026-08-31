#include <bits/stdc++.h>
using namespace std;
int test = 0;
const int MAXN = 300009;
const long long MOD = 119 << 23 | 1;
class {
 public:
  vector<int> V[MAXN];
  int fa[MAXN * 2], cnt[MAXN * 2];
  int n, m;
  int curset[MAXN * 2], ans;
  int findfa(int x) {
    if (fa[x] == x) return x;
    return fa[x] = findfa(fa[x]);
  }
  void merge(int x, int y) {
    x = findfa(x);
    y = findfa(y);
    if (x == y) return;
    if (x > y) swap(x, y);
    fa[y] = x;
    cnt[x] += cnt[y];
  }
  void solve() {
    cin >> n >> m;
    string s;
    cin >> s;
    for (int i = 1; i <= m; ++i) {
      int c;
      cin >> c;
      for (int j = 0; j < c; ++j) {
        int v;
        cin >> v;
        V[v].push_back(i);
      }
      fa[i] = i;
      fa[i + m] = i + m;
      cnt[i + m] = 1;
    }
    ans = 0;
    for (int i = 1; i <= n; ++i) {
      bool on = s[i - 1] == '1';
      if (V[i].size() == 1) {
        int p = V[i][0];
        if (on) {
          del(p);
          del(p + m);
          merge(p + m, 0);
          add(p);
        } else {
          del(p);
          del(p + m);
          merge(p, 0);
          add(p);
        }
      } else if (V[i].size() == 2) {
        int p0 = V[i][0], p1 = V[i][1];
        if (on) {
          del(p0);
          del(p1);
          del(p1 + m);
          del(p0 + m);
          merge(p0, p1);
          merge(p0 + m, p1 + m);
          add(p0);
        } else {
          del(p0);
          del(p1);
          del(p1 + m);
          del(p0 + m);
          merge(p0, p1 + m);
          merge(p0 + m, p1);
          add(p0);
        }
      }
      cout << ans << '\n';
    }
  }
  void add(int x) {
    int y = x + m;
    x = findfa(x);
    y = findfa(y);
    if (x == 0)
      curset[y] = 1, ans += cnt[y];
    else if (y == 0)
      curset[x] = 1, ans += cnt[x];
    else if (cnt[x] > cnt[y])
      curset[y] = 1, ans += cnt[y];
    else
      curset[x] = 1, ans += cnt[x];
  }
  void del(int x) {
    x = findfa(x);
    if (curset[x]) {
      ans -= cnt[x];
      curset[x] = 0;
    }
  }
} NSPACE;
int main() {
  ios_base::sync_with_stdio(false);
  cout.tie(0);
  cin.tie(0);
  NSPACE.solve();
}
