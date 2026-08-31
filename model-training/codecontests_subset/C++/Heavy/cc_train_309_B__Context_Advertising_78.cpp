#include <bits/stdc++.h>
using namespace std;
const int N = 7e6 + 10;
const int M = 1e6 + 10;
char s[N];
int word[N];
int f[M], st[M], a[M], buff[M], g[M];
int ret[M];
void power(int k, int n) {
  for (int i = 0; i <= n; i++) ret[i] = i;
  while (k) {
    if (k & 1) {
      for (int i = 0; i <= n; i++) buff[i] = ret[f[i]];
      for (int i = 0; i <= n; i++) ret[i] = buff[i];
    }
    for (int i = 0; i <= n; i++) buff[i] = f[f[i]];
    for (int i = 0; i <= n; i++) f[i] = buff[i];
    k >>= 1;
  }
}
int main() {
  int n, r, c;
  int curr = 0;
  scanf("%d %d %d", &n, &r, &c);
  for (int i = 0; i < n; i++) {
    st[i] = curr;
    scanf("%s", s + curr);
    for (; s[curr]; curr++) {
      word[curr] = i;
      a[i]++;
    }
    word[curr] = i;
    curr++;
  }
  f[n] = n;
  for (int i = n - 1; i >= 0; i--) {
    int nxt = st[i] + c;
    if (nxt >= curr)
      f[i] = n;
    else if (s[nxt] == 0) {
      f[i] = word[nxt] + 1;
    } else
      f[i] = word[nxt];
    g[i] = f[i];
  }
  power(r, n);
  int ans = 0;
  int mxind = 0;
  for (int i = 0; i < n; i++) {
    if (ret[i] - i > ans) mxind = i;
    ans = max(ans, ret[i] - i);
  }
  for (int i = mxind; i < mxind + ans;) {
    for (int j = i; j < g[i]; j++) {
      printf("%s", s + st[j]);
      if (j != g[i] - 1) printf(" ");
    }
    printf("\n");
    i = g[i];
  }
}
