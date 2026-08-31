#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c;
  cin >> a >> b >> c;
  int l = 1, h = 100000000, m;
  while (l <= h) {
    m = (l + h) / 2;
    if (c * (a - b) > m * b)
      l = m + 1;
    else if (c * (a - b) <= m * b && c * (a - b) > (m - 1) * b)
      break;
    else if (c * (a - b) < m * b)
      h = m - 1;
    else
      break;
  }
  cout << m;
  return 0;
}
