#include <bits/stdc++.h>
using namespace std;
struct node {
  long long x, y;
} A, B, C;
bool judge(long long x, long long y) {
  struct node D;
  D.x = C.y, D.y = -C.x;
  x = B.x - x, y = B.y - y;
  if (C.x == 0 && C.y == 0) {
    if (x == 0 && y == 0) return 1;
  } else if (C.x == 0 && C.y != 0) {
    if (x % D.x == 0 && y % C.y == 0) return 1;
  } else if (C.x != 0 && C.y == 0) {
    if (x % C.x == 0 && y % D.y == 0) return 1;
  } else {
    long long num2 = D.y * C.x - D.x * C.y;
    long long num1 = y * C.x - x * C.y;
    if (num2 == 0) {
      if (num1 == 0) return 1;
    } else {
      if (num1 % num2 == 0) {
        long long b = num1 / num2;
        long long c = x - b * D.x;
        if (c % C.x == 0) return 1;
      }
    }
  }
  return 0;
}
int main() {
  while (cin >> A.x >> A.y >> B.x >> B.y >> C.x >> C.y) {
    bool flag = false;
    if (judge(A.x, A.y)) flag = true;
    if (judge(A.y, -A.x)) flag = true;
    if (judge(-A.x, -A.y)) flag = true;
    if (judge(-A.y, A.x)) flag = true;
    if (flag == true)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
