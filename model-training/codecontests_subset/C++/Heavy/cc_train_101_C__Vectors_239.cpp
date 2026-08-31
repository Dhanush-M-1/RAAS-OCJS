#include <bits/stdc++.h>
using namespace std;
long long Ax, Ay, Bx, By, Cx, Cy;
bool solvable(long long A, long long B) {
  return (Cx * A + Cy * B) % (Cx * Cx + Cy * Cy) == 0 &&
         (-Cy * A + Cx * B) % (Cx * Cx + Cy * Cy) == 0;
}
bool possible() {
  cin >> Ax >> Ay >> Bx >> By >> Cx >> Cy;
  if (Cx == 0 && Cy == 0) {
    if (Bx == Ax && By == Ay) return true;
    if (Bx == Ay && By == -Ax) return true;
    if (Bx == -Ax && By == -Ay) return true;
    if (Bx == -Ay && By == Ax) return true;
    return false;
  }
  if (solvable(Bx - Ax, By - Ay)) return true;
  if (solvable(Bx - Ay, By + Ax)) return true;
  if (solvable(Bx + Ax, By + Ay)) return true;
  if (solvable(Bx + Ay, By - Ax)) return true;
  return false;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout << (possible() ? "YES" : "NO") << endl;
  cout << flush;
  return 0;
}
