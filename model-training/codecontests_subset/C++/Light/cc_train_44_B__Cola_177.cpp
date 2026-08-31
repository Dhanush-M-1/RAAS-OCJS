#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  long long ans = 0;
  cin >> n >> a >> b >> c;
  n += n;
  for (int i = 0; i <= b; ++i)
    for (int j = 0; j <= c; ++j) {
      int k = (n - i * 2 - j * 4);
      if (k >= 0 && k <= a) ++ans;
    }
  cout << ans;
}
