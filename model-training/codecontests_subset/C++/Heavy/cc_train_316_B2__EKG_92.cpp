#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const int inf = 10000000;
int g[1005];
bool vis[1005];
vector<int> v, vv;
int cou;
int x, n;
bool gotit;
bool res[1005];
void dfs(int u) {
  cou++;
  if (x == u) {
    gotit = 1;
    return;
  }
  if (g[u] == -1) return;
  dfs(g[u]);
}
int main() {
  cin >> n >> x;
  x--;
  memset((g), (-1), sizeof(g));
  int a;
  for (int i = 0; i < (n); i++) {
    scanf("%d", &a);
    if (!a)
      v.push_back(i);
    else {
      a--;
      g[a] = i;
    }
  }
  int mysize;
  for (int i = 0; i < (((int)(v).size())); i++) {
    cou = 0;
    gotit = 0;
    dfs(v[i]);
    if (gotit)
      mysize = cou;
    else
      vv.push_back(cou);
  }
  res[0] = 1;
  for (int i = 0; i < (((int)(vv).size())); i++)
    for (int j = n; j >= 0; j--) {
      int t = vv[i];
      if (j + t > n) continue;
      res[j + t] |= res[j];
    }
  for (int i = 0; i < (n + 1); i++)
    if (res[i]) printf("%d\n", i + mysize);
  return 0;
}
