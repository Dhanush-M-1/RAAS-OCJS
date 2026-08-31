#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, t;
  cin >> n >> m >> t;
  n *= t;
  if (n % 100 != 0) n += 100;
  n /= 100;
  if (m > n) {
    cout << 0;
    return 0;
  }
  cout << n - m;
}
