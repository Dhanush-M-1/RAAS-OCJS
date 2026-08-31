#include <bits/stdc++.h>
using ll = long long;
bool achievable(ll X, ll Y, ll xc, ll yc) {
  if (!(xc | yc)) return !(X | Y);
  ll vol = xc * xc + yc * yc;
  if ((X * xc + Y * yc) % vol) return 0;
  if ((X * yc - Y * xc) % vol) return 0;
  return 1;
}
int main() {
  ll xa, ya, xb, yb, xc, yc;
  scanf("%lld%lld%lld%lld%lld%lld", &xa, &ya, &xb, &yb, &xc, &yc);
  printf("%s\n", achievable(xb - xa, yb - ya, xc, yc) ||
                         achievable(xb - ya, yb + xa, xc, yc) ||
                         achievable(xb + xa, yb + ya, xc, yc) ||
                         achievable(xb + ya, yb - xa, xc, yc)
                     ? "YES"
                     : "NO");
}
