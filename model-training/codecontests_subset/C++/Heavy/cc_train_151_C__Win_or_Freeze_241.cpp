#include <bits/stdc++.h>
using namespace std;
long long int q, n, m, a[10000];
double x;
bool cmp(long long int x, long long int y) { return x < y; }
bool IsPrime(long long int qwe) {
  long long int s;
  double d;
  d = qwe;
  s = floor(sqrt(d));
  for (int i = 2; i <= s; i++)
    if (qwe % i == 0) {
      i = s + 1;
      return false;
    }
  return true;
}
int main() {
  cin >> q;
  if (IsPrime(q))
    cout << 1 << endl << 0;
  else {
    x = q;
    n = floor(sqrt(x));
    for (int i = 2; i <= n; i++) {
      if (q % i == 0) {
        if (IsPrime(i)) {
          a[m] = i;
          m++;
        }
        if (IsPrime(q / i)) {
          a[m] = q / i;
          m++;
        }
      }
    }
    sort(a, a + m, cmp);
    if (m == 1 && a[0] * a[0] == q)
      cout << 2;
    else if (m == 1 && a[0] * a[0] != q)
      cout << 1 << endl << a[0] * a[0];
    else if (m == 2 && a[0] * a[1] != q && q % (a[0] * a[0]) == 0)
      cout << 1 << endl << a[0] * a[0];
    else if (m == 2 && a[0] * a[1] != q && q % (a[1] * a[1]) == 0)
      cout << 1 << endl << a[1] * a[1];
    else if (m == 2 && a[0] * a[1] == q)
      cout << 2;
    else
      cout << 1 << endl << a[0] * a[1];
  }
  return 0;
}
