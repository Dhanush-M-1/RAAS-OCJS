#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long cur = 0, num = 1, rest = n - 1;
    while (cur < l) {
      cur += (rest * 2);
      if (cur >= l) {
        cur -= (rest * 2);
        break;
      }
      num++;
      rest--;
      if (rest < 0) {
        break;
      }
    }
    if (cur == (n * (n - 1))) {
      cout << 1 << endl;
      continue;
    }
    long long num2 = num, ye = 0;
    while (cur < l) {
      cur++;
      if (ye != num) {
        ye = num;
        num2++;
      } else {
        if (num2 < n) {
          ye = num2;
        } else {
          ye = num2;
          if (num == n - 1) {
            num = 1;
          } else {
            num++;
            num2 = num;
          }
        }
      }
    }
    for (long long i = l; i <= r; i++) {
      cout << ye << " ";
      if (ye != num) {
        ye = num;
        num2++;
      } else {
        if (num2 < n) {
          ye = num2;
        } else {
          ye = num2;
          if (num == n - 1) {
            num = 1;
          } else {
            num++;
            num2 = num;
          }
        }
      }
    }
    cout << "\n";
  }
  return 0;
}
