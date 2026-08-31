#include <bits/stdc++.h>
using namespace std;
template <typename T, size_t N>
int SIZE(const T (&t)[N]) {
  return N;
}
template <typename T>
int SIZE(const T &t) {
  return t.size();
}
string to_string(string &second, int x1 = 0, int x2 = 1e9) {
  return '"' + ((x1 < second.size()) ? second.substr(x1, x2 - x1 + 1) : "") +
         '"';
}
string to_string(const char *second) {
  string tmp(second);
  return to_string(tmp);
}
string to_string(bool b) { return (b ? "true" : "false"); }
string to_string(char c) { return string({c}); }
template <size_t N>
string to_string(bitset<N> &b, int x1 = 0, int x2 = 1e9) {
  string t = ((x1 < b.size()) ? (b.to_string()).substr(x1, x2 - x1 + 1) : "");
  reverse(begin(t), end(t));
  return '"' + t + '"';
}
template <typename A, typename... C>
string to_string(A(&v), int x1 = 0, int x2 = 1e9, C... coords);
int l_v_l_v_l = 0, t_a_b_s = 0;
template <typename A, typename B>
string to_string(pair<A, B> &p) {
  l_v_l_v_l++;
  string res = "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
  l_v_l_v_l--;
  return res;
}
template <typename A, typename... C>
string to_string(A(&v), int x1, int x2, C... coords) {
  int rnk = rank<A>::value;
  string tab(t_a_b_s, ' ');
  string res = "";
  bool first = true;
  if (l_v_l_v_l == 0) res += '\n';
  res += tab + "[";
  x1 = min(x1, SIZE(v)), x2 = min(x2, SIZE(v));
  auto l = begin(v);
  advance(l, x1);
  auto r = l;
  advance(r, (x2 - x1) + (x2 < SIZE(v)));
  for (auto e = l; e != r; e = next(e)) {
    if (!first) {
      res += ", ";
    }
    first = false;
    l_v_l_v_l++;
    if (e != l) {
      if (rnk > 1) {
        res += '\n';
        t_a_b_s = l_v_l_v_l;
      };
    } else {
      t_a_b_s = 0;
    }
    res += to_string(*e, coords...);
    l_v_l_v_l--;
  }
  res += "]";
  if (l_v_l_v_l == 0) res += '\n';
  return res;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cerr.tie(NULL);
  clock_t startTime = clock();
  long long T = 1;
  while (T--) {
    long long n, m;
    cin >> n >> m;
    vector<long long> a(n);
    for (long long i = 0; i < n; i++) cin >> a[i];
    set<pair<long long, long long> > mm;
    for (long long i = 0; i < m; i++) {
      long long x, y;
      cin >> x >> y;
      mm.insert({x, y});
    }
    long long idx = n - 2;
    long long cnt = 0;
    while (idx >= 0) {
      long long flag = 0;
      if (mm.find({a[idx], a[n - 1]}) == mm.end()) {
        idx--;
        continue;
      }
      for (long long i = idx + 1; i < n - cnt - 1; i++) {
        if (mm.find({a[idx], a[i]}) == mm.end()) {
          flag = 1;
          break;
        }
      }
      if (!flag) {
        swap(a[idx], a[n - cnt - 2]);
        cnt++;
      }
      idx--;
    }
    cout << cnt << "\n";
  }
}
