#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int main() {
  cin >> n >> a >> b >> c;
  int ans = 0;
  for (int i = 0; i < (int)(b + 1); ++i)
    for (int j = 0; j < (int)(c + 1); ++j) {
      int cnt = n - i - 2 * j;
      if (cnt >= 0 && 2 * cnt <= a) {
        ++ans;
      }
    }
  cout << ans << endl;
  return 0;
}
