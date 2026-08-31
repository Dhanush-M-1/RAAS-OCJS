#include <bits/stdc++.h>
using namespace std;
template <class T>
inline istream& read(vector<T>& v) {
  for (auto& p : v) cin >> p;
  return cin;
}
template <class T>
inline istream& read(vector<vector<T>>& v) {
  for (auto& p : v) read(p);
  return cin;
}
inline void printf(const int d) { printf("%d", d); }
inline void printf(const long long d) { printf("%lld", d); }
inline void printf(const char c) { printf("%c", c); }
inline void printf(const string& s) { printf("%s", s.c_str()); }
inline void print() { printf("\n"); }
template <class T>
inline void print(const T& t) {
  printf(t);
  printf("\n");
}
template <class... A>
inline void print(const char f[], const A&... a) {
  printf(f, a...);
  printf("\n");
}
template <class T, class... A>
inline void print(const T& t, const A&... a) {
  printf(t);
  printf(" ");
  print(a...);
}
template <class T>
inline void print(const vector<T>& v, bool newline = false) {
  for (size_t i = 0; i < v.size(); i++) {
    printf(i == 0 ? "" : newline ? "\n" : " ");
    printf(v[i]);
  }
  print();
}
int inf = 0x3f3f3f3f;
double eps = 1e-8;
long long mod = 1000000007ll;
long long binf = 0x3f3f3f3f3f3f3f3f;
struct FastIO {
  FastIO() {
    cin.sync_with_stdio(0);
    cin.tie(0);
  }
};
FastIO fio;
template <class T>
map<T, int> tally(const vector<T>& arr) {
  map<T, int> result;
  for (auto& v : arr) result[v]++;
  return result;
}
template <class T>
vector<T> factor(T n) {
  vector<T> result;
  if (n < 0) {
    result.push_back(-1);
    n = -n;
  }
  while (n % 2 == 0) {
    result.push_back(2);
    n /= 2;
  }
  while (n % 3 == 0) {
    result.push_back(3);
    n /= 3;
  }
  for (T p = 5; p * p <= n; p += 6) {
    while (n % p == 0) {
      result.push_back(p);
      n /= p;
    }
    while (n % (p + 2) == 0) {
      result.push_back(p + 2);
      n /= p + 2;
    }
  }
  if (n > 1) result.push_back(n);
  return result;
}
template <class T>
vector<int> kmp_pre(const T& p) {
  int n = p.size(), start = 0;
  vector<int> match(n);
  for (int i = 1; i < n; i++) {
    while (start > 0 && p[i] != p[start]) start = match[start - 1];
    if (p[i] == p[start]) start++;
    match[i] = start;
  }
  return match;
}
template <class T>
vector<int> kmp_match(const T& s, const T& p, const vector<int>& match,
                      bool fs = false) {
  int n = p.size(), m = s.size(), start = 0;
  vector<int> result;
  for (int i = 0; i < m; i++) {
    while (start > 0 && s[i] != p[start]) start = match[start - 1];
    if (s[i] == p[start]) start++;
    if (start == n) {
      result.push_back(i - n + 1);
      if (fs) return result;
      start = match[start - 1];
    }
  }
  return result;
}
template <class T>
vector<int> kmp(const T& s, const T& p, bool fs = false) {
  return kmp_match(s, p, kmp_pre(p), fs);
}
int main() {
  int n, ans = 0;
  cin >> n;
  vector<int> home(n), guest(n);
  for (int i = (0); i < int(n); i++) cin >> home[i] >> guest[i];
  for (int i = 0; i < (n); i++)
    for (int j = 0; j < (n); j++) {
      if (i == j) continue;
      if (home[i] == guest[j]) ans++;
    }
  print(ans);
}
