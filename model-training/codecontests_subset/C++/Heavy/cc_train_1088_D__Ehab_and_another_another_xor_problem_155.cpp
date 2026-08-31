#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
int powe(int x, int y) {
  x = x % mod;
  int ans = 1;
  while (y > 0) {
    if (y & 1) {
      ans = (1ll * x * ans) % mod;
    }
    y >>= 1;
    x = (1ll * x * x) % mod;
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long prev, r1, r2, a = 0, b = 0;
  cout << "? 0 0" << endl;
  cin >> prev;
  for (int i = 29; i >= 0; i--) {
    if (prev == 1) {
      cout << "? " << (a | (1 << i)) << " " << b << endl;
      cin >> r1;
      cout << "? " << (a | (1 << i)) << " " << (b | (1 << i)) << endl;
      cin >> r2;
      if (r2 == -1) {
        prev = r1;
        a = (a | (1 << i));
      } else if (r1 == -1) {
        a = a | (1 << i);
        b = b | (1 << i);
      }
    } else if (prev == -1) {
      cout << "? " << a << " " << (b | (1 << i)) << endl;
      cin >> r1;
      cout << "? " << (a | (1 << i)) << " " << (b | (1 << i)) << endl;
      cin >> r2;
      if (r2 == 1) {
        prev = r1;
        b = (b | (1 << i));
      } else if (r1 == 1) {
        a = a | (1 << i);
        b = b | (1 << i);
      }
    } else {
      cout << "? " << (a | 1 << i) << " " << b << endl;
      cin >> r1;
      if (r1 == -1) {
        a = a | (1 << i);
        b = b | (1 << i);
      }
    }
  }
  cout << "! " << a << " " << b;
  return 0;
}
