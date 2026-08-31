#include <bits/stdc++.h>
using namespace std;
int a = 0, b = 0, flag;
int ask(int x, int y) {
  cout << "? " << x << ' ' << y << endl;
  int ans;
  cin >> ans;
  return ans;
}
int main() {
  cout.flush();
  flag = ask(0, 0);
  for (int i = 29; i >= 0; i--) {
    int t = ask(a ^ (1 << i), b), tt = ask(a, b ^ (1 << i));
    if (t == tt) {
      if (flag == 1)
        a ^= (1 << i);
      else if (flag == -1)
        b ^= (1 << i);
      flag = t;
    } else if (t == -1)
      a ^= (1 << i), b ^= (1 << i);
  }
  cout << "! " << a << ' ' << b << endl;
  return 0;
}
