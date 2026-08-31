#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b, c, n, ans = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= b; j++) {
      int rem = n - i / 2 - j;
      if (rem % 2 == 0 && rem > -1 && (rem / 2) <= c) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
