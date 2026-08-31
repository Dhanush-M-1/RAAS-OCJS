#include <bits/stdc++.h>
using namespace std;
int sa, sb, f, a, b;
int ask(int c, int d) {
  cout << "? " << c << " " << d << "\n";
  fflush(stdout);
  int x;
  scanf("%d", &x);
  return x;
}
void wt(int c, int d) {
  cout << "! " << c << " " << d << "\n";
  fflush(stdout);
}
int main() {
  f = ask(0, 0);
  for (int i = 29; i >= 0; i--) {
    int x = ask(a ^ (1 << i), b ^ (1 << i));
    if (x == f) {
      int u = ask((1 << i) ^ a, b);
      if (u == -1) {
        a |= (1 << i);
        b |= (1 << i);
      }
    } else {
      if (f == 1)
        a |= (1 << i);
      else
        b |= (1 << i);
      f = ask(a, b);
    }
  }
  wt(a, b);
  return 0;
}
