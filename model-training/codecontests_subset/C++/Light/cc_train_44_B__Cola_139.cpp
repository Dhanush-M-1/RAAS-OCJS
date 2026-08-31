#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, n, ans = 0, za;
  cin >> n >> c >> a >> b;
  for (int i = 0; i <= a; i++)
    for (int j = 0; j <= b; j++)
      if (n - (i + j * 2) >= 0) {
        za = n - (i + j * 2);
        if (za <= c * 0.5) {
          ans++;
        }
      }
  cout << ans;
  return 0;
}
