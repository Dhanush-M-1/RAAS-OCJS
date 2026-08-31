#include <bits/stdc++.h>
using namespace std;
int n, k, near[1010000], d[1010000], f[1010000];
vector<int> son[1010000];
int read() {
  int AK = 1, IOI = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') AK = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    IOI = (IOI << 3) + (IOI << 1) + ch - '0';
    ch = getchar();
  }
  return AK * IOI;
}
void build(int x, int deep) {
  d[x] = deep;
  if (!son[x].size()) {
    near[x] = deep;
    return;
  }
  near[x] = INT_MAX;
  for (register int i = 0; i <= son[x].size() - 1; ++i) {
    build(son[x][i], deep + 1);
    near[x] = min(near[x], near[son[x][i]]);
  }
  return;
}
void dp(int x) {
  if (!son[x].size()) {
    f[x] = 1;
    return;
  }
  f[x] = 0;
  for (register int i = 0; i <= son[x].size() - 1; ++i) {
    dp(son[x][i]);
    if (near[son[x][i]] - d[x] <= k) {
      f[x] += f[son[x][i]];
      f[son[x][i]] = 0;
    }
  }
  return;
}
int answer(int x) {
  int Max = 0;
  if (son[x].size())
    for (register int i = 0; i <= son[x].size() - 1; ++i)
      Max = max(Max, answer(son[x][i]));
  return f[x] + Max;
}
int main() {
  n = read();
  k = read();
  for (register int i = 2; i <= n; ++i) son[read()].push_back(i);
  build(1, 0);
  dp(1);
  cout << answer(1);
  return 0;
}
