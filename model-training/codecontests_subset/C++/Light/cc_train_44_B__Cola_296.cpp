#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, res;
int main() {
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= min(c, n / 2); ++i)
    for (int j = 0; j <= min(n, b); ++j)
      if (n - 2 * i - j <= a / 2 && n - 2 * i - j >= 0) res++;
  cout << res << endl;
  return 0;
}
