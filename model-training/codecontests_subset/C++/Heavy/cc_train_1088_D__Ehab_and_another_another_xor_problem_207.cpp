#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
int main() {
  cout << "? " << 0 << ' ' << 0 << endl;
  cout.flush();
  int sgn;
  cin >> sgn;
  ;
  int x = 0, y = 0;
  for (int i = 29; i >= 0; i--) {
    if (sgn == 0) {
      int xx = x ^ (1 << i), yy = y;
      cout << "? " << xx << ' ' << yy << endl;
      cout.flush();
      int aux;
      cin >> aux;
      ;
      if (aux == -1) x ^= (1 << i), y ^= (1 << i);
    } else {
      int xx = x ^ (1 << i), yy = y ^ (1 << i);
      cout << "? " << xx << ' ' << yy << endl;
      cout.flush();
      int aux;
      cin >> aux;
      ;
      if (aux == sgn) {
        xx = x, yy = y;
        if (aux == -1)
          yy ^= (1 << i);
        else
          xx ^= (1 << i);
        cout << "? " << xx << ' ' << yy << endl;
        cout.flush();
        int rs;
        cin >> rs;
        ;
        if (rs != sgn) x ^= (1 << i), y ^= (1 << i);
      } else {
        if (sgn == -1)
          y ^= (1 << i);
        else
          x ^= (1 << i);
        cout << "? " << x << ' ' << y << endl;
        cout.flush();
        int rs;
        cin >> rs;
        ;
        sgn = rs;
      }
    }
  }
  cout << "! " << x << ' ' << y << endl;
  cout.flush();
}
