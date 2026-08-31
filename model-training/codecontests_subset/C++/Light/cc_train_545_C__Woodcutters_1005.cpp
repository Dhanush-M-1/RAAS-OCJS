#include <bits/stdc++.h>
using namespace std;
long long int n = 0, x[200000], h[200000], m = 0, su = 0;
int main() {
  cin >> n;
  x[n + 1] = 5e9;
  for (int i = 1; i <= n; i++) {
    cin >> x[i] >> h[i];
  }
  m = x[1];
  su++;
  for (int i = 2; i <= n; i++) {
    if (x[i] - h[i] > m) {
      su++;
      m = x[i];
    } else if (x[i] + h[i] < x[i + 1]) {
      su++;
      m = h[i] + x[i];
    } else {
      m = x[i];
    }
  }
  cout << su;
  return 0;
}
