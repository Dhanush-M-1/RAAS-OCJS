#include <bits/stdc++.h>
using namespace std;
template <class T>
void _R(T &x) {
  cin >> x;
}
void _R(int &x) { scanf("%d", &x); }
void _R(long long &x) { scanf("%lld", &x); }
void _R(double &x) { scanf("%lf", &x); }
void _R(char &x) { scanf(" %c", &x); }
void _R(char *x) { scanf("%s", x); }
void R() {}
template <class T, class... U>
void R(T &head, U &...tail) {
  _R(head);
  R(tail...);
}
template <class T>
void _W(const T &x) {
  cout << x;
}
void _W(const int &x) { printf("%d", x); }
void _W(const long long &x) { printf("%lld", x); }
void _W(const double &x) { printf("%.16f", x); }
void _W(const char &x) { putchar(x); }
void _W(const char *x) { printf("%s", x); }
template <class T, class U>
void _W(const pair<T, U> &x) {
  _W(x.first);
  putchar(' ');
  _W(x.second);
}
template <class T>
void _W(const vector<T> &x) {
  for (auto i = x.begin(); i != x.end(); _W(*i++))
    if (i != x.cbegin()) putchar(' ');
}
void W() {}
template <class T, class... U>
void W(const T &head, const U &...tail) {
  _W(head);
  putchar(sizeof...(tail) ? ' ' : '\n');
  W(tail...);
}
int MOD = 1e9 + 7;
void ADD(long long &x, long long v) {
  x = (x + v) % MOD;
  if (x < 0) x += MOD;
}
const int SIZE = 1e6 + 10;
long long dp[2][10];
template <class T>
void maa(T &x, T y) {
  if (x < y) x = y;
}
template <class T>
void mii(T &x, T y) {
  if (x > y) x = y;
}
int main() {
  int n;
  R(n);
  memset((dp), -1, sizeof((dp)));
  dp[0][0] = 0;
  int now = 0, nxt = 1;
  while (n--) {
    int k;
    R(k);
    memcpy(dp[nxt], dp[now], sizeof(dp[now]));
    vector<long long> AA[4];
    for (int j = 0; j < (k); ++j) {
      int x, y;
      R(x, y);
      AA[x].push_back(y);
    }
    for (int j = (1); j <= (3); ++j)
      sort((AA[j]).begin(), (AA[j]).end(), greater<long long>());
    for (int i = 0; i < (10); ++i) {
      if (dp[now][i] == -1) continue;
      for (int j = (1); j <= (3); ++j) {
        if (((int)(AA[j]).size()) > 0)
          maa(dp[nxt][(i + 1) % 10],
              dp[now][i] + (AA[j][0] * (1 + ((i + 1) == 10))));
      }
      if (((int)(AA[1]).size()) >= 3) {
        maa(dp[nxt][(i + 3) % 10], dp[now][i] +
                                       AA[1][0] * (1 + ((i + 3) >= 10)) +
                                       AA[1][1] + AA[1][2]);
      }
      if (((int)(AA[1]).size()) >= 2) {
        maa(dp[nxt][(i + 2) % 10],
            dp[now][i] + AA[1][0] * (1 + ((i + 2) >= 10)) + AA[1][1]);
      }
      if (((int)(AA[1]).size()) >= 1 && ((int)(AA[2]).size()) >= 1) {
        maa(dp[nxt][(i + 2) % 10],
            dp[now][i] + max(AA[1][0], AA[2][0]) * ((i + 2) >= 10) + AA[1][0] +
                AA[2][0]);
      }
    }
    swap(now, nxt);
  }
  long long an = 0;
  for (int i = 0; i < (10); ++i) an = max(an, dp[now][i]);
  W(an);
  return 0;
}
