#include <bits/stdc++.h>
using std::abs;
using std::bitset;
using std::cerr;
using std::cin;
using std::copy;
using std::cout;
using std::deque;
using std::endl;
using std::fill;
using std::fixed;
using std::greater;
using std::iota;
using std::istream;
using std::lower_bound;
using std::make_pair;
using std::make_tuple;
using std::map;
using std::max;
using std::max_element;
using std::min;
using std::min_element;
using std::multiset;
using std::next_permutation;
using std::nth_element;
using std::ostream;
using std::pair;
using std::priority_queue;
using std::queue;
using std::reverse;
using std::rotate;
using std::set;
using std::sort;
using std::string;
using std::swap;
using std::tie;
using std::tuple;
using std::unique;
using std::unordered_map;
using std::unordered_set;
using std::upper_bound;
using std::vector;
long long rnd(long long x, long long y) {
  static auto gen = std::bind(std::uniform_int_distribution<long long>(),
                              std::mt19937(960172));
  return gen() % (y - x + 1) + x;
}
long long gcd(long long a, long long b) {
  while (b > 0) {
    long long t = a % b;
    a = b;
    b = t;
  }
  return a;
}
template <typename T>
T sqr(T const& a) {
  return a * a;
}
int const INF = 100 + (int)1e9;
long long const INFL = 100 + (long long)1e18;
long double const PI = 3.1415926535897932384626433832795028;
struct ratio_t {
  int num, den;
  ratio_t() {}
  ratio_t(int num, int den) : num(num), den(den) {
    int g = gcd(num, den);
    num /= g;
    den /= g;
  }
  ratio_t inv() const { return ratio_t(den, num); }
};
bool operator<(ratio_t const& a, ratio_t const& b) {
  return (long long)a.num * b.den < (long long)b.num * a.den;
}
bool operator==(ratio_t const& a, ratio_t const& b) {
  return (long long)a.num * b.den == (long long)b.num * a.den;
}
int rev(int a) {
  int b = 0;
  while (a > 0) {
    b = 10 * b + a % 10;
    a /= 10;
  }
  return b;
}
ratio_t AR(int a) { return ratio_t(a, rev(a)); }
ratio_t RA(int a) { return ratio_t(rev(a), a); }
void solve() {
  int X, Y, W;
  scanf("%d%d%d", &X, &Y, &W);
  map<ratio_t, int> ar, ra;
  int x = 1, y = 0;
  long long cnt = 0;
  ++ar[AR(x)];
  while (y < Y && cnt < W) {
    ++y;
    cnt += ar[RA(y)];
    ++ra[RA(y)];
  }
  int ax = -1, ay = -1;
  long long area = INFL;
  while (x <= X) {
    if (cnt >= W) {
      long long cur = (long long)x * y;
      if (cur < area) {
        area = cur;
        ax = x;
        ay = y;
      }
    }
    ++x;
    cnt += ra[AR(x)];
    ++ar[AR(x)];
    while (true) {
      long long next = cnt - ar[RA(y)];
      if (next >= W) {
        --ra[RA(y)];
        --y;
        cnt = next;
      } else
        break;
    }
  }
  if (ax < 0) {
    puts("-1");
    return;
  }
  printf("%d %d\n", ax, ay);
}
int main() {
  cout.precision(15);
  cout << fixed;
  cerr.precision(6);
  cerr << fixed;
  solve();
}
