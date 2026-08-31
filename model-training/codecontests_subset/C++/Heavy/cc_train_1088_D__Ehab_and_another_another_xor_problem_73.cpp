#include <bits/stdc++.h>
using namespace std;
int N;
long long t = 30;
int main() {
  cout << "? 0 0" << endl;
  long long a = 0;
  long long b = 0;
  int d = 0;
  cin >> d;
  for (int(i) = 0; (i) < (int)(t); (i)++) {
    if (d == 1) {
      cout << "? " << (a + (1 << (t - 1 - i))) << " " << b << endl;
      int ans = 1;
      cin >> ans;
      cout << "? " << (a + (1 << (t - 1 - i))) << " "
           << (b + (1 << (t - 1 - i))) << endl;
      int ans2 = 1;
      cin >> ans2;
      if (ans == 0) {
        a += (1 << (t - 1 - i));
        d = 0;
      }
      if (ans == 1 && ans2 == 1) {
        d = 1;
      }
      if (ans == 1 && ans2 == -1) {
        a += (1 << (t - 1 - i));
        d = 1;
      }
      if (ans == -1 && ans2 == 1) {
        a += (1 << (t - 1 - i));
        b += (1 << (t - 1 - i));
        d = 1;
      }
      if (ans == -1 && ans2 == -1) {
        a += (1 << (t - 1 - i));
        d = -1;
      }
    } else if (d == 0) {
      cout << "? " << (a + (1 << (t - 1 - i))) << " " << b << endl;
      int ans = 1;
      cin >> ans;
      cout << "? " << (a + (1 << (t - 1 - i))) << " "
           << (b + (1 << (t - 1 - i))) << endl;
      int ans2 = 1;
      cin >> ans2;
      if (ans == 1) {
      } else {
        a += (1 << (t - 1 - i));
        b += (1 << (t - 1 - i));
      }
    } else {
      cout << "? " << a << " " << (b + (1 << (t - 1 - i))) << endl;
      int ans = 1;
      cin >> ans;
      cout << "? " << (a + (1 << (t - 1 - i))) << " "
           << (b + (1 << (t - 1 - i))) << endl;
      int ans2 = 1;
      cin >> ans2;
      if (ans == 0) {
        b += (1 << (t - 1 - i));
        d = 0;
      }
      if (ans == 1 && ans2 == -1) {
        a += (1 << (t - 1 - i));
        b += (1 << (t - 1 - i));
        d = -1;
      }
      if (ans == 1 && ans2 == 1) {
        b += (1 << (t - 1 - i));
        d = 1;
      }
      if (ans == -1 && ans2 == 1) {
        b += (1 << (t - 1 - i));
        d = -1;
      }
      if (ans == -1 && ans2 == -1) {
        d = -1;
      }
    }
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
