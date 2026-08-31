#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <class t, class u>
void chmax(t& first, u second) {
  if (first < second) first = second;
}
template <class t, class u>
void chmin(t& first, u second) {
  if (second < first) first = second;
}
template <class t>
using vc = vector<t>;
template <class t>
using vvc = vc<vc<t>>;
using pi = pair<int, int>;
using vi = vc<int>;
template <class t, class u>
ostream& operator<<(ostream& os, const pair<t, u>& p) {
  return os << "{" << p.first << "," << p.second << "}";
}
template <class t>
ostream& operator<<(ostream& os, const vc<t>& v) {
  os << "{";
  for (auto e : v) os << e << ",";
  return os << "}";
}
using uint = unsigned;
using ull = unsigned long long;
template <class t, size_t n>
ostream& operator<<(ostream& os, const array<t, n>& first) {
  return os << vc<t>(first.begin(), first.end());
}
template <int i, class T>
void print_tuple(ostream&, const T&) {}
template <int i, class T, class H, class... Args>
void print_tuple(ostream& os, const T& t) {
  if (i) os << ",";
  os << get<i>(t);
  print_tuple<i + 1, T, Args...>(os, t);
}
template <class... Args>
ostream& operator<<(ostream& os, const tuple<Args...>& t) {
  os << "{";
  print_tuple<0, tuple<Args...>, Args...>(os, t);
  return os << "}";
}
template <class t>
void print(t x, int suc = 1) {
  cout << x;
  if (suc == 1) cout << "\n";
  if (suc == 2) cout << " ";
}
ll read() {
  ll i;
  cin >> i;
  return i;
}
vi readvi(int n, int off = 0) {
  vi v(n);
  for (int i = int(0); i < int(n); i++) v[i] = read() + off;
  return v;
}
template <class T>
void print(const vector<T>& v, int suc = 1) {
  for (int i = int(0); i < int(v.size()); i++)
    print(v[i], i == int(v.size()) - 1 ? suc : 2);
}
string readString() {
  string s;
  cin >> s;
  return s;
}
template <class T>
T sq(const T& t) {
  return t * t;
}
void yes(bool ex = true) {
  cout << "Yes"
       << "\n";
  if (ex) exit(0);
}
void no(bool ex = true) {
  cout << "No"
       << "\n";
  if (ex) exit(0);
}
void possible(bool ex = true) {
  cout << "Possible"
       << "\n";
  if (ex) exit(0);
}
void impossible(bool ex = true) {
  cout << "Impossible"
       << "\n";
  if (ex) exit(0);
}
constexpr ll ten(int n) { return n == 0 ? 1 : ten(n - 1) * 10; }
const ll infLL = LLONG_MAX / 3;
const int inf = INT_MAX / 2 - 100;
int topbit(signed t) { return t == 0 ? -1 : 31 - __builtin_clz(t); }
int topbit(ll t) { return t == 0 ? -1 : 63 - __builtin_clzll(t); }
int botbit(signed first) { return first == 0 ? 32 : __builtin_ctz(first); }
int botbit(ll first) { return first == 0 ? 64 : __builtin_ctzll(first); }
int popcount(signed t) { return __builtin_popcount(t); }
int popcount(ll t) { return __builtin_popcountll(t); }
bool ispow2(int i) { return i && (i & -i) == i; }
ll mask(int i) { return (ll(1) << i) - 1; }
bool inc(int first, int second, int c) {
  return first <= second && second <= c;
}
template <class t>
void mkuni(vc<t>& v) {
  sort(v.begin(), v.end());
  v.erase(unique(v.begin(), v.end()), v.end());
}
ll rand_int(ll l, ll r) {
  static mt19937_64 gen(chrono::steady_clock::now().time_since_epoch().count());
  return uniform_int_distribution<ll>(l, r)(gen);
}
template <class t>
void myshuffle(vc<t>& first) {
  for (int i = int(0); i < int(int(first.size())); i++)
    swap(first[i], first[rand_int(0, i)]);
}
template <class t>
int lwb(const vc<t>& v, const t& first) {
  return lower_bound(v.begin(), v.end(), first) - v.begin();
}
const int nmax = 100010;
vi g[nmax];
int sum[nmax], vis[nmax], up[nmax];
bool ok;
void dfs(int v) {
  assert(vis[v] == -1);
  vis[v] = 0;
  for (auto to : g[v]) {
    if (vis[to] == -1) {
      dfs(to);
      sum[v] += sum[to];
      up[v] += up[to];
    } else if (vis[to] == 0) {
      sum[v]++;
      sum[to]--;
      up[v] += to;
      up[to] -= to;
    } else {
      ok = false;
    }
    if (!ok) return;
  }
  vis[v] = 1;
}
bool good[nmax];
void dfs2(int v) {
  assert(vis[v] == -1);
  vis[v] = 0;
  if (sum[v] >= 2) good[v] = 0;
  if (sum[v] == 1) good[v] &= good[up[v]];
  for (auto to : g[v]) {
    if (vis[to] == -1) {
      dfs2(to);
    } else if (vis[to] == 0) {
    } else {
      assert(false);
    }
  }
  vis[v] = 1;
}
void slv() {
  int n, m;
  cin >> n >> m;
  for (int i = int(0); i < int(n); i++) {
    g[i].clear();
  }
  for (int i = int(0); i < int(m); i++) {
    int first, second;
    cin >> first >> second;
    first--;
    second--;
    g[first].push_back(second);
  }
  vi idx(n);
  iota(idx.begin(), idx.end(), 0);
  myshuffle(idx);
  for (int _ = int(0); _ < int(min(n, 100)); _++) {
    int r = idx[_];
    for (int i = int(0); i < int(n); i++) {
      sum[i] = 0;
      vis[i] = -1;
      up[i] = 0;
    }
    ok = true;
    dfs(r);
    if (ok) {
      for (int i = int(0); i < int(n); i++) {
        vis[i] = -1;
        good[i] = 1;
      }
      dfs2(r);
      vi ans;
      for (int i = int(0); i < int(n); i++)
        if (good[i]) ans.push_back(i + 1);
      if (int(ans.size()) * 5 < n) {
        print(-1);
      } else {
        print(ans);
      }
      return;
    }
  }
  print(-1);
}
signed main() {
  cin.tie(0);
  ios::sync_with_stdio(0);
  cout << fixed << setprecision(20);
  int t;
  cin >> t;
  for (int _ = int(0); _ < int(t); _++) slv();
}
