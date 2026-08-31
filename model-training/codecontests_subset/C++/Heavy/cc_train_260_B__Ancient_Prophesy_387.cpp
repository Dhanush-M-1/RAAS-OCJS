#include <bits/stdc++.h>
const int S[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
int DtCvt(char *z, bool *F) {
  static const bool H[10] = {0, 0, 1, 0, 0, 1};
  if (10 + H != std::mismatch(H, 10 + H, F).first) return -1;
  static const int M[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  int y, m, d;
  sscanf(z, "%d", &d), sscanf(3 + z, "%d", &m), sscanf(6 + z, "%4d", &y);
  return 0 > (y -= 2013) || 2 < y || !m || 11 < --m || !d || M[m] < d--
             ? -1
             : d + S[m] + 365 * y;
}
void Output(int s) {
  int y = 2013 + s / 365, m = std::upper_bound(1 + S, 12 + S, s %= 365) - S,
      d = 1 + s - S[m - 1];
  printf("%02i-%02i-%i\n", d, m, y);
}
int main(void) {
  bool F[100000];
  char z[100001];
  for (long n, m, S[1095]; gets(z); Output(std::max_element(S, 1095 + S) - S)) {
    for (n = -1; z[++n]; F[n] = '-' == z[n])
      ;
    for (memset(S, 0, sizeof(S)), n -= 9; n--;)
      if (~(m = DtCvt(n + z, n + F))) ++S[m];
  }
  return 0;
}
