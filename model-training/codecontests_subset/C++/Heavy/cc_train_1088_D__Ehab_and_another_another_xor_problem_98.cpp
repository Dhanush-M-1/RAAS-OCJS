#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int a = 0;
  int b = 0;
  int bit = 1 << 29;
  int ans = 0;
  cout << "? " << 0 << " " << 0 << endl;
  cout.flush();
  int cstate;
  cin >> cstate;
  for (int i = 0; i < 30; i++) {
    if (cstate != 0) {
      cout << "? " << a + bit << " " << b + bit << endl;
      cout.flush();
      cin >> ans;
      if (ans == cstate) {
        cout << "? " << a + bit << " " << b << endl;
        cout.flush();
        cin >> ans;
        if (ans == -1) {
          a += bit;
          b += bit;
        }
      } else {
        if (cstate == 1) {
          a += bit;
        } else {
          b += bit;
        }
        cout << "? " << a << " " << b << endl;
        cout.flush();
        cin >> cstate;
      }
    } else {
      cout << "? " << a + bit << " " << b << endl;
      cout.flush();
      cin >> ans;
      if (ans == -1) {
        a += bit;
        b += bit;
      }
    }
    bit >>= 1;
  }
  cout << "! " << a << " " << b << endl;
  cout.flush();
}
