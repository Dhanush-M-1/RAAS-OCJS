#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n, x, y;
  cin >> n >> x >> y;
  double ans = (double)(n * y) / 100;
  long int sum = ceil(ans);
  if (sum <= x)
    cout << "0";
  else
    cout << sum - x;
  return 0;
}
