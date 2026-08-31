#include <bits/stdc++.h>
using namespace std;
int dirx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int diry[] = {-1, 0, 1, -1, 1, -1, 0, 1};
int ask(int c, int d) {
  cout << "? " << c << " " << d << endl;
  cout.flush();
  int scan;
  cin >> scan;
  return scan;
}
int main() {
  int a = 0, b = 0;
  int g = ask(0, 0);
  for (int i = 29; i >= 0; i--) {
    int f = ask(a ^ (1 << i), b);
    int s = ask(a, b ^ (1 << i));
    if (f == s) {
      if (g == 1)
        a |= 1 << i;
      else
        b |= 1 << i;
      g = f;
    } else if (f == -1) {
      a |= (1 << i);
      b |= 1 << i;
    }
  }
  cout << "! " << a << " " << b;
}
