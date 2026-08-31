#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  ;
  int n, k, ans = INT_MAX;
  cin >> n >> k;
  int arr[105];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i < n; i++) {
    if (k % arr[i] == 0) {
      ans = min(ans, k / arr[i]);
    }
  }
  cout << ans;
  return 0;
}
