#include <bits/stdc++.h>
using namespace std;
long long a[2000011], n, m, k;
bool b[2000011];
int s[2000011];
long long process(long long t) {
  long long c = a[t], ret = 0;
  if (s[1]) return (1LL << 60);
  ret = c;
  int cl = 2, cr = t + 1;
  while (cr < n + 1) {
    if (s[cr] - s[cr - 1] == 0) {
      ret += c;
      cr = cr + t + 1;
      cl = cr - t;
      cr--;
    } else if (s[cr] - s[cl - 1] == cr - cl + 1) {
      return (1LL << 60);
    } else {
      int lo = cl, hi = cr;
      while (lo + 1 < hi) {
        int mid = (lo + hi) / 2;
        if (s[cr] - s[mid - 1] != cr - mid + 1)
          lo = mid;
        else
          hi = mid;
      }
      cr = lo + t + 1;
      cl = cr - t;
      ret += c;
      cr--;
    }
  }
  return ret;
}
int main() {
  scanf("%lld %lld %lld", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int x;
    scanf("%d", &x);
    b[x + 1] = true;
  }
  for (int i = 1; i <= 2 * n; i++) {
    s[i] = s[i - 1] + b[i];
  }
  for (int i = 1; i <= k; i++) scanf("%lld", &a[i]);
  long long res = (1LL << 60);
  for (int i = 1; i <= k; i++) {
    res = min(res, process(i));
  }
  if (res == (1LL << 60))
    puts("-1");
  else
    printf("%lld\n", res);
  return 0;
}
