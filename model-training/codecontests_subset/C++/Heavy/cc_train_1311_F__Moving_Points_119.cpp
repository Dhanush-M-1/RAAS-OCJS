#include <bits/stdc++.h>
using namespace std;
long long ts[(int)8e5 + 10], tc[(int)8e5 + 10], n;
pair<long long, long long> o[(int)2e5 + 10];
void update(long long i, long long v, long long t = 1, long long nl = 1,
            long long nr = n) {
  if (i < nl || nr < i) return;
  if (nl == nr) {
    ts[t] += v;
    tc[t] += 1;
    return;
  }
  long long mid = nl + nr >> 1;
  update(i, v, t * 2, nl, mid);
  update(i, v, t * 2 + 1, mid + 1, nr);
  ts[t] = ts[t * 2] + ts[t * 2 + 1];
  tc[t] = tc[t * 2] + tc[t * 2 + 1];
}
long long ans = 0;
void get(long long x, long long ql, long long qr = n, long long t = 1,
         long long nl = 1, long long nr = n) {
  if (nr < ql || qr < nl) return;
  if (ql <= nl && nr <= qr) {
    ans += ts[t] - x * tc[t];
    return;
  }
  long long mid = nl + nr >> 1;
  get(x, ql, qr, t * 2, nl, mid);
  get(x, ql, qr, t * 2 + 1, mid + 1, nr);
}
int main(void) {
  scanf("%lld", &n);
  for (long long i = 1; i <= n; i++) {
    scanf("%lld", &o[i].second);
  }
  for (long long i = 1; i <= n; i++) {
    scanf("%lld", &o[i].first);
  }
  sort(o + 1, o + 1 + n);
  for (long long i = 1; i <= n; i++) {
    o[i].first = i;
    swap(o[i].first, o[i].second);
  }
  sort(o + 1, o + 1 + n);
  for (long long i = n; 0 < i; i--) {
    long long idx = o[i].first, v = o[i].second;
    get(idx, v);
    update(v, idx);
  }
  printf("%lld\n", ans);
}
