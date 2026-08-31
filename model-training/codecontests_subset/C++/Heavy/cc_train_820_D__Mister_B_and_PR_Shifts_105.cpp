#include <bits/stdc++.h>
using namespace std;
template <typename G>
inline void read(G &x) {
  x = 0;
  char c;
  while (!isdigit(c = getchar()))
    ;
  do {
    x = x * 10 + c - '0';
  } while (isdigit(c = getchar()));
}
template <typename G>
inline void write(G x) {
  if (x > 9) write(x / 10);
  putchar(x % 10 + '0');
}
template <class T>
inline T min(T a, T b, T c) {
  return min(a, min(b, c));
}
template <class T>
inline T min(T a, T b, T c, T d) {
  return min(a, min(b, c, d));
}
template <class T>
inline T max(T a, T b, T c) {
  return max(a, max(b, c));
}
template <class T>
inline T max(T a, T b, T c, T d) {
  return max(a, max(b, c, d));
}
const int MAXN = 1e6 + 7;
const int base = 1e9 + 7;
const int N = 2e6 + 7;
int n, m;
int p[MAXN], bit[2 * MAXN];
long long res;
void upd(int x, int value) {
  while (x <= 2 * m) {
    bit[x] += value;
    x += x & (-x);
  }
}
int get(int x) {
  int res = 0;
  while (x) {
    res += bit[x];
    x -= x & (-x);
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  read(n);
  for (int i = (1); i <= (n); ++i) read(p[i]);
  m = n;
  for (int i = (1); i <= (n); ++i) {
    upd(p[i] - i + m, 1);
    res += abs(p[i] - i);
  }
  long long mii = res;
  int ans = 0;
  for (int k = (1); k <= (n); ++k) {
    int i = n - k + 1;
    res -= abs(p[i] - n);
    res += abs(p[i] - 1);
    upd(p[i] - n + m, -1);
    int x = get(m + k - 1);
    res += x;
    res -= (n - 1 - x);
    upd(p[i] - 1 + m + k, 1);
    if (res < mii) {
      ans = k;
      mii = res;
    }
  }
  cout << mii << ' ' << ans << '\n';
  return 0;
}
