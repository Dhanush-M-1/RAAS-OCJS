#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 200;
const int INF = 0x3f3f3f3f;
int n, k, a[105], minn = INF, x;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (k % x == 0) minn = min(minn, k / x);
  }
  cout << minn;
  return 0;
}
