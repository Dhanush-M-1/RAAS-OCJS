#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-11;
const int INFINITE = 0x3f3f3f3f;
template <class T>
inline void checkmin(T &a, T b) {
  if (b < a) a = b;
}
template <class T>
inline void checkmax(T &a, T b) {
  if (b > a) a = b;
}
template <class T>
inline T sqr(T x) {
  return x * x;
}
template <class T>
inline T lowbit(T n) {
  return (n ^ (n - 1)) & n;
}
template <class T>
inline int countbit(T n) {
  return (n == 0) ? 0 : (1 + countbit(n & (n - 1)));
}
typedef vector<int> VI;
typedef vector<VI> VII;
typedef vector<string> VS;
int main() {
  ios::sync_with_stdio(false);
  int n, x, y;
  scanf("%d%d%d", &n, &x, &y);
  double rem = (y * n) / 100.0 - 1.f * x;
  int res;
  if (rem < 0.0)
    res = 0;
  else
    res = (int)ceil(rem);
  printf("%d\n", res);
  return 0;
}
