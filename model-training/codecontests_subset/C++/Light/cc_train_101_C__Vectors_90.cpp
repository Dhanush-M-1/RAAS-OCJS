#include <bits/stdc++.h>
long long int x, y, S, T, a, b;
int AC = 0;
int f(long long int S, long long int T) {
  if (x == S && y == T) return 1;
  if (a == 0 && b == 0) return 0;
  long long int A = b, B = a, C = S - x, D = -a, E = b, F = T - y;
  long long int DET = A * E - B * D, DX = B * F - C * E, DY = A * F - C * D;
  if (DX % DET == 0 && DY % DET == 0)
    return 1;
  else
    return 0;
}
int main() {
  scanf("%I64d%I64d%I64d%I64d%I64d%I64d", &x, &y, &S, &T, &a, &b);
  AC = 0;
  AC = f(S, T) || f(-T, S) || f(-S, -T) || f(T, -S);
  printf("%s\n", AC ? "YES" : "NO");
  return 0;
}
