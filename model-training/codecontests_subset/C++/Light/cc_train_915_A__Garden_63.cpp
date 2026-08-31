#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, minn = 1000000, ans = 0, t;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> t;
    if (k % t == 0) {
      ans = k / t;
      if (ans < minn) minn = ans;
    }
  }
  cout << minn;
  return 0;
}
