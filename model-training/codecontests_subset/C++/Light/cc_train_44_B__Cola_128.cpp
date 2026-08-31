#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
int n, a, b, c, ans = 0;
int main() {
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i += 2)
    for (int j = 0; j < (int)(b + 1); j++) {
      int k = n - (i * 0.5 + j);
      if (k < 0) break;
      if (!k) {
        ans++;
        continue;
      }
      if (k % 2 == 0) {
        int l = k / 2;
        if (l <= c) ans++;
      }
    }
  cout << ans;
  return 0;
}
