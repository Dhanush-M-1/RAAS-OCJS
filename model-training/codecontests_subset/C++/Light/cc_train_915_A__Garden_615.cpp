#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, len;
  while (cin >> n >> len) {
    int ans = 0x3f3f3f3f;
    for (int i = 0; i < n; i++) {
      int vol;
      cin >> vol;
      if (len % vol == 0) ans = min(ans, len / vol);
    }
    cout << ans << endl;
  }
  return 0;
}
