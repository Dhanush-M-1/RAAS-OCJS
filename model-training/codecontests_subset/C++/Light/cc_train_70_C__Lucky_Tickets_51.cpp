#include <bits/stdc++.h>
using namespace std;
double mul = 1e9;
long long n, m, w, ans, ansx, ansy;
map<long long, long long> a, b;
long long Rev(long long x) {
  long long res = 0;
  while (x) {
    res = res * 10 + x % 10;
    x /= 10;
  }
  return res;
}
signed main() {
  cin >> n >> m >> w;
  ans = n * m + 1;
  {
    long long i = 0, j = m, now = 0;
    for (long long o = 1; o <= m; ++o) {
      long long tmp = round(mul * Rev(o) / o);
      if (b.find(tmp) != b.end())
        ++b[tmp];
      else
        b[tmp] = 1;
    }
    while (i <= n && j >= 1) {
      if (now < w) {
        ++i;
        long long tmp = round(mul * i / Rev(i));
        if (a.find(tmp) != a.end())
          ++a[tmp];
        else
          a[tmp] = 1;
        if (b.find(tmp) != b.end()) now += b[tmp];
      } else {
        if (ans > i * j) {
          ans = i * j;
          ansx = i;
          ansy = j;
        }
        long long tmp = round(mul * Rev(j) / j);
        if (a.find(tmp) != a.end()) now -= a[tmp];
        --b[tmp];
        --j;
      }
    }
  }
  if (ans == n * m + 1) {
    puts("-1");
  } else {
    cout << ansx << " " << ansy << endl;
  }
  return 0;
}
