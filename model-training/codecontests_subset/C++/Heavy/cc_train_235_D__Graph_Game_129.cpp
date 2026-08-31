#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math")
using namespace std;
const double inf = 1e121;
const double eps = 1e-10;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
long long randint(long long l, long long r) {
  long long out = rng() % (r - l + 1) + l;
  return out >= l ? out : out + r - l + 1;
}
template <typename A, typename B>
string to_string(pair<A, B> p);
template <typename A, typename B, typename C>
string to_string(tuple<A, B, C> p);
template <typename A, typename B, typename C, typename D>
string to_string(tuple<A, B, C, D> p);
string to_string(const string& s) { return '"' + s + '"'; }
string to_string(const char* s) { return to_string((string)s); }
string to_string(bool b) { return (b ? "true" : "false"); }
string to_string(vector<bool> v) {
  bool first = true;
  string res = "{";
  for (long long i = 0; i < static_cast<long long>(v.size()); i++) {
    if (!first) {
      res += ", ";
    }
    first = false;
    res += to_string(v[i]);
  }
  res += "}";
  return res;
}
template <size_t N>
string to_string(bitset<N> v) {
  string res = "";
  for (size_t i = 0; i < N; i++) {
    res += static_cast<char>('0' + v[i]);
  }
  return res;
}
template <typename A>
string to_string(A v) {
  bool first = true;
  string res = "{";
  for (const auto& x : v) {
    if (!first) {
      res += ", ";
    }
    first = false;
    res += to_string(x);
  }
  res += "}";
  return res;
}
template <typename A, typename B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A, typename B, typename C>
string to_string(tuple<A, B, C> p) {
  return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
         to_string(get<2>(p)) + ")";
}
template <typename A, typename B, typename C, typename D>
string to_string(tuple<A, B, C, D> p) {
  return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
         to_string(get<2>(p)) + ", " + to_string(get<3>(p)) + ")";
}
template <typename A, typename B, typename C, typename D, typename E>
string to_string(tuple<A, B, C, D, E> p) {
  return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
         to_string(get<2>(p)) + ", " + to_string(get<3>(p)) + "," +
         to_string(get<4>(p)) + ")";
}
void debug_out() { cerr << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << to_string(H);
  debug_out(T...);
}
template <typename T>
struct is_pair {
  static const bool value = false;
};
template <typename T, typename U>
struct is_pair<std::pair<T, U>> {
  static const bool value = true;
};
const long long INF = 0x3f3f3f3f3f3f3f3fll;
template <typename T>
typename enable_if<!is_integral<T>::value && !is_pair<T>::value, void>::type
read(T& x) {
  cin >> x;
}
long long read() {
  char c;
  long long out = 0, f = 1;
  for (c = getchar(); !isdigit(c) && c != '-'; c = getchar()) {
  }
  if (c == '-') {
    f = -1;
    c = getchar();
  }
  for (; isdigit(c); c = getchar()) out = (out << 3) + (out << 1) + c - '0';
  return out * f;
}
template <typename T>
typename enable_if<is_integral<T>::value, T>::type read(T& x) {
  char c;
  T f = 1;
  x = 0;
  for (c = getchar(); !isdigit(c) && c != '-'; c = getchar()) {
  }
  if (c == '-') {
    f = -1;
    c = getchar();
  }
  for (; isdigit(c); c = getchar()) x = (x << 3) + (x << 1) + c - '0';
  return x *= f;
}
char read(char& x) {
  for (x = getchar(); isspace(x); x = getchar()) {
  }
  return x;
}
double read(double& x) {
  scanf("%lf", &x);
  return x;
}
template <typename T>
typename enable_if<!is_integral<T>::value && !is_pair<T>::value, void>::type
write(const T& x) {
  cout << x;
}
template <typename T>
typename enable_if<is_integral<T>::value, void>::type write(const T& x) {
  if (x < 0) {
    putchar('-');
    write(-x);
    return;
  }
  if (x > 9) write(x / 10);
  putchar(x % 10 + '0');
}
void write(const char& x) { putchar(x); }
void write(const double& x) { printf("%.12lf", x); }
template <typename T>
typename enable_if<is_pair<T>::value, void>::type read(T& x) {
  read(x.first);
  read(x.second);
}
template <typename T>
typename enable_if<is_pair<T>::value, void>::type write(const T& x) {
  write(x.first);
  putchar(' ');
  write(x.second);
}
template <typename T, typename... Args>
void read(T& x, Args&... args) {
  read(x);
  read(args...);
}
template <
    typename OutputIt,
    typename = typename enable_if<
        is_same<output_iterator_tag,
                typename iterator_traits<OutputIt>::iterator_category>::value ||
        (is_base_of<forward_iterator_tag, typename iterator_traits<OutputIt>::
                                              iterator_category>::value &&
         !is_const<OutputIt>::value)>::type>
void read(OutputIt __first, OutputIt __last) {
  for (; __first != __last; ++__first) read(*__first);
}
template <
    typename InputIt,
    typename = typename enable_if<is_base_of<
        input_iterator_tag,
        typename iterator_traits<InputIt>::iterator_category>::value>::type>
