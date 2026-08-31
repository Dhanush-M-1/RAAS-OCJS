#include <bits/stdc++.h>
using namespace std;
const int INF = 1000 * 1000 * 1000;
const double EPS = 1e-9;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  n *= 2;
  int cnt = 0;
  for (int i = 0; i <= a; ++i)
    for (int j = 0; j <= b; ++j) {
      int cur = i + 2 * j;
      if (n >= cur && !((n - cur) % 4) && (n - cur) / 4 <= c) ++cnt;
    }
  cout << cnt;
  return 0;
}
