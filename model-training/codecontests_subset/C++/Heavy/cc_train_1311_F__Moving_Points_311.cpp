#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long ppow(long long a, long long b, long long mod) {
  a %= mod;
  long long ans = 1;
  while (b) {
    if (b & 1) ans = ans * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return ans;
}
long long readdd() {
  long long x = 0, f = 1;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-') f = -1, c = getchar();
  while (isdigit(c)) x = x * 10 + c - '0', c = getchar();
  return f * x;
}
void printtt(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x >= 10) printtt(x / 10);
  putchar(x % 10 + '0');
}
const long long maxm = 1e6 + 5;
long long c[maxm];
long long cc[maxm];
long long xx[maxm];
struct Node {
  long long x, v;
} e[maxm];
bool cmp(Node a, Node b) {
  if (a.v != b.v) {
    return a.v < b.v;
  } else {
    return a.x < b.x;
  }
}
long long lowbit(long long i) { return i & -i; }
void add(long long i, long long c[], long long t) {
  while (i < maxm) {
    c[i] += t;
    i += lowbit(i);
  }
}
long long ask(long long i, long long c[]) {
  long long ans = 0;
  while (i) {
    ans += c[i];
    i -= lowbit(i);
  }
  return ans;
}
signed main() {
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> e[i].x;
    xx[i] = e[i].x;
  }
  for (long long i = 1; i <= n; i++) {
    cin >> e[i].v;
  }
  sort(xx + 1, xx + 1 + n);
  long long num = unique(xx + 1, xx + 1 + n) - xx - 1;
  for (long long i = 1; i <= n; i++) {
    e[i].x = lower_bound(xx + 1, xx + 1 + num, e[i].x) - xx;
  }
  sort(e + 1, e + 1 + n, cmp);
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    if (e[i].x != 1) {
      long long mi = ask(e[i].x, c);
      long long temp = ask(e[i].x, cc);
      temp -= mi * ((long long)1e9 - xx[e[i].x]);
      ans += temp;
    }
    add(e[i].x, c, 1);
    add(e[i].x, cc, ((long long)1e9 - xx[e[i].x]));
  }
  cout << ans << endl;
  return 0;
}
