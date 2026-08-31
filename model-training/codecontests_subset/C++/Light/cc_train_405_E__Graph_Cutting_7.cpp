#include <bits/stdc++.h>
using namespace std;
vector<tuple<int, int, int> > ans;
vector<int> e[100005];
int dep[100005];
int gao(int x, int src) {
  dep[x] = dep[src] + 1;
  vector<int> u;
  for (int y : e[x])
    if (y != src) {
      if (!dep[y]) {
        int z = gao(y, x);
        if (!z)
          u.push_back(y);
        else
          ans.push_back(tuple<int, int, int>(x, y, z));
      } else if (dep[y] < dep[x]) {
        u.push_back(y);
      }
    }
  for (size_t i = 0; i + 1 < u.size(); i += 2)
    ans.push_back(tuple<int, int, int>(u[i], x, u[i + 1]));
  if (u.size() % 2) return u.back();
  return 0;
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    e[x].push_back(y);
    e[y].push_back(x);
  }
  if (gao(1, 0)) {
    puts("No solution");
  } else
    for (tuple<int, int, int> c : ans) {
      int x, y, z;
      tie(x, y, z) = c;
      printf("%d %d %d\n", x, y, z);
    }
}
