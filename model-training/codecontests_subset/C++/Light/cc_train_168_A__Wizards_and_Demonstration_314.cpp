#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, y, x;
  cin >> n >> x >> y;
  if ((n * y) % 100 == 0)
    n = n * y / 100;
  else
    n = n * y / 100 + 1;
  if (n - x > 0)
    cout << n - x;
  else
    cout << 0;
  return 0;
}
