#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    char arr[n][n];
    for (long long i = 0; i < n; i++)
      for (long long j = 0; j < n; j++) cin >> arr[i][j];
    bool f = false;
    if ((arr[0][1] == arr[1][0]) && (arr[n - 1][n - 2] == arr[n - 2][n - 1]) &&
        (arr[0][1] != arr[n - 1][n - 2]))
      f = true;
    if (f)
      cout << 0 << '\n';
    else {
      long long cnt0 = 0, cnt1 = 0;
      if (arr[0][1] == '0')
        cnt0++;
      else
        cnt1++;
      if (arr[1][0] == '0')
        cnt0++;
      else
        cnt1++;
      if (arr[n - 1][n - 2] == '0')
        cnt0++;
      else
        cnt1++;
      if (arr[n - 2][n - 1] == '0')
        cnt0++;
      else
        cnt1++;
      if (cnt0 == cnt1 + 2) {
        if (arr[0][1] == arr[1][0]) {
          cout << 1 << '\n';
          if (arr[n - 1][n - 2] == '0')
            cout << n << " " << n - 1 << '\n';
          else
            cout << n - 1 << " " << n << '\n';
        } else {
          cout << 1 << '\n';
          if (arr[0][1] == '0')
            cout << 1 << " " << 2 << '\n';
          else
            cout << 2 << " " << 1 << '\n';
        }
      } else if (cnt1 == cnt0 + 2) {
        if (arr[0][1] == arr[1][0]) {
          cout << 1 << '\n';
          if (arr[n - 1][n - 2] == '1')
            cout << n << " " << n - 1 << '\n';
          else
            cout << n - 1 << " " << n << '\n';
        } else {
          cout << 1 << '\n';
          if (arr[0][1] == '1')
            cout << 1 << " " << 2 << '\n';
          else
            cout << 2 << " " << 1 << '\n';
        }
      } else if (cnt1 == cnt0) {
        cout << 2 << '\n';
        cout << 1 << " " << 2 << '\n';
        if (arr[n - 1][n - 2] != arr[0][1])
          cout << n << " " << n - 1 << '\n';
        else
          cout << n - 1 << " " << n << '\n';
      } else {
        cout << 2 << '\n';
        cout << 1 << " " << 2 << '\n';
        cout << 2 << " " << 1 << '\n';
      }
    }
  }
  return 0;
}
