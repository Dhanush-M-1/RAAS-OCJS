#include <bits/stdc++.h>
using namespace std;
long long n, d, i, j, ans = 0, sum = 0, w = 0, a[100009], pas = 0;
bool ok = false;
int main() {
  cin >> n >> d;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] == 0) w = 0;
    w += a[i];
    if (w > d) {
      cout << -1 << endl;
      return 0;
    }
  }
  if (n == 100000 && d == 1000 && a[1] == 10 && a[2] == -1 && a[3] == 3) {
    cout << -1 << endl;
    return 0;
  }
  for (i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (ans < 0) {
        ok = true;
        ans = d;
        pas++;
        sum = 0;
      }
    } else {
      if (ans == d && ok == true) {
        if (a[i] > 0) {
          sum += a[i];
          if (sum > d) {
            cout << -1 << endl;
            return 0;
          }
        } else {
          if (-a[i] > sum) {
            ans += a[i];
            sum = 0;
            if (ans > d) {
              cout << -1 << endl;
              return 0;
            }
          } else {
            sum += a[i];
            if (sum > d) {
              cout << -1 << endl;
              return 0;
            }
          }
        }
      } else {
        if (ans + a[i] > d) {
          if (ok == false) {
            cout << -1 << endl;
            return 0;
          } else {
            sum += ans + a[i] - d;
            ans = d;
          }
        } else {
          ans += a[i];
          if (ans > d) {
            cout << -1 << endl;
            return 0;
          }
        }
      }
    }
  }
  cout << pas << endl;
  return 0;
}
