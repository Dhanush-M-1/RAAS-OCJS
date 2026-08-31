#include <bits/stdc++.h>
using namespace std;
bool can(long long x, long long y, long long m, long long n) {
  if (m == 0 && n == 0) return x == 0 && y == 0;
  return abs(x * m + y * n) % (m * m + n * n) == 0 &&
         abs(x * n - y * m) % (m * m + n * n) == 0;
}
int main() {
  int A[2], B[2], C[2];
  while (cin >> A[0] >> A[1] >> B[0] >> B[1] >> C[0] >> C[1]) {
    bool ok = 0;
    ok |= can(B[0] - A[0], B[1] - A[1], C[0], C[1]);
    ok |= can(B[0] + A[0], B[1] + A[1], C[0], C[1]);
    ok |= can(B[0] - A[1], B[1] + A[0], C[0], C[1]);
    ok |= can(B[0] + A[1], B[1] - A[0], C[0], C[1]);
    if (ok)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
