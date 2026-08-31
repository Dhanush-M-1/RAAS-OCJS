#include <bits/stdc++.h>
using namespace std;
template <typename A>
string to_string(A* ptr) {
  stringstream ss;
  ss << "0x" << std::setw(16) << std::setfill('0') << std::hex
     << (uint64_t)(uintptr_t)ptr;
  return ss.str();
}
string to_string(char c) { return ((string) "'" + c) + "'"; }
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
long long to_key(long long x, long long y) { return (x << 20) + y; }
const int MX = 1e5 + 99;
int n;
int x[MX], y[MX];
bool have(vector<pair<int, int>>& S, int x, int y) {
  pair<int, int> xy = {x, y};
  return binary_search(S.begin(), S.end(), xy);
}
int solve() {
  vector<vector<int>> M_hor(MX), M_ver(MX);
  unordered_set<long long> S;
  for (int i = 0; i < n; i++) {
    M_hor[y[i]].push_back(x[i]);
    M_ver[x[i]].push_back(y[i]);
    S.insert(to_key(x[i], y[i]));
  }
  for (auto& v : M_hor) sort(v.begin(), v.end());
  for (auto& v : M_ver) sort(v.begin(), v.end());
  int result = 0;
  for (int i = 0; i < n; i++) {
    int first = x[i], second = y[i];
    auto& VHOR = M_hor[second];
    auto& VVER = M_ver[first];
    auto it_hor = upper_bound(VHOR.begin(), VHOR.end(), first);
    auto it_ver = upper_bound(VVER.begin(), VVER.end(), second);
    int cnt_hor = (int)(VHOR.end() - it_hor);
    int cnt_ver = (int)(VVER.end() - it_ver);
    if (cnt_hor <= cnt_ver) {
      for (auto it = it_hor; it != VHOR.end(); it++) {
        int dx = *it - first;
        if (S.count(to_key(first, second + dx)) &&
            S.count(to_key(first + dx, second + dx)))
          result++;
      }
    } else {
      for (auto it = it_ver; it != VVER.end(); it++) {
        int dy = *it - second;
        if (S.count(to_key(first + dy, second)) &&
            S.count(to_key(first + dy, second + dy)))
          result++;
      }
    }
  }
  return result;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int TTT = 1;
  for (int ttt = 0; ttt < TTT; ttt++) {
    cin >> n;
    for (int i = 0; i < n; i++) cin >> x[i] >> y[i];
    cout << solve() << '\n';
  }
  return 0;
}
