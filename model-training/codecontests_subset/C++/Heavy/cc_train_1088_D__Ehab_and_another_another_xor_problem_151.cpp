#include <bits/stdc++.h>
using namespace std;
int get() {
  fflush(stdout);
  int x;
  cin >> x;
  return x;
}
int main() {
  cout << "? 0 0" << endl;
  int sta = get(), ansa = 0, ansb = 0;
  for (int i = 29; i >= 0; i--) {
    int tmp = 1 << i;
    if (sta == 0) {
      cout << "? " << (ansa | tmp) << " " << ansb << endl;
      int now = get();
      if (now == -1) ansa |= tmp, ansb |= tmp;
    } else {
      cout << "? " << (ansa | tmp) << " " << (ansb | tmp) << endl;
      int now = get();
      if (sta == now) {
        if (sta == -1) {
          cout << "? " << (ansa | tmp) << " " << ansb << endl;
          int now = get();
          if (now == 0) ansb |= tmp, sta = 0;
          if (now == -1) ansa |= tmp, ansb |= tmp;
        } else {
          cout << "? " << ansa << " " << (ansb | tmp) << endl;
          int now = get();
          if (now == 0) ansa |= tmp, sta = 0;
          if (now == 1) ansa |= tmp, ansb |= tmp;
        }
      } else {
        if (sta == 1 && now == -1) {
          ansa |= tmp;
          cout << "? " << ansa << " " << ansb << endl;
          sta = get();
        } else {
          ansb |= tmp;
          cout << "? " << ansa << " " << ansb << endl;
          sta = get();
        }
      }
    }
  }
  cout << "! " << ansa << " " << ansb << endl;
  fflush(stdout);
}
