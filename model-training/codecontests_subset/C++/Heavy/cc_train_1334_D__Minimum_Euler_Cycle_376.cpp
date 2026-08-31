#include <bits/stdc++.h>
using namespace std;
const int SIZE = 1e5 + 9;
long long arr[SIZE];
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long x = 2 * (n - 1);
    arr[1] = x;
    for (int i = 2; i < n; i++) {
      x -= 2;
      arr[i] = arr[i - 1] + x;
    }
    arr[n] = arr[n - 1] + 1;
    for (int i = 1; i <= n; i++) {
      if (l <= arr[i]) {
        long long d = arr[i] - l + 1;
        long long st = n - d / 2;
        if (d % 2 == 0) {
          cout << i << " ";
          st++;
          l++;
        }
        while (l <= r) {
          if (l % 2 != 0) {
            if (i == n) i = 1;
            cout << i << " ";
            st++;
          } else {
            cout << st << " ";
            if (st == n) {
              i = (i + 1 == n ? 1 : i + 1);
              st = i;
            }
          }
          l++;
        }
        break;
      }
    }
    cout << endl;
  }
}
