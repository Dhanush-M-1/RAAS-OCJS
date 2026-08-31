#include <bits/stdc++.h>
using namespace std;
long long read() {
  char ch = getchar();
  long long x = 0, ff = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') ff = -ff;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  return x * ff;
}
void write(long long aa) {
  if (aa < 0) putchar('-'), aa = -aa;
  if (aa > 9) write(aa / 10);
  putchar(aa % 10 + '0');
  return;
}
long long n;
long long a[200005];
long long tt[800005], tts[800005], lz[800005];
void up(long long rt) {
  tt[rt] = min(tt[rt << 1], tt[rt << 1 | 1]);
  if (tt[rt << 1] >= tt[rt << 1 | 1])
    tts[rt] = tts[rt << 1 | 1];
  else
    tts[rt] = tts[rt << 1];
  return;
}
void bt(long long rt, long long ll, long long rr) {
  if (ll == rr) {
    tt[rt] = read(), tts[rt] = ll;
    return;
  }
  long long mid = (ll + rr) >> 1;
  bt(rt << 1, ll, mid);
  bt(rt << 1 | 1, mid + 1, rr);
  up(rt);
  return;
}
void push(long long rt) {
  if (!lz[rt]) return;
  tt[rt << 1] += lz[rt];
  tt[rt << 1 | 1] += lz[rt];
  lz[rt << 1] += lz[rt];
  lz[rt << 1 | 1] += lz[rt];
  lz[rt] = 0;
  return;
}
void update(long long rt, long long ll, long long rr, long long L, long long R,
            long long kk) {
  if (ll == L && rr == R) {
    tt[rt] += kk;
    lz[rt] += kk;
    return;
  }
  long long mid = (ll + rr) >> 1;
  push(rt);
  if (R <= mid)
    update(rt << 1, ll, mid, L, R, kk);
  else if (L > mid)
    update(rt << 1 | 1, mid + 1, rr, L, R, kk);
  else
    update(rt << 1, ll, mid, L, mid, kk),
        update(rt << 1 | 1, mid + 1, rr, mid + 1, R, kk);
  up(rt);
  return;
}
int main() {
  n = read();
  bt(1, 1, n);
  for (long long i = 1; i <= n; ++i) {
    long long now = tts[1];
    a[now] = i;
    update(1, 1, n, now, now, n * n);
    if (now < n) update(1, 1, n, now + 1, n, -i);
  }
  for (long long i = 1; i <= n; ++i, putchar(' ')) write(a[i]);
  return 0;
}
