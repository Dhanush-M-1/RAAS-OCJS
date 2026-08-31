#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, ans;
  cin >> n >> a >> b >> c;
  swap(a, c);
  ans = 0;
  for (int i = 0; i <= a; i++)
    for (int j = 0; j <= b; j++) {
      int t = (n - i * 2 - j) * 2;
      if (t <= c && t >= 0) ans++;
    }
  cout << ans << endl;
}
