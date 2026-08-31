#include <bits/stdc++.h>
using namespace std;
vector<int> g[100001];
int b[100001], gs[100001];
bool c[501][100001];
int K = 200;
bool cx(int x, int y) {
  if (x < 0 || x > 100000 || y < 0 || y > 100000) return 0;
  if (g[x].size() <= K) {
    vector<int>::iterator o = lower_bound(g[x].begin(), g[x].end(), y);
    return o != g[x].end() && *o == y;
  } else
    return c[gs[x]][y];
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1, x, y; i <= n; i++) {
    scanf("%d%d", &x, &y);
    g[x].push_back(y);
  }
  int ans = 0;
  for (int i = 0; i <= 100000; i++) {
    sort(g[i].begin(), g[i].end());
    if (g[i].size() > K) {
      b[++b[0]] = i;
      gs[i] = b[0];
      for (int j = 0; j < g[i].size(); j++) c[b[0]][g[i][j]] = 1;
    }
  }
  for (int i = 0; i <= 100000; i++)
    if (g[i].size() <= K)
      for (int j = 0; j < g[i].size(); j++)
        for (int k = j + 1, l; k < g[i].size(); k++) {
          l = g[i][k] - g[i][j];
          if (cx(i - l, g[i][j]) && cx(i - l, g[i][k])) ans++;
        }
    else
      for (int j = 0; j < i; j++)
        for (int k = 0, l; k < g[j].size(); k++) {
          l = i - j;
          if (cx(i, g[j][k]) && cx(j, g[j][k] + l) && cx(i, g[j][k] + l)) ans++;
        }
  printf("%d", ans);
}
