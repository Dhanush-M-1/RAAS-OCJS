#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n, ans = 1e7;
  cin >> n;
  int arr[n];
  for (int i = 0; i < (int)(n); i++) cin >> arr[i];
  ans = min(arr[n - 1] - 1, 1000000 - arr[0]);
  for (int i = 0; i < (int)(n - 1); i++) {
    ans = min(ans, max(arr[i] - 1, 1000000 - arr[i + 1]));
  }
  cout << ans;
}
