#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, x, y;
  cin >> n >> x >> y;
  double k = (y * n / 100.0);
  long long int b = ceil(k);
  long long int ans = b - x;
  if (ans > 0)
    cout << ans;
  else
    cout << 0;
  return 0;
}
