#include <bits/stdc++.h>
using namespace std;
int arr[101] = {0};
int main() {
  int n, c, k, ans = 0;
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> k;
    arr[i] = k;
    if (i >= 1) ans = max(arr[i - 1] - arr[i], ans);
  }
  ans -= c;
  if (ans < 0) ans = 0;
  cout << ans;
  return 0;
}
