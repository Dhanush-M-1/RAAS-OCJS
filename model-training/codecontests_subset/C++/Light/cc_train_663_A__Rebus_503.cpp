#include <bits/stdc++.h>
using namespace std;
int a[111];
char s[11111];
int main() {
  int i, len, nn, pos, neg, cntp, cntn;
  long long n, nr, nv, pr, pv, st, ed;
  gets(s);
  len = strlen(s);
  n = pos = neg = nn = 0;
  a[nn++] = 1;
  for (i = 1; i < len; i++) {
    if (s[i] == '+') a[nn++] = 1;
    if (s[i] == '-') a[nn++] = -1;
    if (isdigit(s[i])) n = n * 10 + s[i] - '0';
  }
  for (i = 0; i < nn; i++) {
    if (a[i] > 0)
      pos++;
    else
      neg++;
  }
  st = pos;
  ed = pos * n;
  st = max(st, neg + n);
  ed = min(ed, neg * n + n);
  if (ed >= st) {
    puts("Possible");
    if (pos) {
      pv = st / pos;
      pr = st - pv * pos;
    }
    if (neg) {
      st -= n;
      nv = st / neg;
      nr = st - nv * neg;
    }
    cntp = cntn = 0;
    for (i = 0; i < nn; i++) {
      if (i) {
        if (a[i] > 0)
          printf(" + ");
        else
          printf(" - ");
      }
      if (a[i] > 0) {
        if (cntp < pr) {
          printf("%I64d", pv + 1);
          cntp++;
        } else
          printf("%I64d", pv);
      } else {
        if (cntn < nr) {
          printf("%I64d", nv + 1);
          cntn++;
        } else
          printf("%I64d", nv);
      }
    }
    printf(" = %I64d\n", n);
  } else
    puts("Impossible");
  return 0;
}
