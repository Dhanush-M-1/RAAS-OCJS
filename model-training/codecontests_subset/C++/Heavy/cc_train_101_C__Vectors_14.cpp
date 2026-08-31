#include <bits/stdc++.h>
using namespace std;
long double Ax, Ay, Bx, By, Cx, Cy, a11, a12, a21, a22, det;
bool flag;
void f(double x, double y) {
  double tx, ty;
  tx = a11 * x + a12 * y;
  ty = a21 * x + a22 * y;
  cerr << tx << " " << ty << "\n";
  tx = fabs(tx);
  ty = fabs(ty);
  tx += 1e-11;
  ty += 1e-11;
  tx -= (long long)tx;
  ty -= (long long)ty;
  if (flag) {
    tx = x;
    ty = y;
  }
  if (fabs(tx) < 1e-10 && fabs(ty) < 1e-10) {
    cout << "YES\n";
    exit(0);
  }
}
int main() {
  cin >> Ax >> Ay >> Bx >> By >> Cx >> Cy;
  det = Cx * Cx + Cy * Cy;
  flag = fabs(det) < 1e-10;
  a11 = Cx / det;
  a12 = Cy / det;
  a21 = -Cy / det;
  a22 = Cx / det;
  f(Bx - Ax, By - Ay);
  f(Bx - Ay, By + Ax);
  f(Bx + Ax, By + Ay);
  f(Bx + Ay, By - Ax);
  cout << "NO\n";
}
