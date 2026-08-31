#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int ans = 1;
  for (int i = 1; i <= 1e6; ++i) {
    int k = (a * c - i * b);
    if (k % b != 0)
      k = k / b + 1;
    else
      k /= b;
    if (k == c) {
      ans = i;
      break;
    }
  }
  cout << ans;
}
