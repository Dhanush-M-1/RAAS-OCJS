#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, m, r = 0, c = 0, i;
  cin >> n >> m;
  long p[n];
  for (i = 0; i < n; ++i) cin >> p[i];
  sort(p, p + n);
  for (i = n - 1; i > -1; --i) {
    if (m % p[i] == 0) break;
  }
  cout << m / p[i];
  return 0;
}
