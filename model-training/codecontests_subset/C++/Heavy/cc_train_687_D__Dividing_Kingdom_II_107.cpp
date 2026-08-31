#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e3 + 5;
const int maxm = 1e6 + 5;
int ufs[maxn], n, m;
struct edg {
  int u, v, w;
  int id;
  edg(int u = 0, int v = 0, int w = 0, int id = 0) : u(u), v(v), w(w), id(id) {}
};
bool cmp(edg a1, edg b1) { return a1.w > b1.w; }
edg a[maxm];
int q;
inline void init() {
  for (int i = 1; i <= n * 2; i++) {
    ufs[i] = i;
  }
}
int find(int u) {
  if (ufs[u] == u) return u;
  return ufs[u] = find(ufs[u]);
}
void join(int u, int v) { ufs[find(u)] = find(v); }
void debug() {
  cout << "print edg" << endl;
  for (int i = 1; i <= m; i++) {
    cout << a[i].u << ' ' << a[i].v << ' ' << a[i].w << ' ' << a[i].id << endl;
  }
  cout << "print edg end" << endl;
}
void printu() {
  cout << "print ufs" << endl;
  for (int i = 1; i <= n * 2; i++) {
    cout << ufs[i] << ' ';
  }
  cout << endl;
}
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &a[i].u, &a[i].v, &a[i].w);
    a[i].id = i;
  }
  sort(a + 1, a + m + 1, cmp);
  while (q--) {
    int l, r;
    init();
    int ans = -1;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= m; i++) {
      if (a[i].id >= l && a[i].id <= r) {
        int u = a[i].u, v = a[i].v;
        if (find(u) == find(v)) {
          ans = a[i].w;
          break;
        } else {
          join(u + n, v);
          join(u, v + n);
        }
      }
    }
    cout << ans << endl;
  }
}
