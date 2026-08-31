#include <bits/stdc++.h>
using namespace std;
pair<long long, long long> o[(int)2e5 + 10];
long long n, ts[(int)2e5 + 10], tc[(int)2e5 + 10];
int main(void) {
  scanf("%lld", &n);
  for (int i = 0; i < n; i++) {
    scanf("%lld", &o[i].second);
  }
  for (int i = 0; i < n; i++) {
    scanf("%lld", &o[i].first);
  }
  sort(o, o + n);
  for (int i = 0; i < n; i++) {
    o[i] = {o[i].second, i + 1};
  }
  sort(o, o + n);
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    long long r = o[i].second, idx = o[i].first;
    long long s = 0, c = 0;
    while (0 < r) {
      s += ts[r];
      c += tc[r];
      r -= (r & -r);
    }
    ans += idx * c - s;
    long long v = o[i].second;
    while (v <= n) {
      ts[v] += idx;
      tc[v]++;
      v += (v & -v);
    }
  }
  printf("%lld\n", ans);
}
