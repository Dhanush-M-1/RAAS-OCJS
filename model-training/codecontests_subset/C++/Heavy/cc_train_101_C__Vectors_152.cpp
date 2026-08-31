#include <bits/stdc++.h>
using namespace std;
long long i, j, k, l, m, n, d, e, f, a, c, b, t, s, g, h;
map<long long, long long> y, x;
string p;
int main() {
  cin >> i >> j >> n >> m >> c >> d;
  k = c * c + d * d;
  if (k == 0) {
    if (i == n && j == m) t = 1;
    if (i == -n && j == -m) t = 1;
    if (j == n && -i == m) t = 1;
    if (-j == n && i == m) t = 1;
    if (t == 1)
      cout << "YES";
    else
      cout << "NO";
    return 0;
  }
  a = n - i;
  b = m - j;
  e = a * c + b * d;
  f = a * d - b * c;
  if (e % k == 0 && f % k == 0) t = 1;
  a = n + i;
  b = m + j;
  e = a * c + b * d;
  f = a * d - b * c;
  if (e % k == 0 && f % k == 0) t = 1;
  a = n + j;
  b = m - i;
  e = a * c + b * d;
  f = a * d - b * c;
  if (e % k == 0 && f % k == 0) t = 1;
  a = n - j;
  b = m + i;
  e = a * c + b * d;
  f = a * d - b * c;
  if (e % k == 0 && f % k == 0) t = 1;
  if (t == 1)
    cout << "YES";
  else
    cout << "NO";
}
