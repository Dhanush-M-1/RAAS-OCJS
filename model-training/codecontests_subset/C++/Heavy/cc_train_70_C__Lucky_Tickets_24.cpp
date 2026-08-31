#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 20;
template <typename T>
inline void hash_combine(size_t &seed, const T &value) {
  seed ^= hash<T>()(value) + 0x9e3779b9 + (seed << 6) + (seed >> 2);
}
template <typename T>
inline void hash_val(size_t &seed, const T &val) {
  hash_combine(seed, val);
}
template <typename T, typename... Types>
inline void hash_val(size_t &seed, const T &val, const Types &...args) {
  hash_combine(seed, val);
  hash_val(seed, args...);
}
template <typename... Types>
inline size_t hash_val(const Types &...args) {
  size_t seed = 0;
  hash_val(seed, args...);
  return seed;
}
class obHash {
 public:
  std::size_t operator()(const pair<long long, long long> &c) const {
    return hash_val(c.first, c.second);
  }
};
long long rev[MAX];
unordered_map<pair<long long, long long>, long long, obHash> m1, m2;
long long gcd(long long a, long long b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
pair<long long, long long> aa[MAX], bb[MAX];
long long maxx, maxy, w;
int main() {
  scanf("%lld%lld%lld", &maxx, &maxy, &w);
  for (int i = (1); i <= (100000); ++i) {
    int tt = i, base = 1;
    rev[i] = 0;
    tt /= 10;
    while (tt) {
      tt /= 10;
      base *= 10;
    }
    tt = i;
    while (tt) {
      rev[i] += base * (tt % 10);
      tt /= 10;
      base /= 10;
    }
  }
  for (int i = (1); i <= (100000); ++i) {
    long long d = gcd(i, rev[i]);
    aa[i] = {(long long)i / d, rev[i] / d};
    bb[i] = {rev[i] / d, (long long)i / d};
  }
  long long x = 1, y = maxy;
  for (int i = (1); i <= (maxy); ++i) {
    ++m2[bb[i]];
  }
  ++m1[aa[1]];
  long long value = m1[aa[1]] * m2[aa[1]], ans = LLONG_MAX, optx, opty;
  while (x <= maxx && y >= 1) {
    if (value >= w) {
      if ((long long)x * y < ans) ans = (long long)x * y, optx = x, opty = y;
      value -= m1[bb[y]], --m2[bb[y]], --y;
    } else {
      ++x;
      if (x <= maxx) {
        ++m1[aa[x]], value += m2[aa[x]];
      }
    }
  }
  if (ans == LLONG_MAX)
    printf("-1\n");
  else
    printf("%lld %lld\n", optx, opty);
  return 0;
}
