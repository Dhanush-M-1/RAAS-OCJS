#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int sum = n * y;
  if (sum % 100 == 0) {
    sum = sum / 100;
  } else {
    sum = sum / 100;
    sum++;
  }
  if (sum > x)
    cout << sum - x << endl;
  else {
    cout << 0 << endl;
  }
  return 0;
}
