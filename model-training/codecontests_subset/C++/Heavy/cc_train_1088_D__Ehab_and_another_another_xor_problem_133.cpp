#include <bits/stdc++.h>
using namespace std;
int a, b;
int check(int c, int d) {
  cout << "? " << c << " " << d << endl;
  fflush(stdout);
  int x;
  cin >> x;
  return x;
}
int main() {
  int x1, x2, x3, x4, prevz;
  int curP = (1 << 29);
  x1 = check(a | curP, b);
  x2 = check(a, b);
  x3 = check(a | curP, b | curP);
  x4 = check(a, b | curP);
  if (x2 == x3) {
    if (x1 == 1) {
      a = a;
      b = b;
      prevz = x2;
    } else if (x4 == 1) {
      a = a | curP;
      b = b | curP;
      prevz = x3;
    }
  } else if (x2 == 1 && x3 == -1) {
    a = a | curP;
    b = b;
    prevz = x1;
  } else {
    a = a;
    b = b | curP;
    prevz = x4;
  }
  for (int i = 28; i >= 0; i--) {
    curP = (1 << i);
    if (prevz == 1) {
      x3 = check(a | curP, b | curP);
      if (x3 == 1) {
        x1 = check(a | curP, b);
        if (x1 == 1) {
          a = a;
          b = b;
          prevz = prevz;
        } else {
          a = a | curP;
          b = b | curP;
          prevz = x3;
        }
      } else {
        a = a | curP;
        b = b;
        prevz = check(a, b);
      }
    } else if (prevz == 0) {
      x1 = check(a | curP, b);
      if (x1 == 1) {
        a = a;
        b = b;
        prevz = check(a, b);
      } else {
        a = a | curP;
        b = b | curP;
        prevz = check(a, b);
      }
    } else {
      x3 = check(a | curP, b | curP);
      if (x3 == 1) {
        a = a;
        b = b | curP;
        prevz = check(a, b);
      } else {
        x1 = check(a | curP, b);
        if (x1 == 1) {
          a = a;
          b = b;
          prevz = prevz;
        } else {
          a = a | curP;
          b = b | curP;
          prevz = x3;
        }
      }
    }
  }
  cout << "! " << a << " " << b << endl;
  fflush(stdout);
  return 0;
}
