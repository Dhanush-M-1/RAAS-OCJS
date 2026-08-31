#include <bits/stdc++.h>
using namespace std;
bool solve(long long A, long long B, long long C, long long D, long long E,
           long long F) {
  return (C * E - B * F) % (A * E - B * D) == 0 &&
         (C * D - A * F) % (B * D - A * E) == 0;
}
int main() {
  long long x[3], y[3];
  for (int i = 0; i < 3; i++) scanf("%I64d%I64d", x + i, y + i);
  if (!x[2] && !y[2]) {
    for (int i = 0; i < 4; i++) {
      if (x[0] == x[1] && y[0] == y[1]) return puts("YES");
      swap(x[0], y[0] *= -1);
    }
    return puts("NO");
  }
  for (int i = 0; i < 4; i++) {
    if (solve(-y[2], x[2], x[1] - x[0], x[2], y[2], y[1] - y[0]))
      return puts("YES");
    swap(x[0], y[0] *= -1);
  }
  puts("NO");
}
