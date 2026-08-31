#include <bits/stdc++.h>
using namespace std;
template <typename T, size_t N>
int SIZE(const T (&t)[N]) {
  return N;
}
template <typename T>
int SIZE(const T(&t)) {
  return t.size();
}
string to_string(char b) { return "'" + string({b}) + "'"; }
string to_string(bool b) { return (b ? "true" : "false"); }
string to_string(const string &t, int x1 = 0, int x2 = 1e9) {
  string ret = "";
  for (int i = min(x1, SIZE(t)), _i = min(x2, SIZE(t) - 1); i <= _i; ++i) {
    ret += t[i];
  }
  return '"' + ret + '"';
}
string to_string(const char *t) {
  string ret(t);
  return to_string(ret);
}
template <size_t N>
string to_string(const bitset<N> &t, int x1 = 0, int x2 = 1e9) {
  string ret = "";
  for (int i = min(x1, SIZE(t)), _i = min(x2, SIZE(t) - 1); i <= _i; ++i) {
    ret += t[i] + '0';
  }
  return '"' + ret + '"';
}
template <typename T, typename... Coords>
string to_string(const T(&t), int x1 = 0, int x2 = 1e9, Coords... C);
template <typename T, typename S>
string to_string(const pair<T, S>(&t)) {
  return "(" + to_string(t.first) + ", " + to_string(t.second) + ")";
}
template <typename T, typename... Coords>
string to_string(const T(&t), int x1, int x2, Coords... C) {
  string ret = "[";
  x1 = min(x1, SIZE(t));
  auto e = begin(t);
  advance(e, x1);
  for (int i = x1, _i = min(x2, SIZE(t) - 1); i <= _i; ++i) {
    ret += (i != x1 ? ", " : "") + to_string(*e, C...);
    e = next(e);
  }
  return ret + "]";
}
void dbgm() { ; }
template <typename T, typename... S>
void dbgm(T t, S... s) {
  cout << to_string(t) << " | ";
  dbgm(s...);
}
void dbgs() { ; }
template <typename T, typename... S>
void dbgs(T t, S... s) {
  cout << t << " ";
  dbgs(s...);
}
const long long N = 3e5 + 3, M = 1e9 + 7;
int let[N], a[N], pos[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 1, _i = n; i <= _i; ++i) {
    cin >> a[i];
    pos[a[i]] = i;
  }
  int start = a[n];
  set<pair<int, int>> g;
  int pt = 0;
  for (int i = 1, _i = m; i <= _i; ++i) {
    int u, v;
    cin >> u >> v;
    g.insert({u, v});
    if (v == start) {
      let[++pt] = u;
    }
  }
  m = pt;
  sort(let + 1, let + 1 + m,
       [&](const int &l, const int &r) { return pos[l] > pos[r]; });
  for (int i = 1, _i = m; i <= _i; ++i) {
    for (int j = pos[let[i]], _i = pos[start] - 1; j <= _i; ++j) {
      if (g.count(pair<int, int>{a[j], a[j + 1]})) {
        pos[a[j]]++;
        pos[a[j + 1]]--;
        swap(a[j], a[j + 1]);
      } else {
        break;
      }
    }
  }
  dbgs(n - pos[start]);
}
