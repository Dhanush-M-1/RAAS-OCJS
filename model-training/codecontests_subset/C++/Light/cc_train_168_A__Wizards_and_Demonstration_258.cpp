#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  double result;
  double p = ceil((n / 100) * y);
  result = p - x;
  if (result <= 0) {
    cout << 0 << endl;
    return 0;
  }
  cout << result << endl;
  return 0;
}
