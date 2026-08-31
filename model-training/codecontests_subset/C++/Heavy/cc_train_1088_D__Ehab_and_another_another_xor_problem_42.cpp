#include <bits/stdc++.h>
using namespace std;
void qq(long long int a, long long int b) {
  cout << "? ";
  cout << a << " " << b;
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  long long int a = 0, b = 0;
  int st;
  qq(0, 0);
  cin >> st;
  for (int i = 29; i >= 0; i--) {
    long long int x = (1ll << i);
    if (st == 0) {
      qq(a, b + x);
      int kk;
      cin >> kk;
      if (kk == 1) a += x, b += x;
    } else if (st == -1) {
      qq(a, b + x);
      int kk;
      cin >> kk;
      if (kk == 0) {
        b += x;
        st = kk;
      } else if (kk == -1) {
        qq(a + x, b + x);
        int k1;
        cin >> k1;
        if (k1 == 1) b += x;
        st = kk;
      } else {
        qq(a + x, b + x);
        int k1;
        cin >> k1;
        st = kk;
        if (k1 == 1)
          b += x;
        else
          a += x, b += x, st = -1;
      }
    } else {
      qq(a + x, b);
      int kk;
      cin >> kk;
      if (kk == 0) {
        a += x;
        st = kk;
      } else if (kk == -1) {
        qq(a + x, b + x);
        int k1;
        cin >> k1;
        if (k1 == -1) {
          a += x;
          st = kk;
        } else {
          a += x;
          b += x;
          st = 1;
        }
      } else {
        qq(a + x, b + x);
        int k1;
        cin >> k1;
        if (k1 == -1) {
          a += x;
          st = kk;
        } else {
          st = kk;
        }
      }
    }
  }
  cout << "! ";
  cout << a << " " << b;
  cout << "\n";
  return 0;
}
