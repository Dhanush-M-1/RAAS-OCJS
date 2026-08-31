#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, x, m;
  cin >> n;
  m = 0;
  for (i = 0; i < n; i++) {
    cin >> x;
    if (x == 100) m++;
  }
  n -= m;
  if (n % 2 == 1 && m >= 2) {
    m -= 2;
    if (m % 2 == 0)
      cout << "YES\n";
    else
      cout << "NO\n";
    return 0;
  }
  if (n % 2 == 0) {
    if (m % 2 == 0)
      cout << "YES\n";
    else
      cout << "NO\n";
    return 0;
  }
  cout << "NO\n";
  return 0;
}
