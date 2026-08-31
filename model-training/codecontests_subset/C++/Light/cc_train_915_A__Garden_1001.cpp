#include <bits/stdc++.h>
using namespace std;
const int N = 200;
int n, a[N], k, ans = 100;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (k % a[i] == 0) ans = min(ans, k / a[i]);
  }
  cout << ans << endl;
}
