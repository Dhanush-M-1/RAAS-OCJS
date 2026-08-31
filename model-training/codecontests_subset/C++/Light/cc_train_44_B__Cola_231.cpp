#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, ans = 0;
int main() {
  cin >> n >> a >> b >> c;
  a /= 2;
  if (a > b) swap(a, b);
  for (int i = 0; i < c + 1; i++)
    if (i * 2 <= n && a + b + i * 2 >= n) {
      if (i * 2 < n)
        ans += min(a, n - i * 2) - max(0, n - i * 2 - b) + 1;
      else
        ans++;
    }
  cout << ans;
  return 0;
}
