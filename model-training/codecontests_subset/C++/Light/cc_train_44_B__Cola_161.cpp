#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  n <<= 1;
  int res = 0;
  for (int i = 0; i <= b; ++i)
    for (int j = 0; i * 2 + j * 4 <= n && j <= c; ++j)
      res += (n - i * 2 - j * 4 <= a);
  cout << res << endl;
  return 0;
}
