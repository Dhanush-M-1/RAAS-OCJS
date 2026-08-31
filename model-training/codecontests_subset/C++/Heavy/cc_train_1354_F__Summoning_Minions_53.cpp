#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
template <class T>
using pq = priority_queue<T>;
template <class T>
using pqg = priority_queue<T, vector<T>, greater<T>>;
int scan() { return getchar(); }
void scan(int& a) { cin >> a; }
void scan(long long& a) { cin >> a; }
void scan(char& a) { cin >> a; }
void scan(double& a) { cin >> a; }
void scan(long double& a) { cin >> a; }
void scan(char a[]) { scanf("%s", a); }
void scan(string& a) { cin >> a; }
template <class T>
void scan(vector<T>&);
template <class T, size_t size>
void scan(array<T, size>&);
template <class T, class L>
void scan(pair<T, L>&);
template <class T, size_t size>
void scan(T (&)[size]);
template <class T>
void scan(vector<T>& a) {
  for (auto& i : a) scan(i);
}
template <class T>
void scan(deque<T>& a) {
  for (auto& i : a) scan(i);
}
template <class T, size_t size>
void scan(array<T, size>& a) {
  for (auto& i : a) scan(i);
}
template <class T, class L>
void scan(pair<T, L>& p) {
  scan(p.first);
  scan(p.second);
}
template <class T, size_t size>
void scan(T (&a)[size]) {
  for (auto& i : a) scan(i);
}
template <class T>
void scan(T& a) {
  cin >> a;
}
void IN() {}
template <class Head, class... Tail>
void IN(Head& head, Tail&... tail) {
  scan(head);
  IN(tail...);
}
string stin() {
  string s;
  cin >> s;
  return s;
}
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
vector<int> iota(int n) {
  vector<int> a(n);
  iota(begin(a), end(a), 0);
  return a;
}
template <class T>
void UNIQUE(vector<T>& x) {
  sort(begin(x), end(x));
  x.erase(unique(begin(x), end(x)), x.end());
}
int in() {
  int x;
  cin >> x;
  return x;
}
long long lin() {
  unsigned long long x;
  cin >> x;
  return x;
}
void print() { putchar(' '); }
void print(bool a) { cout << a; }
void print(int a) { cout << a; }
void print(long long a) { cout << a; }
void print(char a) { cout << a; }
void print(string& a) { cout << a; }
void print(double a) { cout << a; }
template <class T>
void print(const vector<T>&);
template <class T, size_t size>
void print(const array<T, size>&);
template <class T, class L>
void print(const pair<T, L>& p);
template <class T, size_t size>
void print(const T (&)[size]);
template <class T>
void print(const vector<T>& a) {
  if (a.empty()) return;
  print(a[0]);
  for (auto i = a.begin(); ++i != a.end();) {
    cout << " ";
    print(*i);
  }
  cout << endl;
}
template <class T>
void print(const deque<T>& a) {
  if (a.empty()) return;
  print(a[0]);
  for (auto i = a.begin(); ++i != a.end();) {
    cout << " ";
    print(*i);
  }
}
template <class T, size_t size>
void print(const array<T, size>& a) {
  print(a[0]);
  for (auto i = a.begin(); ++i != a.end();) {
    cout << " ";
    print(*i);
  }
}
template <class T, class L>
void print(const pair<T, L>& p) {
  cout << '(';
  print(p.first);
  cout << ",";
  print(p.second);
  cout << ')';
}
template <class T, size_t size>
void print(const T (&a)[size]) {
  print(a[0]);
  for (auto i = a; ++i != end(a);) {
    cout << " ";
    print(*i);
  }
}
template <class T>
void print(const T& a) {
  cout << a;
}
int out() {
  putchar('\n');
  return 0;
}
template <class T>
int out(const T& t) {
  print(t);
  putchar('\n');
  return 0;
}
template <class Head, class... Tail>
int out(const Head& head, const Tail&... tail) {
  print(head);
  putchar(' ');
  out(tail...);
  return 0;
}
long long gcd(long long a, long long b) {
  while (b) {
    long long c = b;
    b = a % b;
    a = c;
  }
  return a;
}
long long lcm(long long a, long long b) {
  if (!a || !b) return 0;
  return a * b / gcd(a, b);
}
vector<pair<long long, long long>> factor(long long x) {
  vector<pair<long long, long long>> ans;
  for (long long i = 2; i * i <= x; i++)
    if (x % i == 0) {
      ans.push_back({i, 1});
      while ((x /= i) % i == 0) ans.back().second++;
    }
  if (x != 1) ans.push_back({x, 1});
  return ans;
}
vector<int> divisor(int x) {
  vector<int> ans;
  for (int i = 1; i * i <= x; i++)
    if (x % i == 0) {
      ans.push_back(i);
      if (i * i != x) ans.push_back(x / i);
    }
  return ans;
}
int popcount(long long x) { return __builtin_popcountll(x); }
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int rnd(int n) { return uniform_int_distribution<int>(0, n)(rng); }
template <class... T>
void err(const T&...) {}
template <typename Monoid>
struct SegmentTree {
  using F = function<Monoid(Monoid, Monoid)>;
  int sz;
  vector<Monoid> seg;
  const F f;
  const Monoid M1;
  SegmentTree(int n, const F f, const Monoid& M1) : f(f), M1(M1) {
    sz = 1;
    while (sz < n) sz <<= 1;
    seg.assign(2 * sz, M1);
  }
  void set(int k, const Monoid& x) { seg[k + sz] = x; }
  void build() {
    for (int k = sz - 1; k > 0; k--) {
      seg[k] = f(seg[2 * k + 0], seg[2 * k + 1]);
    }
  }
  void update(int k, const Monoid& x) {
    k += sz;
    seg[k] += x;
    while (k >>= 1) {
      seg[k] = f(seg[2 * k + 0], seg[2 * k + 1]);
    }
  }
  Monoid query(int a, int b) {
    Monoid L = M1, R = M1;
    for (a += sz, b += sz; a < b; a >>= 1, b >>= 1) {
      if (a & 1) L = f(L, seg[a++]);
      if (b & 1) R = f(seg[--b], R);
    }
    return f(L, R);
  }
  Monoid operator[](const int& k) const { return seg[k + sz]; }
  template <typename C>
  int find_subtree(int a, const C& check, Monoid& M, bool type) {
    while (a < sz) {
      Monoid nxt = type ? f(seg[2 * a + type], M) : f(M, seg[2 * a + type]);
      if (check(nxt))
        a = 2 * a + type;
      else
        M = nxt, a = 2 * a + 1 - type;
    }
    return a - sz;
  }
  template <typename C>
  int find_first(int a, const C& check) {
    Monoid L = M1;
    if (a <= 0) {
      if (check(f(L, seg[1]))) return find_subtree(1, check, L, false);
      return -1;
    }
    int b = sz;
    for (a += sz, b += sz; a < b; a >>= 1, b >>= 1) {
      if (a & 1) {
        Monoid nxt = f(L, seg[a]);
        if (check(nxt)) return find_subtree(a, check, L, false);
        L = nxt;
        ++a;
      }
    }
    return -1;
  }
  template <typename C>
  int find_last(int b, const C& check) {
    Monoid R = M1;
    if (b >= sz) {
      if (check(f(seg[1], R))) return find_subtree(1, check, R, true);
      return -1;
    }
    int a = sz;
    for (b += sz; a < b; a >>= 1, b >>= 1) {
      if (b & 1) {
        Monoid nxt = f(seg[--b], R);
        if (check(nxt)) return find_subtree(b, check, R, true);
        R = nxt;
      }
    }
    return -1;
  }
  void print(int n) {
    for (int i = 0; i < n; i++) {
      cerr << seg[i + sz] << " ";
    }
    cerr << '\n';
  }
};
signed main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cout << fixed << setprecision(15);
  int T = in();
  while (T--) {
    int n = in(), k = in();
    auto id = iota(n);
    vector<long long> a, b;
    for (long long i = 0; i < n; ++i) {
      a.push_back(in()), b.push_back(in());
    }
    sort(begin(id), end(id), [&](int x, int y) { return b[x] < b[y]; });
    long long dp[100][100] = {};
    for (long long i = 0; i < n + 1; ++i)
      for (long long j = 0; j < n + 1; ++j) dp[i][j] = -1e15;
    dp[0][0] = 0;
    int pre[100][100] = {};
    int mem[100][100];
    for (long long i = 0; i < n; ++i) {
      int now = id[i];
      for (long long j = 0; j < k + 1; ++j) {
        if (chmax(dp[i + 1][j], dp[i][j] + b[now] * (k - 1))) pre[i + 1][j] = j;
        if (chmax(dp[i + 1][j + 1], dp[i][j] + a[now] + b[now] * j))
          pre[i + 1][j + 1] = j;
      }
    }
    vector<int> ope;
    int now = k;
    for (long long i = n; i >= 1; --i) {
      if (pre[i][now] != now) {
        ope.emplace_back(id[i - 1]);
        now--;
      }
    }
    reverse(begin(ope), end(ope));
    cout << n + (n - k) << '\n';
    for (long long i = 0; i < k - 1; ++i) cout << ope[i] + 1 << " ";
    vector<bool> used(n);
    for (long long i = 0; i < k; ++i) used[ope[i]] = 1;
    for (long long i = 0; i < n; ++i)
      if (!used[i]) {
        cout << i + 1 << " " << -(i + 1) << " ";
      }
    cout << ope[k - 1] + 1 << '\n';
  }
}
