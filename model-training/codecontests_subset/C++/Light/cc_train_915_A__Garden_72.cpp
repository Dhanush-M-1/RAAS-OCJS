#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int res = k;
  int a[n];
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (k % a[i] == 0) {
      res = min(res, k / a[i]);
    }
  }
  cout << res;
}
