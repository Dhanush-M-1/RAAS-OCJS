#include <bits/stdc++.h>
using namespace std;
const int N = 300000 + 10;
char s[N];
int par[N], diff[N];
pair<int, int> find(int x) {
  if (par[x] == x) return {x, 0};
  auto r = find(par[x]);
  par[x] = r.first, diff[x] ^= r.second;
  return {par[x], diff[x]};
}
int f[N][2], col[N], ans;
int get(int x) {
  if (col[x] == -1) return min(f[x][0], f[x][1]);
  return f[x][col[x]];
}
vector<int> p[N];
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  scanf("%s", s + 1);
  for (int i = 1; i <= k; i++) {
    int x;
    scanf("%d", &x);
    for (int j = 1; j <= x; j++) {
      int y;
      scanf("%d", &y);
      p[y].push_back(i);
    }
  }
  for (int i = 1; i <= k; i++)
    par[i] = i, diff[i] = 0, f[i][0] = 0, f[i][1] = 1, col[i] = -1;
  for (int i = 1; i <= n; i++) {
    if ((int)p[i].size() == 0)
      ;
    else if ((int)p[i].size() == 1) {
      int x = p[i][0], y = find(x).first;
      ans -= get(y);
      col[y] = diff[x] ^ (s[i] == '0');
      ans += get(y);
    } else {
      int x = find(p[i][0]).first, y = find(p[i][1]).first;
      if (x != y) {
        ans -= get(x), ans -= get(y);
        par[x] = y;
        diff[x] = (s[i] == '0') ^ diff[p[i][0]] ^ diff[p[i][1]];
        f[y][0] += f[x][0 ^ diff[x]], f[y][1] += f[x][1 ^ diff[x]];
        if (col[x] != -1) col[y] = col[x] ^ diff[x];
        ans += get(y);
      }
    }
    printf("%d\n", ans);
  }
}
