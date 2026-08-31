#include "bits/stdc++.h"

#define requires(...) typename std::enable_if<__VA_ARGS__::value, int>::type = 0

using namespace std;

template<class U, class V>
istream &operator>>(istream &is, pair<U, V> &p) { return is >> p.first >> p.second; }

template<class U, class V>
ostream &operator<<(ostream &os, const pair<U, V> &p) {
  return os << "(" << p.first << ", " << p.second << ")";
}

template<class Istream, class Container, requires(is_same<Istream, istream>)>
Istream &operator>>(Istream &is, Container &container) {
  for (auto &value : container) is >> value;
  return is;
}

template<class Ostream, class Container, requires(is_same<Ostream, ostream>)>
Ostream &operator<<(Ostream &os, const Container &container) {
  auto _begin = begin(container), _end = end(container);
  for (auto it = _begin; it != _end;)
    os << "{ "[it != _begin] << *it << ",}"[++it == _end];
  return os;
}

namespace io {
    template<class ...As>
    struct last {
    };
    template<class ...As> using last_t = typename last<As...>::type;
    template<class A>
    struct last<A> {
        using type = A;
    };
    template<class A, class ...As>
    struct last<A, As...> {
        using type = typename last<As...>::type;
    };

    template<class Z>
    Z read(Z &) {
      Z z;
      cin >> z;
      return z;
    }

    template<class A, class ...As>
    last_t<As...> read(A &a, As &...as) { return cin >> a, read(as...); }

    void log_rest() {}

    template<class A, class ...As>
    void log_rest(const A &a, const As &...as) {
      cerr << ", " << a;
      log_rest(as...);
    }

    template<class A, class ...As>
    void log(const string &pref, const A &a, const As &...as) { cerr << pref << a, log_rest(as...); }
}  // namespace io

#define A(xs) begin(xs), end(xs)
#define B(...) [&](auto &&lhs, auto &&rhs) { \
    return __VA_ARGS__;                      \
  }
#define U(...) [&](auto &&lhs, auto &&rhs) { \
  auto predicate = [&](auto &&x) {           \
    return __VA_ARGS__;                      \
  };                                         \
  return predicate(lhs) < predicate(rhs);    \
}
#define X  first
#define Y  second
#define PB push_back
#define EB emplace_back

#define R(...)        __VA_ARGS__ = io::read(__VA_ARGS__)
#define RC(name, ...) name(__VA_ARGS__); cin >> name

#define G3(_1, _2, _3, FUNC, ...) FUNC
#define F1(i, n)    for (decltype(n) i = {}; i != n; ++i)
#define F2(i, a, b) for (typename common_type<decltype(a), decltype(b)>::type \
                         down = a > b, i = a - down; i + down != b;           \
                         down ? --i : ++i)

#define F(...) G3(__VA_ARGS__, F2, F1)(__VA_ARGS__)

#ifdef DEBUG
int recursion_depth = 0;
#  define D       for (bool _flag = true; _flag; _flag = !_flag)
#  define L(...)  (++recursion_depth,                  \
    io::log(string(recursion_depth - 1, '\t') +        \
        string(__func__) + ":" + to_string(__LINE__) + \
        " \t( "#__VA_ARGS__" ) := ",                   \
        __VA_ARGS__),                                  \
    --recursion_depth, cerr << "\n")
#  define dbg(...) [&](const string &func) -> auto && { \
      ++recursion_depth;                                \
      auto&& value = __VA_ARGS__;                       \
      --recursion_depth;                                \
      cerr << string(recursion_depth, '\t')             \
           << func << ":" << __LINE__                   \
           << " \t"#__VA_ARGS__" = " << value << endl;  \
      return forward<decltype(value)>(value);           \
    }(__func__)
#else
#  define L(...)   while (false) cerr
#  define D        while (false)
#  define dbg(...) (__VA_ARGS__)
#endif

template<class T>
T make_vec(T default_value) { return default_value; }

template<class T, class Arg, class ...Args>
auto make_vec(T default_value, Arg size, Args ...rest)
-> vector<decltype(make_vec(default_value, rest...))> {
  auto level = make_vec(default_value, rest...);
  return vector<decltype(level)>(size, level);
}

template<class Xs>
int sz(const Xs &xs) { return static_cast<int>(xs.size()); }

using i64 = int64_t;
using f80 = long double;

using Str = string;
template<class T = int> using Vec = vector<T>;
template<class K = int, class H = hash<K>> using US = unordered_set<K, H>;
template<class K, class V, class H = hash<K>> using UM = unordered_map<K, V, H>;

template<class U = int, class V = U> using P = pair<U, V>;
using G = Vec<Vec<int>>;

template<class T, class P>
auto bin_search(T l, T r, P p) -> T {
  for (T m; m = (l + r) / 2, m != l && m != r; (p(m) ? l : r) = m);
  return l;
}

Vec<int> parents, sze;
Vec<int> bad;

int get_root(int v) {
  if (parents[v] == v)
    return v;
  return parents[v] = get_root(parents[v]);
}

bool connected(int u, int v) {
  return get_root(u) == get_root(v);
}

void unite(int u, int v) {
  int a = get_root(u);
  int b = get_root(v);
  if (sze[a] < sze[b]) swap(a, b);
  parents[b] = a;
  sze[a] += sze[b];
  bad[a] += bad[b];
}



int64_t mod = 1000000007;

int main() {
  int R(n, m);
  parents.assign(m, 0);
  iota(A(parents), 0);
  sze.assign(m, 1);
  bad.assign(m, 0);
  Vec<int> ans;
  for (int i = 0; i < n; ++i) {
    int R(k);
    if (!k) continue;
    if (k == 1) {
      int R(x);
      --x;
      int root = get_root(x);
      if (bad[root])
        continue;
      bad[root]++;
      ans.push_back(i);
    } else {
      int R(x, y);
      --x;--y;
      int ar = get_root(x), br = get_root(y);
      if (ar == br || (bad[ar] + bad[br] > 1))
        continue;
      unite(ar, br);
      ans.push_back(i);
    }
  }
  i64 answer = 1;
  for (int i = 0; i < ans.size(); ++i) {
    answer *= 2;
    answer %= mod;
  }
  cout << answer << ' ' << ans.size() << '\n';
  for (int x: ans) cout << x+ 1 << ' ';
  return 0;
}

namespace {
    auto fast_io = [] {
#ifndef DEBUG
        #  ifndef INTERACTIVE
        ios::sync_with_stdio(false);
        cin.tie(nullptr);
#  endif // INTERACTIVE
#  ifdef FILES
        freopen(FILES".in", "r", stdin);
        freopen(FILES".out", "w", stdout);
#  endif // FILES
#endif // DEBUG
        cout << setprecision(8) << fixed;
        cerr << boolalpha << setprecision(4) << fixed;

        return 0;
    }();
} // namespace
