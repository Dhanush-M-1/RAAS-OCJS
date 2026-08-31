#include <bits/stdc++.h>
using namespace std;
int main() {
  int test, x, y, z;
  cin >> test;
  while (test--) {
    int ans = 0;
    cin >> x >> y >> z;
    ans += min(y, z / 2);
    y -= ans;
    ans += min(x, y / 2);
    cout << ans * 3 << endl;
  }
}
