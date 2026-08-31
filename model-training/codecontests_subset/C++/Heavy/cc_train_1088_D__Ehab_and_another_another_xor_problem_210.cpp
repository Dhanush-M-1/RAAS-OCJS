#include <bits/stdc++.h>
using namespace std;
void gao1() {
  long long a = 0, b = 0;
  for (int i = 29; i >= 0; i--) {
    cout << "? " << (a + (1ll << i)) << " " << a << endl;
    fflush(stdout);
    int x;
    cin >> x;
    if (x == -1) {
      a |= (1 << i);
    }
  }
  cout << "! " << a << " " << a << endl;
  fflush(stdout);
  return;
}
int main() {
  long long a = 0, b = 0;
  cout << "? " << 0 << " " << 0 << endl;
  fflush(stdout);
  int ttt;
  cin >> ttt;
  if (ttt == 0) {
    gao1();
    return 0;
  }
  int flag = ttt;
  for (int i = 29; i >= 0; i--) {
    cout << "? " << (a + (1 << i)) << " " << (b + (1 << i)) << endl;
    fflush(stdout);
    int tmp;
    cin >> tmp;
    if (tmp == 0) {
      for (int j = i; j >= 0; j--) {
        cout << "? " << (a + (1 << j)) << " " << (b) << endl;
        fflush(stdout);
        int tt;
        cin >> tt;
        if (tt == -1) {
          a += (1 << j);
          b += (1 << j);
        }
      }
      cout << "! " << a << " " << b << endl;
      fflush(stdout);
      return 0;
    } else if (tmp == -flag) {
      if (flag == 1) {
        a += (1 << i);
      } else {
        b += (1 << i);
      }
      cout << "? " << (a) << " " << (b) << endl;
      fflush(stdout);
      cin >> flag;
      if (flag == 0) {
        for (int j = i - 1; j >= 0; j--) {
          cout << "? " << (a + (1 << j)) << " " << (b) << endl;
          fflush(stdout);
          int tt;
          cin >> tt;
          if (tt == -1) {
            a += (1 << j);
            b += (1 << j);
          }
        }
        cout << "! " << a << " " << b << endl;
        fflush(stdout);
        return 0;
      }
    } else {
      if (flag == 1) {
        cout << "? " << (a + (1 << i)) << " " << (b) << endl;
        fflush(stdout);
        int tmp;
        cin >> tmp;
        if (tmp == 0) {
          a += (1 << i);
          for (int j = i - 1; j >= 0; j--) {
            cout << "? " << (a + (1 << j)) << " " << (b) << endl;
            fflush(stdout);
            int tt;
            cin >> tt;
            if (tt == -1) {
              a += (1 << j);
              b += (1 << j);
            }
          }
          cout << "! " << a << " " << b << endl;
          fflush(stdout);
          return 0;
        }
        if (tmp == -1) {
          a += (1 << i);
          b += (1 << i);
        }
      } else if (flag == -1) {
        cout << "? " << (a) << " " << (b + (1 << i)) << endl;
        fflush(stdout);
        int tmp;
        cin >> tmp;
        if (tmp == 0) {
          b += (1 << i);
          for (int j = i - 1; j >= 0; j--) {
            cout << "? " << (a + (1 << j)) << " " << (b) << endl;
            fflush(stdout);
            int tt;
            cin >> tt;
            if (tt == -1) {
              a += (1 << j);
              b += (1 << j);
            }
          }
          cout << "! " << a << " " << b << endl;
          fflush(stdout);
          return 0;
        }
        if (tmp == 1) {
          a += (1 << i);
          b += (1 << i);
        }
      }
    }
  }
  cout << "! " << a << " " << b << endl;
  fflush(stdout);
  return 0;
}
