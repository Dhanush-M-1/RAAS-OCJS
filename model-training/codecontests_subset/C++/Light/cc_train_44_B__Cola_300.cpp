#include <bits/stdc++.h>
using namespace std;
long long n, a, b, c, s, ans;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> a >> b >> c;
  n *= 2;
  for (int i = 0; i <= c; i++)
    for (int j = 0; j <= b; j++) {
      s = 4 * i + 2 * j;
      s = n - s;
      if (s >= 0 && s <= a) ++ans;
    }
  cout << ans << endl;
  cin.get();
  cin.get();
  return 0;
}
