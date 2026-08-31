#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, a, b, d, max = 0;
  cin >> n >> c;
  cin >> a;
  for (int i = 2; i <= n; i++) {
    cin >> b;
    d = a - b - c;
    if (d > max) max = d;
    a = b;
  }
  cout << max << endl;
  return 0;
}
