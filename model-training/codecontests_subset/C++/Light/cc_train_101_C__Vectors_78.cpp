#include <bits/stdc++.h>
using namespace std;
bool gao(long long A, long long B, long long C, long long D, long long E,
         long long F) {
  long long R = A * E - B * D;
  if (!R)
    return !C && !F;
  else
    return (C * E - B * F) % R == 0 && (C * D - A * F) % R == 0;
}
int main() {
  long long x[3], y[3];
  for (int i = 0; i < 3; i++) scanf("%I64d%I64d", x + i, y + i);
  for (int i = 0; i < 4; i++) {
    if (gao(-y[2], x[2], x[1] - x[0], x[2], y[2], y[1] - y[0]))
      return puts("YES");
    swap(x[0], y[0] *= -1);
  }
  puts("NO");
}
