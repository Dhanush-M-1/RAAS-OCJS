#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0, b = 0, c = 0, i, k, h;
  cin >> k;
  for (i = 0; i < k; i++) {
    cin >> h;
    a += h;
  }
  for (i = 0; i < k - 1; i++) {
    cin >> h;
    b += h;
  }
  cout << a - b << "\n";
  for (i = 0; i < k - 2; i++) {
    cin >> h;
    c += h;
  }
  cout << b - c;
  return (0);
}
