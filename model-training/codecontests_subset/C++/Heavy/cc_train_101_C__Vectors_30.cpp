#include <bits/stdc++.h>
using namespace std;
const double EPS = 10e-8;
bool solve(long long int Ax, long long int Ay, long long int Cx,
           long long int Cy, long long int CCx, long long int CCy) {
  long long int d = Cx * CCy - CCx * Cy;
  if (Ax == 0 and Ay == 0) return true;
  if (d < 0) d = -d;
  if (d == 0) return false;
  bool r = true;
  r = ((Ax * CCy - Ay * CCx) % d == 0);
  r = r and ((Cx * Ay - Cy * Ax) % d == 0);
  return r;
}
int main() {
  long long int Ax, Ay, Bx, By, Cx, Cy;
  cin >> Bx >> By >> Ax >> Ay >> Cx >> Cy;
  if (solve(Ax - Bx, Ay - By, Cx, Cy, Cy, -Cx) or
      solve(Ax - By, Ay + Bx, Cx, Cy, Cy, -Cx) or
      solve(Ax + Bx, Ay + By, Cx, Cy, Cy, -Cx) or
      solve(Ax + By, Ay - Bx, Cx, Cy, Cy, -Cx))
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
