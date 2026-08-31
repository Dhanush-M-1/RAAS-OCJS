#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
long long a3, b3;
bool check1(long long a1, long long b1, long long a2, long long b2) {
  if ((a2 * a3 + b2 * b3 + a1 * b3 - a3 * b1) % (a3 * a3 + b3 * b3))
    return false;
  if ((a2 * b3 - b2 * a3 - a1 * a3 - b1 * b3) % (a3 * a3 + b3 * b3))
    return false;
  return true;
}
bool check2(long long a1, long long b1, long long a2, long long b2) {
  if ((a2 * a3 + b2 * b3 - a1 * a3 - b1 * b3) % (a3 * a3 + b3 * b3))
    return false;
  if ((a1 * b3 - b1 * a3 - a2 * b3 + b2 * a3) % (a3 * a3 + b3 * b3))
    return false;
  return true;
}
bool check(long long a1, long long b1, long long a2, long long b2) {
  if (a1 == a2 && b1 == b2) return true;
  if (b1 == a2 && -a1 == b2) return true;
  if (-a1 == a2 && -b1 == b2) return true;
  if (-b1 == a2 && a1 == b2) return true;
  return false;
}
int main() {
  long long a1, a2, b1, b2;
  while (~scanf("%lld%lld%lld%lld%lld%lld", &a1, &b1, &a2, &b2, &a3, &b3)) {
    if (a3 == b3 && a3 == 0) {
      puts(check(a1, b1, a2, b2) ? "YES" : "NO");
    } else {
      int ok = 0;
      ok += check(a1, b1, a2, b2);
      ok += check1(a1, b1, a2, b2);
      ok += check1(a1, b1, b2, -a2);
      ok += check1(a1, b1, -a2, -b2);
      ok += check1(a1, b1, -b2, a2);
      ok += check2(a1, b1, a2, b2);
      ok += check2(a1, b1, b2, -a2);
      ok += check2(a1, b1, -a2, -b2);
      ok += check2(a1, b1, -b2, a2);
      puts(ok ? "YES" : "NO");
    }
  }
  return 0;
}
