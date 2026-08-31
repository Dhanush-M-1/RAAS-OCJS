#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool chkmin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T>
inline bool chkmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
const int oo = 0x3f3f3f3f;
const int maxn = 1000, maxq = 1000;
const int maxm = 500000;
struct edge {
  int first, second, w, id;
  edge() {}
  edge(int _x, int _y, int _w) : first(_x), second(_y), w(_w) {}
  friend bool operator<(const edge &first, const edge &second) {
    return first.w > second.w;
  }
};
int n, m, qn;
edge e[maxm + 5];
int fa[maxn + 5], col[maxn + 5];
int get(int first) {
  if (fa[first] == first) return first;
  int tmp = get(fa[first]);
  col[first] ^= col[fa[first]];
  return fa[first] = tmp;
}
int main() {
  scanf("%d%d%d", &n, &m, &qn);
  for (int i = (0), i_end_ = (m); i < i_end_; ++i)
    scanf("%d%d%d", &e[i].first, &e[i].second, &e[i].w), --e[i].first,
        --e[i].second, e[i].id = i;
  sort(e, e + m);
  for (int i = (0), i_end_ = (qn); i < i_end_; ++i) {
    int u, v;
    scanf("%d%d", &u, &v), --u;
    for (int j = (0), j_end_ = (n); j < j_end_; ++j) fa[j] = j, col[j] = 0;
    int ret = -1;
    for (int j = (0), j_end_ = (m); j < j_end_; ++j)
      if (e[j].id >= u && e[j].id < v) {
        int first = e[j].first, second = e[j].second;
        if (get(first) != get(second)) {
          int u = get(first), v = get(second);
          col[u] ^= col[first] ^ col[second] ^ 1;
          fa[u] = v;
        } else if (col[first] == col[second]) {
          ret = e[j].w;
          break;
        }
      }
    printf("%d\n", ret);
  }
  return 0;
}
