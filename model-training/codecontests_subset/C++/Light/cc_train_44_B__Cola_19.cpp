#include <bits/stdc++.h>
using namespace std;
long long ans = 0;
int main() {
  int a, b, c, n;
  cin >> n >> a >> b >> c;
  a = a / 2;
  ans = 0;
  for (int i = 0; i <= a; i++)
    for (int j = 0; j <= b; j++)
      if (i + j <= n && i + j + 2 * c >= n && (n - i - j) % 2 == 0) ans++;
  cout << ans << endl;
  return 0;
}
