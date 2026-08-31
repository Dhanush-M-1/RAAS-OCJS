#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, n, m, i, x, y, ans, sum;
  long long int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  sum = (a + b + c + d + e);
  if (sum == 0 or sum % 5 != 0)
    cout << -1;
  else
    cout << sum / 5;
}
