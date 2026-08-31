#include <bits/stdc++.h>
using namespace std;
int n, maxi, x;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (x > 500000) {
      x = 1000000 - x;
    } else
      x--;
    if (x > maxi) maxi = x;
  }
  cout << maxi;
  return 0;
}
