#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long arr[100002][2];
  for (int i = 0; i < n; i++) {
    cin >> arr[i][0] >> arr[i][1];
  }
  long long ans = 2;
  if (n == 1)
    ans = 1;
  else if (n == 2)
    ans = 2;
  else {
    long long left_most = arr[0][0], right_most;
    for (int i = 1; i < n - 1; i++) {
      right_most = arr[i + 1][0];
      if (arr[i][0] - arr[i][1] > left_most) {
        ans++;
        left_most = arr[i][0];
      } else if (arr[i][0] + arr[i][1] < arr[i + 1][0]) {
        ans++;
        left_most = arr[i][0] + arr[i][1];
      } else {
        left_most = arr[i][0];
      }
    }
  }
  cout << ans << endl;
  return 0;
}
