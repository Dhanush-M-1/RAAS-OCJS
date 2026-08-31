#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, a = 0, b = 0, c = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    a += x;
  }
  for (int j = 0; j < n - 1; j++) {
    cin >> x;
    b += x;
  }
  for (int k = 0; k < n - 2; k++) {
    cin >> x;
    c += x;
  }
  cout << a - b << endl;
  cout << b - c << endl;
  return 0;
}
