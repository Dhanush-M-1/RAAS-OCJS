#include <bits/stdc++.h>
using namespace std;
const int inf = ~0U >> 1;
const long long INF = ~0ULL >> 1;
template <class T>
inline void read(T &n) {
  char c;
  for (c = getchar(); !(c >= '0' && c <= '9'); c = getchar())
    ;
  n = c - '0';
  for (c = getchar(); c >= '0' && c <= '9'; c = getchar()) n = n * 10 + c - '0';
}
int Pow(int base, int n, int mo) {
  if (n == 0) return 1;
  if (n == 1) return base % mo;
  int tmp = Pow(base, n >> 1, mo);
  tmp = (long long)tmp * tmp % mo;
  if (n & 1) tmp = (long long)tmp * base % mo;
  return tmp;
}
int n, r, c, a[1200000], s[1200000], f[1200000][22];
int best, ansl, ansr;
string str[1200000];
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> r >> c;
  for (int i = (1); i <= (n); ++i) {
    cin >> str[i];
    a[i] = str[i].size();
  }
  for (int i = (1); i <= (n); ++i) s[i] = s[i - 1] + a[i];
  s[n + 1] = s[n];
  int cur = 0;
  for (int i = (1); i <= (n); ++i) {
    cur = max(cur, i - 1);
    while (cur <= n && s[cur + 1] - s[i - 1] + cur + 1 - (i - 1) - 1 <= c)
      cur++;
    f[i][0] = cur;
  }
  f[n + 1][0] = n + 1;
  for (int j = (1); j <= (20); ++j) {
    for (int i = (1); i <= (n); ++i)
      if (f[i][j - 1] >= i)
        f[i][j] = f[min(n + 1, f[i][j - 1] + 1)][j - 1];
      else
        f[i][j] = i - 1;
    f[n + 1][j] = n + 1;
  }
  for (int l = (1); l <= (n); ++l) {
    if (a[l] > c) continue;
    int cur = l - 1;
    for (int j = (0); j <= (20); ++j)
      if ((1 << j) & r)
        if (cur <= n) cur = f[cur + 1][j];
    cur = min(cur, n);
    if (cur - l + 1 > best) {
      best = cur - l + 1;
      ansl = l;
      ansr = cur;
    }
  }
  for (int i = (ansl); i <= (ansr); ++i) {
    int cur = 0;
    int flag = 0;
    while (cur + a[i] <= c && i <= n) {
      cur += a[i] + 1;
      if (flag) cout << ' ';
      cout << str[i++];
      flag = 1;
    }
    cout << endl;
    i--;
  }
  return 0;
}
