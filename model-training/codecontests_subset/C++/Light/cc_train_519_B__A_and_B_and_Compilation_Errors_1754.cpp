#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 0, b = 0, c = 0, d;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> d;
    a += d;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> d;
    b += d;
  }
  cout << a - b << endl;
  for (int i = 0; i < n - 2; i++) {
    cin >> d;
    c += d;
  }
  cout << b - c << endl;
  return 0;
}
