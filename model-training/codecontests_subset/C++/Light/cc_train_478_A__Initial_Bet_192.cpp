#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, a, b, c;
  cin >> n >> m >> a >> b >> c;
  n += m, n += a, n += b, n += c;
  if (n % 5 || a + b + c + n + m == 0)
    cout << -1;
  else
    cout << n / 5;
  return 0;
}
