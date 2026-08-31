#include <bits/stdc++.h>
using namespace std;
int main() {
  long double n, x, y;
  long long a;
  cin >> n >> x >> y;
  a = ceil(n * y / 100.0 - x);
  if (a < 0) a = 0;
  cout << a;
  return 0;
}
