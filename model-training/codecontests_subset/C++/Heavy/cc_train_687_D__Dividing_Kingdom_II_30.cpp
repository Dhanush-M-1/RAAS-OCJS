#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
const int INF = 1e9 + 7;
const long long INF64 = 1e18;
const double EPS = 1e-9;
const double PI = acos(-1);
const long long MD = 1551513443;
const long long T = 25923;
const int N = 1000100;
const int M = 1001;
struct st {
  int v, u, w, ind;
  st() { v = u = w = ind = 0; }
  st(int vv, int uu, int ww, int ii) {
    v = vv;
    u = uu;
    w = ww;
    ind = ii;
  }
} e[N];
bool operator<(st a, st b) { return a.w < b.w; }
int n, m, q, rr[M], b[N];
pair<int, int> p[M];
int main() {
  cin >> n >> m >> q;
  for (int i = 0; i < int(m); i++) {
    int v, u, w;
    scanf("%d %d %d", &v, &u, &w);
    e[i] = st(v, u, w, i);
  }
  sort(e, e + m);
  reverse(e, e + m);
  int ans, v, u, first, second, j;
  pair<int, int> vv, uu;
  for (int u1 = 0; u1 < int(q); u1++) {
    int l, r;
    scanf("%d %d", &l, &r);
    l--;
    r--;
    ans = -1;
    for (int i = 0; i < int(M); i++) {
      p[i] = make_pair(i, 0);
      rr[i] = 0;
    }
    for (int i = 0; i < int(m); i++)
      if (e[i].ind >= l && e[i].ind <= r) {
        b[0] = e[i].v;
        j = -1;
        for (int ii = 0; b[ii] != p[b[ii]].first; ii++) {
          j = ii;
          b[ii + 1] = p[b[ii]].first;
        }
        for (int ii = j; ii >= 0; ii--) {
          p[b[ii]].second ^= p[b[ii + 1]].second;
          p[b[ii]].first = p[b[ii + 1]].first;
        }
        vv = p[b[0]];
        b[0] = e[i].u;
        j = -1;
        for (int ii = 0; b[ii] != p[b[ii]].first; ii++) {
          j = ii;
          b[ii + 1] = p[b[ii]].first;
        }
        for (int ii = j; ii >= 0; ii--) {
          p[b[ii]].second ^= p[b[ii + 1]].second;
          p[b[ii]].first = p[b[ii + 1]].first;
        }
        uu = p[b[0]];
        first = vv.second;
        v = vv.first;
        second = uu.second;
        u = uu.first;
        if (v == u) {
          if (first == second) {
            ans = e[i].w;
            break;
          }
        } else {
          if (rr[u] > rr[v]) swap(v, u);
          p[u] = make_pair(v, first ^ second ^ 1);
          if (rr[v] == rr[u]) rr[v]++;
        }
      }
    printf("%d\n", ans);
  }
  return 0;
}
