#include <bits/stdc++.h>
#pragma GCC optimization("O3")
using namespace std;
template <typename T>
inline void Cin(T& first) {
  char c;
  T sign = 1;
  first = 0;
  for (c = getchar(); c < '0' || c > '9'; c = getchar())
    if (c == '-') sign = -1;
  for (; c >= '0' && c <= '9'; c = getchar()) first = first * 10 + c - '0';
  first *= sign;
}
template <typename T>
inline void Out(T first) {
  if (first > 9) Out(first / 10);
  putchar(first % 10 + '0');
}
template <typename T>
inline void Cout(T first, char c) {
  if (first < 0) putchar('-');
  first = abs(first);
  Out(first);
  putchar(c);
}
template <typename T, typename... Args>
inline void Cin(T& a, Args&... args) {
  Cin(a);
  Cin(args...);
}
template <typename T, typename... Args>
inline void Cout(T a, char c, Args... args) {
  Cout(a, c);
  Cout(args...);
}
const int N = int(1e6) + 7;
const int logN = 20;
int n, sum, r, c, a[N], p[N][logN];
string s, _s[N];
void Enter() {
  cin >> n >> r >> c;
  cin.ignore();
  getline(cin, s);
  int ptr = 1;
  for (char c : s) {
    if (c == ' ')
      a[ptr] = int(_s[ptr].size()), ++ptr;
    else
      _s[ptr] += c;
  }
  a[ptr] = _s[ptr].size();
  ptr = 1;
  for (int i = 1; i <= n; ++i) {
    sum -= (a[i - 1] + 1);
    if (ptr <= i || i == 1) sum = a[i], ptr = i;
    while (sum <= c && ptr <= n) sum += 1 + a[++ptr];
    p[i][0] = ptr;
  }
  for (int j = 1; j < logN; ++j) {
    for (int i = 1; i <= n; ++i) p[i][j] = p[p[i][j - 1]][j - 1];
  }
}
int Irene(int first) {
  int old = first;
  for (int i = logN - 1; i >= 0; --i)
    if ((r >> i) & 1) first = p[first][i];
  return first - old;
}
void Solve() {
  int pos = 1, Max = 0, t;
  for (int i = 1; i <= n; ++i) {
    if ((t = Irene(i)) > Max) Max = t, pos = i;
  }
  for (int i = logN - 1; i >= 0; --i) {
    if ((r >> i) & 1) {
      for (int j = 0; j < (1 << i); ++j) {
        for (int k = pos; k < p[pos][0]; ++k)
          cout << _s[k] << " \n"[k == p[pos][0] - 1];
        pos = p[pos][0];
      }
    }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  if (fopen("test"
            ".inp",
            "r")) {
    freopen(
        "test"
        ".inp",
        "r", stdin);
    freopen(
        "test"
        ".out",
        "w", stdout);
  }
  Enter(), Solve();
  return 0;
}
