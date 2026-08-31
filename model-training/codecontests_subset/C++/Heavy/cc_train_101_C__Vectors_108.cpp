#include <bits/stdc++.h>
using namespace std;
long long Ax, Ay, Bx, By, x, y;
long long tmpAx, tmpAy;
bool mod(long long opa, long long opb) {
  if (opa % opb) return false;
  return true;
}
bool check2() {
  long long A = tmpAx, B = tmpAy;
  long long tmp = A * y - B * x, op = y * y + x * x;
  long long tmp1 = A * x + B * y, op1 = x * x + y * y;
  if (op == 0) return A == 0 && B == 0;
  if (tmp % op == 0 && tmp1 % op1 == 0) return true;
  return false;
}
bool check() {
  tmpAx = Ax - Bx;
  tmpAy = Ay - By;
  if (check2()) return true;
  tmpAx = Ax + Bx;
  tmpAy = Ay + By;
  if (check2()) return true;
  tmpAx = Ax - By;
  tmpAy = Ay + Bx;
  if (check2()) return true;
  tmpAx = Ax + By;
  tmpAy = Ay - Bx;
  if (check2()) return true;
  return false;
}
int main() {
  scanf("%I64d%I64d", &Ax, &Ay);
  scanf("%I64d%I64d", &Bx, &By);
  scanf("%I64d%I64d", &x, &y);
  if (check())
    printf("YES");
  else
    printf("NO");
  return 0;
}
