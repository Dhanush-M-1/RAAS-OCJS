#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, f = 1;
  cin >> k;
  for (int t = 1; t < k; t++) {
    cout << t << " ";
  }
  cout << endl;
  for (int t = 2; t < k; t++) {
    f++;
    cout << f << " ";
    for (int i = 2; i < k; i++) {
      int n = t * i;
      bool b = 0;
      string s = "";
      while (b == 0) {
        if (n <= 1) {
          b = 1;
        }
        if (n % k == 0) {
          s = '0' + s;
        }
        if (n % k == 1) {
          s = '1' + s;
        }
        if (n % k == 2) {
          s = '2' + s;
        }
        if (n % k == 3) {
          s = '3' + s;
        }
        if (n % k == 4) {
          s = '4' + s;
        }
        if (n % k == 5) {
          s = '5' + s;
        }
        if (n % k == 6) {
          s = '6' + s;
        }
        if (n % k == 7) {
          s = '7' + s;
        }
        if (n % k == 8) {
          s = '8' + s;
        }
        if (n % k == 9) {
          s = '9' + s;
        }
        n /= k;
      }
      if (s[0] == '0') {
        s.erase(0, 1);
      }
      cout << s << " ";
    }
    cout << endl;
  }
  return 0;
}
