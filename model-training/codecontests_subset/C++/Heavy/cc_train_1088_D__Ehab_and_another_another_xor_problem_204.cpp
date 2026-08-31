#include <bits/stdc++.h>
long long int mod = 1000000000 + 7;
long long int inf = (long long int)(5e18);
using namespace std;
mt19937 unlucko(chrono::steady_clock::now().time_since_epoch().count());
int main() {
  iostream::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int a = 0, b = 0;
  int cmp;
  cout << "? 0 0" << endl;
  cin >> cmp;
  for (int i = 29; i >= 0; i--) {
    cout << "? " << (1 << i) + a << " " << (1 << i) + b << endl;
    int x;
    cin >> x;
    if (x == 0) {
      cout << "? " << (1 << i) + a << " " << b << endl;
      cin >> x;
      if (x == -1) {
        a ^= (1 << i);
        b ^= (1 << i);
      }
    } else if (x == 1) {
      if (cmp == -1) {
        b ^= (1 << i);
        cout << "? " << a << " " << b << endl;
        cin >> cmp;
      } else {
        cout << "? " << a + (1 << i) << " " << b << endl;
        cin >> x;
        if (x == -1) a ^= (1 << i), b ^= (1 << i);
      }
    } else {
      if (cmp == 1) {
        a ^= (1 << i);
        cout << "? " << a << " " << b << endl;
        cin >> cmp;
      } else {
        cout << "? " << a << " " << b + (1 << i) << endl;
        cin >> x;
        if (x == 1) a ^= (1 << i), b ^= (1 << i);
      }
    }
  }
  cout << "! " << a << " " << b << endl;
}
