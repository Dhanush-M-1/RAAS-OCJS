#include <bits/stdc++.h>
using namespace std;
int eq(int a, int b, int x) {
  int res = 0;
  for (; x >= 0; x--) {
    int c = a, d = b;
    int t = (1 << x);
    cout << "? " << (c ^ t) << " " << d << endl;
    int res1 = 0;
    cin >> res1;
    if (res1 == -1) {
      a = (a ^ t);
      b = (b ^ t);
      res = (res ^ t);
    }
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int a = 0, b = 0;
  int c = 0, d = 0;
  int x = 29;
  int res = 0;
  int agt = 0;
  cout << "? " << c << " " << d << endl;
  cin >> res;
  if (res == 1) {
    agt = 1;
  } else if (res == -1)
    agt = -1;
  else {
    int temp = eq(a, b, x);
    a = (a ^ temp);
    b = (b ^ temp);
    cout << "! " << a << " " << b << endl;
    return 0;
  }
  for (; x >= 0; x--) {
    c = a, d = b;
    int t = (1 << x);
    cout << "? " << (c ^ t) << " " << d << endl;
    int res1 = 0, res2 = 0;
    cin >> res1;
    cout << "? " << (c) << " " << (d ^ t) << endl;
    cin >> res2;
    if (res1 * res2 == 0) {
      if (res1 == 0 && res2 == 0) {
        if (agt > 0)
          a = a ^ t;
        else
          b = b ^ t;
        int temp = eq(a, b, x - 1);
        a = (a ^ temp);
        b = (b ^ temp);
        cout << "! " << a << " " << b << endl;
        return 0;
      }
      if (res1 == 0) {
        b = (b ^ t);
      } else {
        a = (a ^ t);
      }
      int temp = eq(a, b, x - 1);
      a = (a ^ temp);
      b = (b ^ temp);
      cout << "! " << a << " " << b << endl;
      return 0;
    }
    if (res1 * res2 == -1) {
      if (res1 == -1) {
        a = (a ^ t);
        b = (b ^ t);
      }
    } else {
      if (agt > 0) {
        a = (a ^ t);
      } else
        b = (b ^ t);
      agt = res1;
    }
  }
  return 0;
}
