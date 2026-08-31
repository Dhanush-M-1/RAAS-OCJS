#include <bits/stdc++.h>
using namespace std;
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
  for (int i = 0; i < static_cast<int>(v.size()); i++) {
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
void debug_out() { cerr << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << to_string(H);
  debug_out(T...);
}
int n;
int main() {
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    a[i]--;
  }
  int Fid = -1;
  {
    vector<int> cnt(n);
    for (auto i : a) cnt[i]++;
    int mx = max_element(cnt.begin(), cnt.end()) - cnt.begin();
    if (count(cnt.begin(), cnt.end(), cnt[mx]) >= 2) {
      cout << n;
      return 0;
    }
    Fid = mx;
  }
  vector<set<int>> var(n);
  for (int i = 1; i <= n; i++) {
    var[a[i - 1]].insert(i);
  }
  vector<int> s = {0};
  for (int i : var[Fid]) s.push_back(i);
  s.push_back(n + 1);
  int ret = 0;
  for (auto it = s.begin(); it != prev(s.end()); it++)
    ret = max(ret, *next(it) - *it - 1);
  for (int v = 0; v < n; v++) {
    if (v == Fid) continue;
    var[v].insert(0);
    var[v].insert(n + 1);
    int cur = 0;
    vector<int> beg = {0};
    vector<int> pos = {0};
    int cnt = 1;
    auto get_dp = [&](int p) {
      assert(p < cnt);
      int id = upper_bound(pos.begin(), pos.end(), p) - pos.begin() - 1;
      return s[beg[id] + p - pos[id]];
    };
    for (auto it = var[v].begin(); it != prev(var[v].end()); it++) {
      int L = *it;
      int R = *next(it);
      int sL = upper_bound(s.begin(), s.end(), L) - s.begin();
      int sR = upper_bound(s.begin(), s.end(), R) - s.begin();
      if (sL == sR) {
        cur--;
        continue;
      }
      int to = cur + sR - sL - 1;
      while (cur < cnt && sL < sR) {
        cur++;
        if (cur > 0) {
          ret = max(ret, s[sL] - get_dp(cur - 1) - 1);
        }
        sL++;
      }
      if (cur >= cnt) {
        pos.push_back(cur);
        beg.push_back(sL - 1);
        cnt += sR - sL + 1;
      }
      cur = to;
    }
  }
  cout << ret;
  return 0;
}
