#include <bits/stdc++.h>
using namespace std;
bool isSolvable(long long A, long long B, long long a, long long b) {
  long long delr = a * a + b * b;
  if (delr == 0) {
    return A == 0 && B == 0;
  }
  if (((A * b - B * a) % delr == 0) && ((b * B + a * A) % delr == 0))
    return true;
  else
    return false;
}
int main() {
  long long x, y, a, b, A, B;
  cin >> x >> y;
  cin >> A >> B;
  cin >> a >> b;
  bool a1 = isSolvable(A - x, B - y, a, b);
  bool a2 = isSolvable(A + y, B - x, a, b);
  bool a3 = isSolvable(A + x, B + y, a, b);
  bool a4 = isSolvable(A - y, B + x, a, b);
  if (a1 || a2 || a3 || a4)
    puts("YES");
  else
    puts("NO");
  return 0;
}
