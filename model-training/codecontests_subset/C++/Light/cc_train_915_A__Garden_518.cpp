#include <bits/stdc++.h>
using namespace std;
int n, k, i, minn = 10000, ans = 0, t;
int main() {
  cin >> n >> k;
  for (i = 0; i < n; i++) {
    cin >> t;
    if (k % t == 0) {
      ans = k / t;
      if (ans < minn) minn = ans;
    }
  }
  cout << minn;
  return 0;
}
