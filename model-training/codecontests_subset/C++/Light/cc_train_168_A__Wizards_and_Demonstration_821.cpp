#include <bits/stdc++.h>
using namespace std;
int c;
int main() {
  double m, n, k;
  cin >> m >> n >> k;
  double y;
  if (n / m < k / 100) {
    y = m * k / 100 - n;
    cout << ceil(y);
  } else
    cout << 0;
  return 0;
}
