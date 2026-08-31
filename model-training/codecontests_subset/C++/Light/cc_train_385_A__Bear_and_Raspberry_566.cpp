#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, U b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, U b) {
  if (a < b) a = b;
}
int power(int a, int b, int m, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % m)
    if (b & 1) ans = 1LL * ans * a % m;
  return ans;
}
int a[110];
int main() {
  int n, c;
  scanf("%d%d", &n, &c);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  int m = 0;
  for (int i = 1; i < n; i++) smax(m, a[i - 1] - a[i] - c);
  printf("%d", m);
  return 0;
}
