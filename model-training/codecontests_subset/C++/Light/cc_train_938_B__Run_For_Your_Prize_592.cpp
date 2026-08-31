#include <bits/stdc++.h>
using namespace std;
int a, b = 1000000, c, min, n, ans = 1e9, arr[100005];
int main() {
  cin >> n;
  for (int i = 1; i < n + 1; i++) {
    cin >> arr[i];
  }
  if (n == 1) {
    ans = (arr[1] - 1 < b - arr[1]) ? arr[1] - 1 : b - arr[1];
    cout << ans;
    return 0;
  }
  for (int i = 1; i < n; i++) {
    a = (arr[i] - 1 > 1000000 - arr[i + 1]) ? arr[i] - 1 : 1000000 - arr[i + 1];
    ans = (ans < a) ? ans : a;
  }
  ans = (ans < arr[n] - 1) ? ans : arr[n] - 1;
  ans = (ans < b - arr[1]) ? ans : b - arr[1];
  cout << ans;
}
