#include <bits/stdc++.h>
using namespace std;
long long a, b, c, d, i, j, ans, sum, A[40], B[40], C[40], x[40], u, point, k,
    u1, fix[40], ind1 = 30, ww, ww1;
bool ok = true;
void point1(long long p, long long AA, long long BB, long long K) {
  ind1--;
  if (ind1 == -1) ok = false;
  if (ind1 >= 0) {
    if (p == 1) {
      for (int i1 = ind1; i1 >= 0; i1--) {
        if (ok) {
          cout << "? " << x[i1] + AA << " " << x[i1] + BB << endl;
          cin >> u;
          if (u == 0) {
            ok = false;
            return;
          }
          if (u != 1) {
            if (u == -1) {
              cout << "? " << x[i1] + AA << " " << BB << endl;
              cin >> u;
              if (u == 1 && ok) {
                A[ind1] = 1;
                fix[ind1] = 1;
                point1(1, AA + x[i1], BB, 0);
              } else {
                A[ind1] = 1;
                fix[ind1] = 1;
                point1(-1, AA + x[i1], BB, 0);
              }
            }
          } else {
            point1(1, AA, BB, K + 1);
          }
        } else
          return;
      }
    } else {
      for (int i1 = ind1; i1 >= 0; i1--) {
        if (ok) {
          cout << "? " << x[i1] + AA << " " << x[i1] + BB << endl;
          cin >> u;
          if (u == 0) {
            ok = false;
            return;
          }
          if (u != -1) {
            cout << "? " << AA << " " << BB + x[i1] << endl;
            cin >> u;
            if (u == -1 && ok) {
              B[ind1] = 1;
              fix[ind1] = 1;
              point1(-1, AA, BB + x[i1], 0);
            } else {
              B[ind1] = 1;
              fix[ind1] = 1;
              point1(1, AA, BB + x[i1], 0);
            }
          } else {
            point1(-1, AA, BB, K + 1);
          }
        } else
          return;
      }
    }
  }
  return;
}
int main() {
  x[0] = 1;
  for (int i = 1; i <= 33; i++) {
    x[i] = x[i - 1] * 2;
  }
  c = 0;
  cout << "? " << c << " " << c << endl;
  cin >> point;
  if (point == 0) {
    c = 0;
    d = 0;
    for (i = 29; i >= 0; i--) {
      c = x[i];
      cout << "? " << c << " " << 0 << endl;
      cin >> u;
      if (u == -1) A[i] = 1;
    }
    c = 0;
    for (i = 29; i >= 0; i--)
      if (A[i]) c += x[i];
    cout << "! " << c << " " << c << endl;
    return 0;
  }
  if (point != 0) {
    if (point == 1)
      point1(1, 0, 0, 1);
    else
      point1(-1, 0, 0, 1);
    a = b = 0;
    for (i = 32; i >= 0; i--)
      if (A[i]) a += x[i];
    for (i = 32; i >= 0; i--)
      if (B[i]) b += x[i];
    for (i = 29; i >= 0; i--) {
      if (fix[i] == 0) {
        ww = (x[i] + a);
        ww1 = (0 + b);
        cout << "? " << ww << " " << ww1 << endl;
        cin >> u;
        if (u == -1) A[i] = B[i] = 1;
      }
    }
    a = b = 0;
    for (i = 32; i >= 0; i--)
      if (A[i]) a += x[i];
    for (i = 32; i >= 0; i--)
      if (B[i]) b += x[i];
    cout << "! " << a << " " << b << endl;
    for (i = 0; i <= 5; i++) {
      cout << A[i] << " ";
    }
    cout << endl;
    for (i = 0; i <= 5; i++) {
      cout << B[i] << " ";
    }
    cout << endl;
    return 0;
  }
  return 0;
}
