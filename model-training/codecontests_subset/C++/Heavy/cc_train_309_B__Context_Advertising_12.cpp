#include <bits/stdc++.h>
using namespace std;
const int H = 20;
const int N = 2500000 + 10;
string str[N];
char ss[2 * N];
int a[N], par[H][N], second[N];
int get(int h, int v) {
  if (par[h][v] != -1) return par[h][v];
  return par[h][v] = get(h - 1, get(h - 1, v));
}
int main() {
  memset(par, -1, sizeof par);
  int n, r, c;
  cin >> n >> r >> c;
  for (int i = 0; i < n; ++i) {
    int x;
    scanf("%s", ss);
    str[i] = string(ss);
    a[i] = str[i].size();
  }
  second[0] = a[0];
  for (int i = 1; i < n; ++i) second[i] = second[i - 1] + a[i];
  for (int i = 0; i < H; ++i) par[i][n] = n;
  for (int i = 0; i < n; ++i) {
    if (a[i] > c) {
      par[0][i] = i;
      continue;
    }
    int l = i, r = n, m;
    while (l + 1 < r) {
      m = (l + r) / 2;
      int sm = second[m] - (i == 0 ? 0 : second[i - 1]) + m - i;
      if (sm > c)
        r = m;
      else
        l = m;
    }
    par[0][i] = l + 1;
  }
  int ans = 0, idans = -1;
  for (int i = 0; i < n; ++i) {
    int v = i, lev = r;
    for (int j = 0; lev; ++j, lev >>= 1)
      if (lev & 1) v = get(j, v);
    if (v - i > ans) {
      ans = v - i;
      idans = i;
    }
  }
  if (idans == -1) return 0;
  for (int i = idans, j = 0; j < r; ++j, i = get(0, i)) {
    if (i > idans + ans - 1) break;
    int end = get(0, i);
    for (int e = i; e + 1 < end; ++e) printf("%s ", str[e].c_str());
    printf("%s\n", str[end - 1].c_str());
  }
  return 0;
}
