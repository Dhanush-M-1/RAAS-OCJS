#include <bits/stdc++.h>
using namespace std;
int main() {
  int r, n, b, total;
  cin >> n >> b;
  total = n;
  while (n >= b) {
    total += n / b;
    r = n % b;
    n = n / b + r;
  }
  cout << total;
  return 0;
}
