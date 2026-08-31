#include <bits/stdc++.h>
using namespace std;
char string_in_buffer[(int)260];
void fast_scan(int &first) { scanf("%d", &first); }
void fast_scan(long long &first) { scanf("%lld", &first); }
void fast_scan(unsigned long long &first) { scanf("%llu", &first); }
void fast_scan(double &first) { scanf("%lf", &first); }
void fast_scan(long double &first) { scanf("%Lf", &first); }
void fast_scan(char &first) {
  scanf("%c", &first);
  if (first == '\n') {
    fast_scan(first);
  }
}
void fast_scan(string &first) {
  scanf("%s", string_in_buffer);
  first = string(string_in_buffer);
}
template <class TFirst, class TSecond>
void fast_scan(pair<TFirst, TSecond> &p) {
  fast_scan(p.first);
  fast_scan(p.second);
}
template <class T>
void fast_scan(vector<T> &v) {
  for (auto &first : v) fast_scan(first);
}
void fast_print(const int &first) { printf("%d", first); }
void fast_print(const unsigned int &first) { printf("%u", first); }
void fast_print(const long long &first) { printf("%lld", first); }
void fast_print(const unsigned long long &first) { printf("%llu", first); }
void fast_print(const double &first) { printf("%.15lf", first); }
void fast_print(const long double &first) { printf("%.15Lf", first); }
void fast_print(const char &first) { printf("%c", first); };
void fast_print(const string &first) { printf("%s", first.c_str()); }
void fast_print(const char v[]) { fast_print((string)v); }
template <class TFirst, class TSecond>
void fast_print(const pair<TFirst, TSecond> &p) {
  fast_print(p.first);
  fast_print(' ');
  fast_print(p.second);
}
template <class T>
void fast_print(const vector<T> &v) {
  if (v.empty()) return;
  fast_print(v[0]);
  for (int i = 1; i < v.size(); i++) {
    fast_print(' ');
    fast_print(v[i]);
  }
}
template <class T>
void fast_print(const vector<vector<T>> &v) {
  if (v.empty()) return;
  fast_print(v[0]);
  for (int i = 1; i < v.size(); i++) {
    fast_print('\n');
    fast_print(v[i]);
  }
}
template <class T>
void fast_print(const T &v) {
  for (const auto &first : v) {
    fast_print(first);
    fast_print(' ');
  }
}
using namespace std;
namespace smart_io {
string print_start = "";
string sep = " ";
bool first_print = false;
void precall_print() {
  fast_print(print_start);
  print_start = "\n";
  first_print = true;
}
void _print(deque<string>) {}
template <class T, class... Args>
void _print(deque<string> names, T elem, Args... args) {
  if (!first_print) {
    fast_print("\n");
  } else {
    first_print = false;
  }
  fast_print(names.front());
  fast_print(" = ");
  fast_print(elem);
  names.pop_front();
  _print(names, args...);
}
}  // namespace smart_io
template <class T>
ostream &operator,(ostream &os, const T &object) {
  if (!smart_io::first_print) {
    fast_print(smart_io::sep);
  } else {
    smart_io::first_print = false;
  }
  fast_print(object);
  return os;
}
template <class T>
istream &operator,(istream &is, T &object) {
  fast_scan(object);
  return is;
}
namespace escape__from__random__aetuhoetnuhshe {
using namespace std::chrono;
mt19937 rng(duration_cast<milliseconds>(system_clock::now().time_since_epoch())
                .count());
};  // namespace escape__from__random__aetuhoetnuhshe
namespace typedefs {}
namespace numbers_operation {
template <class T>
T floor_mod(T a, T b) {
  if (a % b == 0) return 0;
  if (a >= 0 && b >= 0) return a % b;
  if (a <= 0 && b <= 0) return a % b;
  return abs(b) - (abs(a) % abs(b));
}
}  // namespace numbers_operation
using namespace numbers_operation;
using namespace typedefs;
using namespace escape__from__random__aetuhoetnuhshe;
string base;
int get(int i) {
  if (i >= ((int)base.size())) return 0;
  return base[i] - '0';
}
const int N = 50;
vector<vector<int>> comp(N);
string strip(string s) {
  while (((int)s.size()) > 1 && s[0] == '0') {
    s.erase(s.begin());
  }
  return s;
}
void solve() {
  cin, base;
  reverse(base.begin(), base.end());
  base += '0';
  vector<vector<int>> dp(((int)base.size()), vector<int>(N));
  vector<vector<pair<int, int>>> pref(((int)base.size()),
                                      vector<pair<int, int>>(N));
  for (int s = 0; s < ((int)comp.size()); s++) {
    if (comp[s].empty()) continue;
    if (s % 10 == get(0)) {
      dp[0][s / 10] = 1;
      pref[0][s / 10] = make_pair(s, 0);
    }
  }
  for (int i = 1; i < ((int)base.size()); i++) {
    for (int s = 0; s < N; s++) {
      if (comp[s].empty()) continue;
      for (int j = 0; j < N; j++) {
        if ((s + j) % 10 == get(i)) {
          if (dp[i - 1][j]) {
            dp[i][(s + j) / 10] = 1;
            pref[i][(s + j) / 10] = make_pair(s, j);
          }
        }
      }
    }
  }
  if (!dp[((int)base.size()) - 1][0]) {
    smart_io::precall_print();
    cout, -1;
    return;
  }
  assert(dp[((int)base.size()) - 1][0]);
  vector<string> result(6);
  int cur = ((int)base.size()) - 1;
  int j = 0;
  while (cur >= 0) {
    for (int k = 0; k < 6; k++) {
      int id = pref[cur][j].first;
      result[k] += to_string(comp[pref[cur][j].first][k]);
    }
    j = pref[cur][j].second;
    cur--;
  }
  for (int k = 0; k < (6); k++) {
    result[k] = strip(result[k]);
  }
  smart_io::precall_print();
  cout, result;
}
signed main(signed argc, char *argv[]) {
  for (int a : {0, 4, 7})
    for (int b : {0, 4, 7})
      for (int c : {0, 4, 7})
        for (int d : {0, 4, 7})
          for (int e : {0, 4, 7})
            for (int z : {0, 4, 7})
              comp[a + b + c + d + e + z] = {a, b, c, d, e, z};
  int cnt_tests;
  cin, cnt_tests;
  for (int test = 0; test < (cnt_tests); test++) {
    solve();
  }
}
