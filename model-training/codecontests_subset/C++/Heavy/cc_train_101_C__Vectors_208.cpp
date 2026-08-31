#include <bits/stdc++.h>
using namespace std;
struct pnt {
  long long x, y;
  pnt(long long _x = 0, long long _y = 0) : x(_x), y(_y) {}
};
pnt operator+(const pnt& A, const pnt& B) { return pnt(A.x + B.x, A.y - B.y); }
pnt operator-(const pnt& A, const pnt& B) { return pnt(A.x - B.x, A.y - B.y); }
pnt rot(const pnt& A) { return pnt(A.y, -A.x); }
bool solve(pnt z, pnt c) {
  long long z1 = z.x, z2 = z.y;
  long long c1 = c.x, c2 = c.y;
  if (c1 == 0 && c2 == 0) return z1 == 0 && z2 == 0;
  long long num = c1 * z1 + c2 * z2;
  long long denum = c1 * c1 + c2 * c2;
  if (num % denum != 0) return false;
  long long u = num / denum;
  num = z1 - u * c1;
  denum = c2;
  if (denum != 0)
    return num % denum == 0;
  else
    return z1 % c1 == 0 && z2 % c1 == 0;
}
int main() {
  pnt A, B, C;
  cin >> A.x >> A.y;
  cin >> B.x >> B.y;
  cin >> C.x >> C.y;
  pnt x = A;
  pnt y = B;
  pnt c = C;
  pnt xrot = x;
  bool result = false;
  for (int i = 1; i <= 4; i++) {
    pnt z = y - xrot;
    if (solve(z, c)) result = true;
    xrot = rot(xrot);
  }
  if (result)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
