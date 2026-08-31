#include <bits/stdc++.h>
using namespace std;
const int mxn = 1e6 + 6;
int n, r, c, t = 1, fr[mxn], nxt[mxn], ans[mxn];
char s[6 * mxn];
inline void make(int x) {
  if (!x) return;
  make(x >> 1);
  for (int i = 1; i <= n; ++i) {
    ans[i] = ans[ans[i]];
    if (x & 1) ans[i] = nxt[ans[i]];
  }
}
int main() {
  scanf("%d%d%d", &n, &r, &c);
  for (int i = 1; i <= n; ++i) {
    scanf("%s", s + fr[i]);
    fr[i + 1] = fr[i] + strlen(s + fr[i]);
    s[fr[i + 1]++] = ' ';
  }
  for (int i = n + 1, j = n + 1; i; i--) {
    for (; fr[j] - fr[i] > c + 1; --j)
      ;
    nxt[ans[i] = i] = j;
  }
  make(r);
  for (int i = 2; i <= n; ++i)
    if (ans[i] - i > ans[t] - t) t = i;
  for (int i = 1; i <= r; ++i, t = nxt[t]) {
    for (int j = fr[t]; j + 1 < fr[nxt[t]]; j++) putchar(s[j]);
    putchar('\n');
  }
}
