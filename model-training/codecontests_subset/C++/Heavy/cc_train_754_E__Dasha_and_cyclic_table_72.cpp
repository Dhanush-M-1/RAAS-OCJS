#include <bits/stdc++.h>
using namespace std;
template <class A>
void rd(vector<A>& v);
template <class T>
void rd(T& x) {
  cin >> x;
}
template <class H, class... T>
void rd(H& h, T&... t) {
  rd(h);
  rd(t...);
}
template <class A>
void rd(vector<A>& x) {
  for (auto& a : x) rd(a);
}
template <class T>
bool ckmin(T& a, const T& b) {
  return b < a ? a = b, 1 : 0;
}
template <class T>
bool ckmax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
template <typename T>
void __p(T a) {
  cout << a;
}
template <typename T, typename F>
void __p(pair<T, F> a) {
  cout << "{";
  __p(a.first);
  cout << ",";
  __p(a.second);
  cout << "}\n";
}
template <typename T>
void __p(std::vector<T> a) {
  cout << "{";
  for (auto it = a.begin(); it < a.end(); it++)
    __p(*it), cout << ",}\n"[it + 1 == a.end()];
}
template <typename T, typename... Arg>
void __p(T a1, Arg... a) {
  __p(a1);
  __p(a...);
}
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cout << name << " : ";
  __p(arg1);
  cout << "\n";
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  int64_t bracket = 0, i = 0;
  for (;; i++)
    if (names[i] == ',' && bracket == 0)
      break;
    else if (names[i] == '(')
      bracket++;
    else if (names[i] == ')')
      bracket--;
  const char* comma = names + i;
  cout.write(names, comma - names) << " : ";
  __p(arg1);
  cout << " | ";
  __f(comma + 1, args...);
}
void setIO(string s = "") {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin.exceptions(cin.failbit);
  cout.precision(15);
  cout << fixed;
  if (((int64_t)(s).size())) {
    freopen((s + ".in").c_str(), "r", stdin);
    freopen((s + ".out").c_str(), "w", stdout);
  }
}
const int64_t MX = 400, A = 26;
using bs = bitset<MX>;
bs shift(const bs B, int64_t x, int64_t len) {
  return (B >> x) | (B << (len - x));
}
bs G[MX][A];
bs ans[MX];
signed main() {
  setIO();
  int64_t n, m;
  rd(n, m);
  vector<string> T(n);
  rd(T);
  for (int64_t i = int64_t(0); i < int64_t(n); ++i) {
    for (int64_t j = int64_t(0); j < int64_t(m); ++j) {
      G[i][T[i][j] - 'a'][j] = 1;
      ans[i][j] = 1;
    }
  }
  int64_t r, c;
  rd(r, c);
  vector<string> P(r);
  rd(P);
  for (int64_t x = int64_t(0); x < int64_t(r); ++x) {
    for (int64_t y = int64_t(0); y < int64_t(c); ++y) {
      if (P[x][y] == '?') continue;
      for (int64_t i = int64_t(0); i < int64_t(n); ++i) {
        int64_t c = P[x][y] - 'a';
        ans[i] &= shift(G[(i + x) % n][c], (y % m), m);
      }
    }
  }
  for (int64_t i = int64_t(0); i < int64_t(n); ++i) {
    for (int64_t j = int64_t(0); j < int64_t(m); ++j) {
      cout << ans[i][j];
    }
    cout << "\n";
  }
}
