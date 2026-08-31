#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, U b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, U b) {
  if (a < b) a = b;
}
template <class T>
inline void gn(T &first) {
  char c, sg = 0;
  while (c = getchar(), (c > '9' || c < '0') && c != '-')
    ;
  for ((c == '-' ? sg = 1, c = getchar() : 0), first = 0; c >= '0' && c <= '9';
       c = getchar())
    first = (first << 1) + (first << 3) + c - '0';
  if (sg) first = -first;
}
template <class T>
inline void print(T first) {
  if (first < 0) {
    putchar('-');
    return print(-first);
  }
  if (first < 10) {
    putchar('0' + first);
    return;
  }
  print(first / 10);
  putchar(first % 10 + '0');
}
template <class T, class T1>
inline void gn(T &first, T1 &second) {
  gn(first);
  gn(second);
}
template <class T, class T1, class T2>
inline void gn(T &first, T1 &second, T2 &z) {
  gn(first);
  gn(second);
  gn(z);
}
template <class T>
inline void println(T first) {
  print(first);
  putchar('\n');
}
template <class T>
inline void printsp(T first) {
  print(first);
  putchar(' ');
}
template <class T1, class T2>
inline void print(T1 x1, T2 x2) {
  printsp(x1), println(x2);
}
template <class T1, class T2, class T3>
inline void print(T1 x1, T2 x2, T3 x3) {
  printsp(x1), printsp(x2), println(x3);
}
template <class T1, class T2, class T3, class T4>
inline void print(T1 x1, T2 x2, T3 x3, T4 x4) {
  printsp(x1), printsp(x2), printsp(x3), println(x4);
}
int power(int a, int b, int m, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % m)
    if (b & 1) ans = 1LL * ans * a % m;
  return ans;
}
char s[2011][2011];
char pat[2011][2011];
namespace fft {
const int mod = 998244353;
const int root = 31;
const int root_1 = power(root, mod - 2, mod);
int mPow(int a, int first) { return power(a, first, mod); }
void fft(vector<int> &a, bool invert) {
  int n = a.size();
  int PW = mPow(invert ? root_1 : root, (mod - 1) / n);
  for (int m = n, h; h = m / 2, m >= 2; PW = 1LL * PW * PW % mod, m = h) {
    for (int i = 0, w = 1; i < h; ++i, w = 1LL * w * PW % mod)
      for (int j = i; j < n; j += m) {
        int k = j + h, first = (a[j] - a[k] + mod) % mod;
        a[j] += a[k];
        a[j] %= mod;
        a[k] = 1LL * w * first % mod;
      }
  }
  for (int i = 0, j = 1; j < n - 1; ++j) {
    for (int k = n / 2; k > (i ^= k); k /= 2)
      ;
    if (j < i) swap(a[i], a[j]);
  }
  if (invert) {
    int rev = mPow(n, mod - 2);
    for (int i = 0; i < n; ++i) a[i] = 1LL * a[i] * rev % mod;
  }
}
vector<int> multiply(const vector<int> &a, const vector<int> &b) {
  int n = a.size() + b.size();
  vector<int> na = a, nb = b;
  int mx = 1;
  while (mx < n) mx <<= 1;
  na.resize(mx);
  nb.resize(mx);
  fft(na, false);
  fft(nb, false);
  for (int i = 0; i < mx; ++i) na[i] = 1LL * na[i] * nb[i] % mod;
  fft(na, true);
  na.resize(n);
  return na;
}
};  // namespace fft
vector<int> a, b, C;
int ans[2011][2011];
int main() {
  int n, m, r, c;
  gn(n, m);
  for (int i = 0; i < n; i++) scanf("%s", s[i]);
  gn(r, c);
  for (int i = 0; i < r; i++) scanf("%s", pat[i]);
  for (int i = 'a'; i <= 'z'; i++) {
    a.clear();
    b.clear();
    for (int j = 0; j < n + r - 1; j++) {
      for (int k = 0; k < m + c - 1; k++) a.push_back(s[j % n][k % m] == i);
    }
    int cnt = 0;
    for (int j = 0; j < n + r - 1; j++) {
      for (int k = 0; k < m + c - 1; k++) {
        if (j < r and k < c) {
          b.push_back(pat[j][k] == i);
          if (pat[j][k] == i) cnt++;
        } else
          b.push_back(0);
      }
    }
    if (cnt == 0) {
      for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) ans[i][j]++;
      continue;
    }
    reverse(b.begin(), b.end());
    C = fft::multiply(a, b);
    int ed = (m + c - 1) * (n + r - 1);
    for (int j = (m + c - 1) * (n + r - 1) - 1; j < 2 * ed - 1; j++) {
      int d = j - ed + 1;
      int first = d / (m + c - 1);
      int second = d % (m + c - 1);
      ans[first][second] += C[j] == cnt;
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) print(ans[i][j] == 26);
    puts("");
  }
  return 0;
}
