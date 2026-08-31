#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int MX = 2e5 + 5;
const long long INF = 1e18;
const long double PI = acos((long double)-1);
const int xd[4] = {1, 0, -1, 0}, yd[4] = {0, 1, 0, -1};
template <class T>
bool ckmin(T& a, const T& b) {
  return b < a ? a = b, 1 : 0;
}
template <class T>
bool ckmax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
int pct(int x) { return __builtin_popcount(x); }
namespace input {
template <class T>
void re(complex<T>& x);
template <class T1, class T2>
void re(pair<T1, T2>& p);
template <class T>
void re(vector<T>& a);
template <class T, size_t SZ>
void re(array<T, SZ>& a);
template <class T>
void re(T& x) {
  cin >> x;
}
void re(double& x) {
  string t;
  re(t);
  x = stod(t);
}
void re(long double& x) {
  string t;
  re(t);
  x = stold(t);
}
template <class T, class... Ts>
void re(T& t, Ts&... ts) {
  re(t);
  re(ts...);
}
template <class T>
void re(complex<T>& x) {
  T a, b;
  re(a, b);
  x = {a, b};
}
template <class T1, class T2>
void re(pair<T1, T2>& p) {
  re(p.first, p.second);
}
template <class T>
void re(vector<T>& a) {
  for (int i = (0); i < ((int)a.size()); ++i) re(a[i]);
}
template <class T, size_t SZ>
void re(array<T, SZ>& a) {
  for (int i = (0); i < (SZ); ++i) re(a[i]);
}
}  // namespace input
using namespace input;
namespace output {
void pr(int x) { cout << x; }
void pr(long x) { cout << x; }
void pr(long long x) { cout << x; }
void pr(unsigned x) { cout << x; }
void pr(unsigned long x) { cout << x; }
void pr(unsigned long long x) { cout << x; }
void pr(float x) { cout << x; }
void pr(double x) { cout << x; }
void pr(long double x) { cout << x; }
void pr(char x) { cout << x; }
void pr(const char* x) { cout << x; }
void pr(const string& x) { cout << x; }
void pr(bool x) { pr(x ? "true" : "false"); }
template <class T>
void pr(const complex<T>& x) {
  cout << x;
}
template <class T1, class T2>
void pr(const pair<T1, T2>& x);
template <class T>
void pr(const T& x);
template <class T, class... Ts>
void pr(const T& t, const Ts&... ts) {
  pr(t);
  pr(ts...);
}
template <class T1, class T2>
void pr(const pair<T1, T2>& x) {
  pr("{", x.first, ", ", x.second, "}");
}
template <class T>
void pr(const T& x) {
  pr("{");
  bool fst = 1;
  for (const auto& a : x) pr(!fst ? ", " : "", a), fst = 0;
  pr("}");
}
void ps() { pr("\n"); }
template <class T, class... Ts>
void ps(const T& t, const Ts&... ts) {
  pr(t);
  if (sizeof...(ts)) pr(" ");
  ps(ts...);
}
void pc() { pr("]\n"); }
template <class T, class... Ts>
void pc(const T& t, const Ts&... ts) {
  pr(t);
  if (sizeof...(ts)) pr(", ");
  pc(ts...);
}
}  // namespace output
using namespace output;
namespace io {
void setIn(string second) { freopen(second.c_str(), "r", stdin); }
void setOut(string second) { freopen(second.c_str(), "w", stdout); }
void setIO(string second = "") {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  if ((int)second.size()) {
    setIn(second + ".in"), setOut(second + ".out");
  }
}
}  // namespace io
using namespace io;
mt19937 rng((uint32_t)chrono::steady_clock::now().time_since_epoch().count());
int n, m, k;
vector<vector<int>> bel[3], abv[3];
vector<vector<vector<bool>>> ok;
vector<vector<deque<int>>> ord[3];
void bad() {
  ps(-1);
  exit(0);
}
void check(vector<vector<int>> a, vector<vector<int>> b) {
  for (int i = (0); i < ((int)a.size()); ++i)
    for (int j = (0); j < ((int)a[0].size()); ++j) {
      if ((a[i][j] == 0) != (b[i][j] == 0)) bad();
    }
}
set<int> col;
bool OK(int ind, int x, int y, int p) {
  if (ind == 0) return ok[p][x][y];
  if (ind == 1) return ok[x][p][y];
  return ok[x][y][p];
}
void deal(int ind, int x, int y, int p) {
  while ((int)ord[ind][x][y].size() && !OK(ind, x, y, ord[ind][x][y].back()))
    ord[ind][x][y].pop_back();
  while ((int)ord[ind][x][y].size() && !OK(ind, x, y, ord[ind][x][y].front()))
    ord[ind][x][y].pop_front();
  if ((int)ord[ind][x][y].size()) {
    if (ord[ind][x][y].front() == p) col.insert(bel[ind][x][y]);
    if (ord[ind][x][y].back() == p) col.insert(abv[ind][x][y]);
  }
}
array<int, 3> DEAL(int ind, int x, int y, int p) {
  if (p == ord[ind][x][y].front()) {
    deal(ind, x, y, p);
    if (!(int)ord[ind][x][y].size()) bad();
    return {x, y, ord[ind][x][y].front()};
  }
  if (p == ord[ind][x][y].back()) {
    deal(ind, x, y, p);
    if (!(int)ord[ind][x][y].size()) bad();
    return {x, y, ord[ind][x][y].back()};
  }
  return {-1, -1, -1};
}
int main() {
  setIO();
  re(n, m, k);
  bel[0] = vector<vector<int>>(m, vector<int>(k));
  for (int b = (0); b < (m); ++b)
    for (int c = (0); c < (k); ++c) re(bel[0][b][c]);
  abv[0] = vector<vector<int>>(m, vector<int>(k));
  for (int b = (0); b < (m); ++b)
    for (int c = (0); c < (k); ++c) re(abv[0][b][c]);
  bel[1] = vector<vector<int>>(n, vector<int>(k));
  for (int b = (0); b < (n); ++b)
    for (int c = (0); c < (k); ++c) re(bel[1][b][c]);
  abv[1] = vector<vector<int>>(n, vector<int>(k));
  for (int b = (0); b < (n); ++b)
    for (int c = (0); c < (k); ++c) re(abv[1][b][c]);
  bel[2] = vector<vector<int>>(n, vector<int>(m));
  for (int b = (0); b < (n); ++b)
    for (int c = (0); c < (m); ++c) re(bel[2][b][c]);
  abv[2] = vector<vector<int>>(n, vector<int>(m));
  for (int b = (0); b < (n); ++b)
    for (int c = (0); c < (m); ++c) re(abv[2][b][c]);
  for (int i = (0); i < (3); ++i) check(bel[i], abv[i]);
  queue<array<int, 3>> q;
  ok.assign(n, vector<vector<bool>>(m, vector<bool>(k)));
  ord[0].resize(m);
  for (int i = (0); i < (m); ++i) ord[0][i].resize(k);
  ord[1].resize(n);
  for (int i = (0); i < (n); ++i) ord[1][i].resize(k);
  ord[2].resize(n);
  for (int i = (0); i < (n); ++i) ord[2][i].resize(m);
  for (int a = (0); a < (n); ++a)
    for (int b = (0); b < (m); ++b)
      for (int c = (0); c < (k); ++c) {
        if (!bel[0][b][c] || !abv[0][b][c]) continue;
        if (!bel[1][a][c] || !abv[1][a][c]) continue;
        if (!bel[2][a][b] || !abv[2][a][b]) continue;
        ok[a][b][c] = 1;
        q.push({a, b, c});
        ord[0][b][c].push_back(a);
        ord[1][a][c].push_back(b);
        ord[2][a][b].push_back(c);
      }
  array<int, 3> ID = {-1, -1, -1};
  while ((int)q.size()) {
    auto a = q.front();
    q.pop();
    if (!ok[a[0]][a[1]][a[2]]) continue;
    col.clear();
    deal(0, a[1], a[2], a[0]);
    deal(1, a[0], a[2], a[1]);
    deal(2, a[0], a[1], a[2]);
    if ((int)col.size() > 1) {
      ok[a[0]][a[1]][a[2]] = 0;
      auto A = DEAL(0, a[1], a[2], a[0]);
      if (A != ID) q.push({A[2], A[0], A[1]});
      auto B = DEAL(1, a[0], a[2], a[1]);
      if (B != ID) q.push({B[0], B[2], B[1]});
      auto C = DEAL(2, a[0], a[1], a[2]);
      if (C != ID) q.push({C[0], C[1], C[2]});
    }
  }
  for (int x = (0); x < (n); ++x)
    for (int y = (0); y < (m); ++y)
      for (int z = (0); z < (k); ++z) {
        if (!ok[x][y][z])
          pr(0);
        else {
          col.clear();
          array<int, 3> a = {x, y, z};
          col.clear();
          deal(0, a[1], a[2], a[0]);
          deal(1, a[0], a[2], a[1]);
          deal(2, a[0], a[1], a[2]);
          assert((int)col.size() <= 1);
          if ((int)col.size())
            pr(*begin(col));
          else
            pr(0);
        }
        pr(' ');
      }
}
