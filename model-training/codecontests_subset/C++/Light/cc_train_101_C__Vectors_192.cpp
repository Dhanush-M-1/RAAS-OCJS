#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
bool f(long long P, long long Q) {
  if (cx == 0 && cy == 0) return P == 0 && Q == 0;
  long long r1 = (P * cx + Q * cy) % ((cx) * (cx) + (cy) * (cy));
  long long r2 = (P * cy - Q * cx) % ((cx) * (cx) + (cy) * (cy));
  return r1 == 0 && r2 == 0;
}
int main() {
  cout << setprecision(9);
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  if (f(bx - ax, by - ay) || f(bx - ay, by + ax) || f(bx + ax, by + ay) ||
      f(bx + ay, by - ax))
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
