#include <bits/stdc++.h>
using namespace std;
int maxx, maxy, w, l, r, ll, rr;
map<double, int> a, b;
long long min(long long l, long long r) {
  if (l < r)
    return l;
  else
    return r;
}
int rev(int k) {
  int sum = 0;
  while (k > 0) {
    int t = k % 10;
    k = k / 10;
    sum = sum * 10 + t;
  }
  return sum;
}
int main() {
  scanf("%d%d%d", &maxx, &maxy, &w);
  for (int i = 1; i <= maxx; i++) {
    double sum = (double)i / rev(i);
    a[sum] = a[sum] + 1;
  }
  l = maxx;
  r = 0;
  int s = 0;
  long long ans = 1e15;
  while ((l >= 1) && (r <= maxy)) {
    if ((s < w) && (r < maxy)) {
      r = r + 1;
      double sum = (double)rev(r) / r;
      s = s + a[sum];
      b[sum] = b[sum] + 1;
    } else if (s >= w) {
      if (ans > (long long)l * r) {
        ans = (long long)l * r;
        ll = l;
        rr = r;
      }
      double sum = (double)l / rev(l);
      s = s - b[sum];
      a[sum] = a[sum] - 1;
      l = l - 1;
    } else
      break;
  }
  if (ans == 1e15)
    printf("-1\n");
  else
    printf("%d %d\n", ll, rr);
  return 0;
}
