#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, tmp, ans = 9999999;
  cin >> n >> k;
  while (n--) {
    cin >> tmp;
    if (k % tmp == 0) {
      ans = min(k / tmp, ans);
    }
  }
  cout << ans;
}
