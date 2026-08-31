#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T lowbit(T x) {
  return x & (-x);
}
template <class T>
T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
template <class T>
inline T Pow(T a, T b, T p) {
  T ret = 1;
  a %= p;
  for (; b; b >>= 1, a = a * a % p)
    if (b & 1) (ret *= a) %= p;
  return ret;
}
template <class T>
inline void read(T &ret) {
  T x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  ret = x * f;
}
const int N = 3e5 + 10;
int n, m, p[N], loc[N], cnt[N];
vector<int> in[N], out[N];
int main() {
  read(n);
  read(m);
  for (int i = (1); i <= (n); i++) read(p[i]), loc[p[i]] = i;
  for (int i = (1); i <= (m); i++) {
    int x, y;
    read(x);
    read(y);
    x = loc[x];
    y = loc[y];
    if (y > x) cnt[x]++, in[y].push_back(x);
  }
  int ans = 0;
  for (int i = (n - 1); i >= (1); i--)
    if (cnt[i] == n - i - ans) {
      for (auto j = in[i].begin(); j != in[i].end(); j++) cnt[*j]--;
      ans++;
    }
  printf("%d", ans);
}
