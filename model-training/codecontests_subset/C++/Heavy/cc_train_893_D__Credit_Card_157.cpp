#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
int bourles[maxn];
pair<int, int> checked[maxn];
void compress(int n, int& m) {
  int p = 1;
  m = 0;
  while (p <= n) {
    int cnt = 0;
    while (p <= n && (bourles[p] || (!bourles[p] && cnt >= 0)))
      cnt += bourles[p++];
    if (p <= n) checked[++m] = pair<int, int>(p, cnt);
  }
}
void solve(int& ret, int n, int m, int d) {
  ret = 0;
  int p = 1;
  while (p <= m) {
    ++ret;
    int L = p, R = m;
    while (L < R) {
      int mid = L + ((R - L + 1) >> 1);
      int cnt = 0;
      for (int i = p + 1; i <= mid; ++i) cnt += checked[i].second;
      bool ok = true;
      int somemax = -cnt;
      for (int i = checked[p].first; i <= checked[mid].first; ++i) {
        somemax += bourles[i];
        if (somemax > d) {
          ok = false;
          break;
        }
      }
      if (ok)
        L = mid;
      else
        R = mid - 1;
    }
    p = L + 1;
  }
}
int main() {
  int n, d;
  while (~scanf("%d%d", &n, &d)) {
    int somemax = 0, zero = 0;
    bool ok = true;
    for (int i = 1; i <= n; ++i) {
      scanf("%d", bourles + i);
      if (!bourles[i]) {
        ++zero;
        if (somemax < 0) somemax = 0;
      }
      if (bourles[i] + somemax > d) ok = false;
      somemax += bourles[i];
    }
    if (!ok) {
      puts("-1");
      continue;
    }
    int m;
    compress(n, m);
    if (!zero || !n) {
      puts("0");
      continue;
    }
    int ret;
    solve(ret, n, m, d);
    printf("%d\n", ret);
  }
  return 0;
}