void wts(InputIt __first, InputIt __last) {
  bool isFirst = true;
  for (; __first != __last; ++__first) {
    if (isFirst)
      isFirst = false;
    else
      putchar(' ');
    write(*__first);
  }
  putchar('\n');
}
template <
    typename InputIt,
    typename = typename enable_if<is_base_of<
        input_iterator_tag,
        typename iterator_traits<InputIt>::iterator_category>::value>::type>
void wtb(InputIt __first, InputIt __last) {
  for (; __first != __last; ++__first) {
    write(*__first);
    putchar('\n');
  }
}
template <typename T>
void wts(const T& x) {
  write(x);
  putchar(' ');
}
template <typename T>
void wtb(const T& x) {
  write(x);
  putchar('\n');
}
template <typename T>
void wte(const T& x) {
  write(x);
  exit(0);
}
template <typename T, typename... Args>
void wts(const T& x, Args... args) {
  wts(x);
  wts(args...);
}
template <typename T, typename... Args>
void wtb(const T& x, Args... args) {
  wts(x);
  wtb(args...);
}
template <typename T, typename... Args>
void wte(const T& x, Args... args) {
  wts(x);
  wte(args...);
}
template <typename T1, typename T2>
inline bool up(T1& x, const T2& y) {
  return x < y ? x = y, 1 : 0;
}
template <typename T1, typename T2>
inline bool dn(T1& x, const T2& y) {
  return y < x ? x = y, 1 : 0;
}
template <typename T1, typename T2, typename T3>
inline bool inRange(const T1& x, const T2& l, const T3& r) {
  return !(x < l) && !(r < x);
}
template <typename T1, typename T2>
inline auto minOfDifferentTypes(const T1& x, const T2& y)
    -> decltype(x < y ? x : y) {
  return x < y ? x : y;
}
template <typename T1, typename T2>
inline auto maxOfDifferentTypes(const T1& x, const T2& y)
    -> decltype(x < y ? y : x) {
  return x < y ? y : x;
}
template <typename T1, typename T2, typename T3>
inline T1& madd(T1& x, const T2& y, const T3& modulo) {
  return x = (long long)(x + y + modulo) % modulo;
}
template <typename T1, typename T2, typename T3>
inline T1& mmul(T1& x, const T2& y, const T3& modulo) {
  return x = (long long)x * y % modulo;
}
inline long long modadd(long long x, long long y, long long modulo) {
  return (x + y) >= modulo ? x + y - modulo : x + y;
}
inline long long isinf(long long x) { return x < INF ? x : -1; }
inline void yesno(bool x) { wtb(x ? "Yes" : "No"); }
signed main() {
  long long n = read();
  vector<vector<pair<long long, long long>>> g(n + 1);
  for (long long i = (1), iend = (n); i <= iend; ++i) {
    long long u = read() + 1;
    long long v = read() + 1;
    g[u].emplace_back(v, i);
    g[v].emplace_back(u, i);
  }
  long long dfntot = 0;
  vector<long long> dfn(n + 1);
  stack<long long> stk;
  vector<bool> oncycle(n + 1);
  vector<long long> cycle;
  function<void(long long, long long)> findCycle = [&](long long u,
                                                       long long pa) {
    dfn[u] = ++dfntot;
    stk.push(u);
    for (auto x : g[u]) {
      long long v = x.first;
      long long id = x.second;
      if (id == pa) continue;
      if (!dfn[v])
        findCycle(v, id);
      else if (dfn[v] < dfn[u]) {
        while (1) {
          long long t = stk.top();
          stk.pop();
          cycle.push_back(t);
          oncycle[t] = true;
          if (t == v) break;
        }
      }
    }
    if (cycle.empty()) stk.pop();
  };
  findCycle(1, 0);
  vector<long long> dep(n + 1), treeId(n + 1);
  vector<vector<long long>> dis(n + 1, vector<long long>(n + 1)),
      tree(cycle.size());
  function<void(long long, long long, long long)> getTree =
      [&](long long u, long long pa, long long id) {
        tree[id].push_back(u);
        treeId[u] = id;
        for (auto x : g[u]) {
          long long v = x.first;
          if (oncycle[v] || v == pa) continue;
          dep[v] = dep[u] + 1;
          getTree(v, u, id);
        }
      };
  for (long long i = (0), iend = (cycle.size() - 1); i <= iend; ++i)
    getTree(cycle[i], 0, i);
  double ans = 0;
  function<void(long long, long long, long long)> calcTree =
      [&](long long u, long long pa, long long d) {
        ans += 1.0 / d;
        for (auto x : g[u]) {
          long long v = x.first;
          if (v == pa || treeId[v] != treeId[u]) continue;
          calcTree(v, u, d + 1);
        }
      };
  for (long long i = (0), iend = (cycle.size() - 1); i <= iend; ++i) {
    for (auto u : tree[i]) calcTree(u, 0, 1);
    for (long long j = (i + 1), jend = (cycle.size() - 1); j <= jend; ++j) {
      for (auto u : tree[i]) {
        for (auto v : tree[j]) {
          long long x = dep[u] + dep[v];
          long long y = j - i;
          long long z = cycle.size() - y;
          ans += 2.0 / (x + y + 1) + 2.0 / (x + z + 1) - 2.0 / (x + y + z);
        }
      }
    }
  }
  wtb(ans);
  return 0;
}
