#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
inline T1 max(T1 a, T2 b) {
  return a < b ? b : a;
}
template <typename T1, typename T2>
inline T1 min(T1 a, T2 b) {
  return a < b ? a : b;
}
const char lf = '\n';
namespace ae86 {
const int bufl = 1 << 15;
char buf[bufl], *s = buf, *t = buf;
inline int fetch() {
  if (s == t) {
    t = (s = buf) + fread(buf, 1, bufl, stdin);
    if (s == t) return EOF;
  }
  return *s++;
}
inline int ty() {
  int a = 0;
  int b = 1, c = fetch();
  while (!isdigit(c)) b ^= c == '-', c = fetch();
  while (isdigit(c)) a = a * 10 + c - 48, c = fetch();
  return b ? a : -a;
}
}  // namespace ae86
using ae86::ty;
const int _ = 100007;
int mo;
template <typename T1, typename T2>
inline T1 ad(T1 &a, T2 b) {
  return a = a + b >= mo ? a + b - mo : a + b;
}
template <typename T1, typename T2>
inline T1 dl(T1 &a, T2 b) {
  return a = a >= b ? a - b : a - b + mo;
}
template <typename T1, typename T2>
inline T1 add(T1 a, T2 b) {
  return a + b >= mo ? a + b - mo : a + b;
}
template <typename T1, typename T2>
inline T1 del(T1 a, T2 b) {
  return a >= b ? a - b : a - b + mo;
}
long long powa(long long a, long long t) {
  long long b = 1;
  a = (a + mo) % mo;
  while (t) {
    if (t & 1) b = b * a % mo;
    a = a * a % mo, t >>= 1;
  }
  return b;
}
inline long long inva(long long a) { return powa(a, mo - 2); }
long long ri[_] = {0}, sri[_] = {0};
void fuck(int n = _ - 1) {
  ri[0] = 0, sri[0] = 0;
  ri[1] = 1, sri[1] = ri[1];
  for (int i = 2; i <= n; i++)
    ri[i] = ri[mo % i] * (mo - mo / i) % mo, sri[i] = add(sri[i - 1], ri[i]);
}
map<int, int> cnt;
void dfs(int x, int l, int r) {
  if (x <= 1 || l == r) {
    cnt[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  dfs(x - 1, l, mid), dfs(x - 1, mid + 1, r);
}
long long sumri(long long a, long long b) {
  long long ans = a * b % mo;
  for (int i = 1; i <= a; i++) dl(ans, del(sri[i + b], sri[i]) * 2 % mo);
  return ans;
}
int n, tim;
int main() {
  ios::sync_with_stdio(0), cout.tie(nullptr);
  n = ty(), tim = ty(), mo = ty();
  fuck();
  dfs(tim, 1, n);
  long long ans = 0;
  for (auto i : cnt) {
    long long a = i.first, b = i.second;
    ad(ans, a * (a - 1) % mo * ri[2] % mo * b % mo);
    ad(ans, b * (b - 1) % mo * ri[2] % mo * sumri(a, a) % mo);
    for (auto j : cnt) {
      long long c = j.first, d = j.second;
      if (a >= c) continue;
      ad(ans, sumri(a, c) * b % mo * d % mo);
    }
  }
  cout << ans * ri[2] % mo << lf;
  return 0;
}
