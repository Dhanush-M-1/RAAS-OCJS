#include <bits/stdc++.h>
using namespace std;
int xx[4] = {0, 0, 1, -1};
int yy[4] = {1, -1, 0, 0};
int n, m;
vector<int> a[int(1e5 + 100)];
vector<int> d[int(1e5 + 100)];
int cha[int(1e5 + 100)];
void dfs(int x) {
  for (int i = (0), _b = (a[x].size() - 1); i <= _b; i++) {
    int y = a[x][i];
    if (y != cha[x]) {
      cha[y] = x;
      dfs(y);
      if (d[y].size() % 2 == 1) {
        d[y].push_back(x);
      } else {
        d[x].push_back(y);
      }
    }
  }
}
int lab[int(1e5 + 100)];
int root(int x) {
  while (lab[x] > 0) x = lab[x];
  return x;
}
void uni(int x, int y) {
  if (lab[x] > lab[y]) swap(x, y);
  lab[x] += lab[y];
  lab[y] = x;
}
int main() {
  scanf("%d%d", &n, &m);
  if (m % 2 == 1) {
    cout << "No solution" << endl;
    return 0;
  }
  for (int i = (1), _b = (n); i <= _b; i++) lab[i] = -1;
  for (int i = (1), _b = (m); i <= _b; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    int u = root(x);
    int v = root(y);
    if (u != v) {
      uni(u, v);
      a[x].push_back(y);
      a[y].push_back(x);
    } else {
      d[x].push_back(y);
    }
  }
  dfs(1);
  for (int i = (1), _b = (n); i <= _b; i++)
    for (int j = 0; j + 1 < d[i].size(); j += 2) {
      printf("%d %d %d\n", d[i][j], i, d[i][j + 1]);
    }
}
