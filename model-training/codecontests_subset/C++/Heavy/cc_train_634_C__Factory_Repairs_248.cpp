#include <bits/stdc++.h>
using namespace std;
void read_file(bool outToFile = true) {}
int n;
int K;
int a, b;
int q;
int arr[2];
int ST[2][3 * 200000 + 9 + 1 + 9];
int GS, GE;
void update(int idx, int val, int who, int s = GS, int e = GE, int p = 1) {
  if (s == e) {
    ST[who][p] = min(arr[who], ST[who][p] + val);
    return;
  }
  int m = s + e;
  m /= 2;
  if (idx <= m)
    update(idx, val, who, s, m, 2 * p);
  else
    update(idx, val, who, m + 1, e, 2 * p + 1);
  ST[who][p] = ST[who][2 * p] + ST[who][2 * p + 1];
}
int query(int fr, int to, int who, int s = GS, int e = GE, int p = 1) {
  if (fr <= s && e <= to) return ST[who][p];
  if (fr > e || to < s) return 0;
  int m = s + e;
  m /= 2;
  int ql = query(fr, to, who, s, m, 2 * p);
  int qr = query(fr, to, who, m + 1, e, 2 * p + 1);
  return ql + qr;
}
void init() {
  GS = 0, GE = n - 1;
  memset(ST[0], 0, sizeof ST[0]);
  memset(ST[1], 0, sizeof ST[1]);
}
int main() {
  read_file();
  while (scanf("%d", &n) != EOF) {
    scanf("%d%d%d%d", &K, &a, &b, &q);
    arr[0] = a, arr[1] = b;
    init();
    while (q--) {
      int cmd;
      scanf("%d", &cmd);
      if (cmd == 1) {
        int idx, val;
        scanf("%d%d", &idx, &val);
        idx--;
        update(idx, val, 0);
        update(idx, val, 1);
      } else {
        int idx;
        scanf("%d", &idx);
        idx--;
        int ans = 0;
        if (idx - 1 >= 0) ans += query(0, idx - 1, 1);
        if (idx + K - 1 + 1 <= n - 1) ans += query(idx + K - 1 + 1, n - 1, 0);
        printf("%d\n", ans);
      }
    }
    printf("\n");
  }
}
