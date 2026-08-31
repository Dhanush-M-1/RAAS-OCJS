#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  int sum = a + b + c + d + e;
  if (sum % 5 == 0 && sum > 0)
    cout << sum / 5 << endl;
  else
    cout << -1 << endl;
  return 0;
}
