#include <bits/stdc++.h>
using namespace std;
struct unionFind {
  vector<int> u;
  vector<int> us;
  vector<int> ucol;
  unionFind(int n) : u(n + 1), us(n + 1), ucol(n + 1) {
    for (int i = 1; i <= n; i++) {
      u[i] = i;
      us[i] = 1;
      ucol[i] = 0;
    }
  }
  int get(int x) {
    if (x == u[x]) return x;
    int res = get(u[x]);
    ucol[x] ^= ucol[u[x]];
    u[x] = res;
    return u[x];
  }
  void un(int a0, int b0) {
    int a = get(a0);
    int b = get(b0);
    if (a != b) {
      if (us[a] < us[b]) {
        swap(a, b);
      }
      us[a] += us[b];
      u[b] = a;
      ucol[b] = ucol[a0] ^ ucol[b0] ^ 1;
    }
  }
};
int main() {
  int n, m, q;
  scanf("%d %d %d", &n, &m, &q);
  vector<pair<int, int>> w(m);
  vector<pair<int, int>> e(m);
  for (int i = 0; i < m; ++i) {
    scanf("%d %d %d", &e[i].first, &e[i].second, &w[i].first);
    e[i].first--;
    e[i].second--;
    w[i].second = i;
  }
  sort(w.begin(), w.end(), greater<pair<int, int>>());
  for (int qi = 0; qi < q; ++qi) {
    int l, r;
    scanf("%d %d", &l, &r);
    l--;
    unionFind u(n);
    bool found = false;
    for (auto x : w) {
      if (x.second < l || x.second >= r) continue;
      int a = e[x.second].first, b = e[x.second].second;
      int ra = u.get(a + 1);
      int rb = u.get(b + 1);
      if (ra != rb) {
        u.un(a + 1, b + 1);
      } else {
        if ((u.ucol[ra] ^ u.ucol[a + 1]) == (u.ucol[rb] ^ u.ucol[b + 1])) {
          printf("%d\n", x.first);
          found = true;
          break;
        }
      }
    }
    if (!found) {
      printf("-1\n");
    }
  }
  return 0;
}
