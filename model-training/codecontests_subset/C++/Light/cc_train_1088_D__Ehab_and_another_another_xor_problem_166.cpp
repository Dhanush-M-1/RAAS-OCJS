#include <bits/stdc++.h>
using namespace std;
int a = 0;
int b = 0;
int ok;
int qry(int a, int b) {
  cout << "? " << a << " " << b << endl;
  int ans;
  cin >> ans;
  return ans;
}
int main() {
  int ok = qry(0, 0);
  for (int i = 29; i >= 0; i--) {
    int cura = a | (1 << i);
    int curb = b | (1 << i);
    int ans1 = qry(a, curb);
    int ans2 = qry(cura, b);
    if (ans1 == ans2) {
      if (ok == 1) {
        a = cura;
        ok = ans1;
      } else {
        b = curb;
        ok = ans2;
      }
    } else {
      if (ans1 != -1) {
        a = cura;
        b = curb;
      }
    }
  }
  cout << "! " << a << ' ' << b << endl;
}
