#include <bits/stdc++.h>
using namespace std;
const int N = 2000 + 5;
const int M = 5e5 + 5;
int n, m, q;
vector<int> g[N];
int root[N];
int f(int x) {
  if (x == root[x]) return x;
  return root[x] = f(root[x]);
}
int merge(int x, int y) {
  if (root[f(2 * x - 1)] == f(2 * y) and root[f(2 * y - 1)] == f(2 * x))
    return -1;
  root[f(2 * x - 1)] = f(2 * y);
  root[f(2 * y - 1)] = f(2 * x);
  return f(2 * x) != f(2 * x - 1) and f(2 * y) != f(2 * y - 1);
}
void init() {
  for (int i = 1; i <= 2 * n; i++) {
    root[i] = i;
    g[i].clear();
    g[i].push_back(i);
  }
}
class tree {
 public:
  bool ends;
  vector<pair<int, pair<int, int> > > v;
  tree() { ends = 0; }
  tree operator+(tree oth) {
    tree res;
    vector<pair<int, pair<int, int> > > e;
    e.resize(v.size() + oth.v.size());
    merge(v.begin(), v.end(), oth.v.begin(), oth.v.end(), e.begin(),
          [&](pair<int, pair<int, int> > x, pair<int, pair<int, int> > y) {
            return x.first > y.first;
          });
    init();
    for (int i = 0; i < e.size(); i++) {
      int x, y;
      tie(x, y) = e[i].second;
      int m = merge(x, y);
      if (m >= 0) res.v.push_back(e[i]);
      if (m == 0) {
        res.ends = 1;
        break;
      }
    }
    return res;
  }
} t[M << 1];
int main() {
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    int x, y, c;
    scanf("%d %d %d", &x, &y, &c);
    t[i + M].v.push_back({c, {x, y}});
  }
  for (int i = M - 1; i >= 1; i--) t[i] = t[i + i] + t[i + i + 1];
  for (int i = 1; i <= q; i++) {
    int l, r;
    scanf("%d %d", &l, &r);
    tree ans;
    for (l += M, r += M; l <= r; l = (l + 1) >> 1, r = (r - 1) >> 1) {
      if (l & 1) ans = ans + t[l];
      if (~r & 1) ans = ans + t[r];
    }
    if (!ans.ends)
      puts("-1");
    else
      printf("%d\n", ans.v.back().first);
  }
  return 0;
}
