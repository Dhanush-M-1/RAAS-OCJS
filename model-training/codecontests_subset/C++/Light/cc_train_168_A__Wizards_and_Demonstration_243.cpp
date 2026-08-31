#include <bits/stdc++.h>
using namespace std;
int n, x, y, ans;
int main() {
  while (cin >> n >> x >> y) {
    if ((n * y) % 100 == 0) {
      ans = n * y / 100;
    } else {
      ans = n * y / 100;
      ans++;
    }
    if (ans - x < 0)
      cout << 0 << endl;
    else
      cout << ans - x << endl;
  }
}
