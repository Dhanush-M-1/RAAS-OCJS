#include <bits/stdc++.h>
using namespace std;
long long n, x, s, maax = 1 >> 30, res;
int main() {
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> x;
    s += x;
    maax = max(maax, x);
  }
  res = ceil(2 * s / n);
  while (res * n <= 2 * s) res++;
  if (res >= maax)
    cout << res;
  else
    cout << maax;
  return 0;
}
