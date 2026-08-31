#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
const int N = 1010000;
int nxt[N], f[N], ret[N], len[N];
int n, r, c;
char s[N * 6];
int main() {
  scanf("%d%d%d", &n, &r, &c);
  ++c;
  int l = 0;
  for (int i = 1; i < n + 1; i++) {
    scanf("%s", s + l);
    int pl = strlen(s + l);
    len[i] = len[i - 1] + pl + 1;
    l += pl + 1;
    s[l - 1] = ' ';
  }
  int t = 0;
  for (int i = 1; i < n + 1; i++) {
    while (t <= n && len[t] - len[i - 1] <= c) t++;
    nxt[i] = t;
  }
  nxt[n + 1] = n + 1;
  for (int i = 1; i < n + 2; i++) ret[i] = i, f[i] = nxt[i];
  for (int b = r; b; b >>= 1) {
    if (b & 1)
      for (int i = 1; i < n + 1; i++) ret[i] = f[ret[i]];
    for (int i = 1; i < n + 1; i++) f[i] = f[f[i]];
  }
  int rp = 1, rc = ret[1] - 1;
  for (int i = 2; i < n + 1; i++)
    if (ret[i] - i > rc) rc = ret[i] - i, rp = i;
  for (int i = 0; i < r; i++) {
    for (int j = len[rp - 1]; j < len[nxt[rp] - 1] - 1; j++) putchar(s[j]);
    rp = nxt[rp];
    puts("");
  }
}
