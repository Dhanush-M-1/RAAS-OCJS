#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
bool check(long long ax, long long ay, long long bx, long long by, long long cx,
           long long cy) {
  long long tx = bx - ax, ty = by - ay;
  if (cx == 0 && cy == 0) return (tx == 0 && ty == 0);
  long long dx = cy, dy = -cx;
  long long a = (tx * dy - dx * ty) / (cx * dy - dx * cy);
  long long b = (tx * cy - cx * ty) / (dx * cy - cx * dy);
  if (a * cx + b * dx != tx) return false;
  if (a * cy + b * dy != ty) return false;
  return true;
}
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  bool flag = false;
  if (check(ax, ay, bx, by, cx, cy)) flag = true;
  if (check(ay, -ax, bx, by, cx, cy)) flag = true;
  if (check(-ax, -ay, bx, by, cx, cy)) flag = true;
  if (check(-ay, ax, bx, by, cx, cy)) flag = true;
  if (flag)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
