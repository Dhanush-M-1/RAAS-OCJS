#include <bits/stdc++.h>
using namespace std;
const int N = 1000010;
const int M = 5000010;
const int Log = 20;
const int INF = 0x3f3f3f3f;
const int iinf = 1 << 30;
const long long linf = 2e18;
const int mod = 1000000007;
const double eps = 1e-7;
void douout(double x) { printf("%lf\n", x + 0.0000000001); }
template <class T>
void chmin(T &a, T b) {
  if (a > b) a = b;
}
template <class T>
void chmax(T &a, T b) {
  if (a < b) a = b;
}
template <class T>
void Tmin(T &a, T &b, T &c) {
  return min(a, min(b, c));
}
template <class T>
void Tmax(T &a, T &b, T &c) {
  return max(a, max(b, c));
}
void add(int &a, int b) { a = a + b < mod ? a + b : a + b - mod; }
void sub(int &a, int b) { a = (a - b + mod) % mod; }
void mul(int &a, int b) { a = (long long)a * b % mod; }
int addv(int a, int b) { return (a += b) >= mod ? a -= mod : a; }
int subv(int a, int b) { return (a -= b) < 0 ? a += mod : a; }
int mulv(int a, int b) { return (long long)a * b % mod; }
int read() {
  int f = 1, x = 0;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int pw(int a, int b) {
  int s = 1;
  for (; b; b >>= 1, a = (long long)a * a % mod)
    if (b & 1) s = (long long)s * a % mod;
  return s;
}
int n, x, y;
char buf[M];
string s[N];
int sum[N], last[N], ans[N];
int multi[N][25];
void print(int x, int y) {
  if (x == y) return;
  for (int i = (x); i <= (y - 1); i++) {
    cout << s[i];
    if (i == y - 1)
      cout << endl;
    else
      putchar(' ');
  }
}
signed main() {
  scanf("%d%d%d", &n, &x, &y);
  for (int i = (0); i <= (n - 1); i++) cin >> s[i];
  for (int i = (0); i <= (n - 1); i++)
    sum[i + 1] = sum[i] + ((int)s[i].size()) + 1;
  int j = n;
  last[n] = n;
  for (int i = (n - 1); i >= (0); i--) {
    while (sum[j] - sum[i] > y + 1) j--;
    last[i] = j;
  }
  for (int i = (0); i <= (n); i++) multi[i][0] = last[i];
  for (int i = (1); i <= (Log); i++)
    for (int j = (0); j <= (n); j++)
      multi[j][i] = multi[multi[j][i - 1]][i - 1];
  for (int i = (0); i <= (n); i++) {
    int tmp = i;
    for (int j = (0); j <= (Log); j++)
      if (x & (1 << j)) tmp = multi[tmp][j];
    ans[i] = tmp;
  }
  int from = 0, to = ans[0];
  for (int i = (0); i <= (n); i++)
    if (ans[i] - i > to - from) {
      from = i;
      to = ans[i];
    }
  for (int i = (0); i <= (x - 1); i++) {
    print(from, last[from]);
    from = last[from];
  }
  return 0;
}
