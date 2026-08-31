#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f, MAXN = 2e6 + 50;
const long long LINF = 2e9 + 1000, MOD = 998244353;
const double Pi = acos(-1), EPS = 1e-6;
void test() { cerr << "\n"; }
template <typename T, typename... Args>
void test(T x, Args... args) {
  cerr << x << " ";
  test(args...);
}
inline long long qpow(long long a, long long b) {
  return b ? ((b & 1) ? a * qpow(a * a % MOD, b >> 1) % MOD
                      : qpow(a * a % MOD, b >> 1)) %
                 MOD
           : 1;
}
inline long long qpow(long long a, long long b, long long c) {
  return b ? ((b & 1) ? a * qpow(a * a % c, b >> 1) % c
                      : qpow(a * a % c, b >> 1)) %
                 c
           : 1;
}
inline long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
inline long long cede(long long a, long long b) {
  if (b < 0) return cede(-a, -b);
  if (a < 0) return a / b;
  return (a + b - 1) / b;
}
inline long long flde(long long a, long long b) {
  if (b < 0) return flde(-a, -b);
  if (a < 0) return (a - b + 1) / b;
  return a / b;
}
inline int sign(double x) { return x < -EPS ? -1 : x > EPS; }
inline int dbcmp(double l, double r) { return sign(l - r); }
namespace Fast_IO {
const int MAXL((1 << 18) + 1);
int iof, iotp;
char ioif[MAXL], *ioiS, *ioiT, ioof[MAXL],
    *iooS = ioof, *iooT = ioof + MAXL - 1, ioc, iost[55];
char Getchar() {
  if (ioiS == ioiT) {
    ioiS = ioif;
    ioiT = ioiS + fread(ioif, 1, MAXL, stdin);
    return (ioiS == ioiT ? EOF : *ioiS++);
  } else
    return (*ioiS++);
}
void Write() {
  fwrite(ioof, 1, iooS - ioof, stdout);
  iooS = ioof;
}
void Putchar(char x) {
  *iooS++ = x;
  if (iooS == iooT) Write();
}
inline int read() {
  int x = 0;
  for (iof = 1, ioc = Getchar(); ioc < '0' || ioc > '9';)
    iof = ioc == '-' ? -1 : 1, ioc = Getchar();
  for (x = 0; ioc <= '9' && ioc >= '0'; ioc = Getchar())
    x = (x << 3) + (x << 1) + (ioc ^ 48);
  return x * iof;
}
inline long long read_ll() {
  long long x = 0;
  for (iof = 1, ioc = Getchar(); ioc < '0' || ioc > '9';)
    iof = ioc == '-' ? -1 : 1, ioc = Getchar();
  for (x = 0; ioc <= '9' && ioc >= '0'; ioc = Getchar())
    x = (x << 3) + (x << 1) + (ioc ^ 48);
  return x * iof;
}
template <class Int>
void Print(Int x, char ch = '\0') {
  if (!x) Putchar('0');
  if (x < 0) Putchar('-'), x = -x;
  while (x) iost[++iotp] = x % 10 + '0', x /= 10;
  while (iotp) Putchar(iost[iotp--]);
  if (ch) Putchar(ch);
}
void Getstr(char *s, int &l) {
  for (ioc = Getchar(); ioc < 'a' || ioc > 'z';) ioc = Getchar();
  for (l = 0; ioc <= 'z' && ioc >= 'a'; ioc = Getchar()) s[l++] = ioc;
  s[l] = 0;
}
void Putstr(const char *s) {
  for (int i = 0, n = strlen(s); i < n; ++i) Putchar(s[i]);
}
}  // namespace Fast_IO
using namespace Fast_IO;
vector<pair<int, int> > a, b, c;
int prea[MAXN], preb[MAXN], prec[MAXN];
int cnt[MAXN], sum[MAXN];
int lowbit(int x) { return x & -x; }
const int MAXT = 1e4 + 50;
void add(int *tree, int x, int val) {
  while (x <= MAXT) {
    tree[x] += val;
    x += lowbit(x);
  }
}
int ask(int *tree, int x) {
  int ans = 0;
  while (x) {
    ans += tree[x];
    x -= lowbit(x);
  }
  return ans;
}
void UPD(int i, int k) {
  if (i > 0 && i < a.size())
    add(cnt, a[i].first, -1), add(sum, a[i].first, -a[i].first);
  i--;
  if (k - i > 0 && k - i < b.size())
    add(cnt, b[k - i].first, 1), add(sum, b[k - i].first, b[k - i].first);
  if (k - i > 0 && k - i < c.size())
    add(cnt, c[k - i].first, 1), add(sum, c[k - i].first, c[k - i].first);
}
void work() {
  int n, k, m;
  scanf("%d%d%d", &n, &m, &k);
  a.push_back({0, 0});
  b.push_back({0, 0});
  c.push_back({0, 0});
  int cnta = 0, cntb = 0;
  set<pair<int, int> > st;
  for (int i = 1; i <= n; i++) {
    int t, x, y;
    scanf("%d%d%d", &t, &x, &y);
    st.insert({t, i});
    cnta += x;
    cntb += y;
    if (x && y) {
      a.push_back({t, i});
      add(cnt, t, 1);
      add(sum, t, t);
    } else if (x && !y)
      b.push_back({t, i});
    else if (y && !x)
      c.push_back({t, i});
    else {
      add(cnt, t, 1);
      add(sum, t, t);
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  for (int i = k + 2; i < b.size(); i++)
    add(cnt, b[i].first, 1), add(sum, b[i].first, b[i].first);
  for (int i = k + 2; i < c.size(); i++)
    add(cnt, c[i].first, 1), add(sum, c[i].first, c[i].first);
  if (cnta < k || cntb < k) {
    printf("-1");
    return;
  }
  for (int i = 1; i < a.size(); i++) prea[i] = prea[i - 1] + a[i].first;
  for (int i = 1; i < b.size(); i++) preb[i] = preb[i - 1] + b[i].first;
  for (int i = 1; i < c.size(); i++) prec[i] = prec[i - 1] + c[i].first;
  int ans = LINF;
  int maxi = 0, maxl = 0;
  for (int i = 0; i < a.size(); i++) {
    UPD(i, k);
    if (k - i >= b.size() || k - i >= c.size() || i + k - i + k - i > m) {
      continue;
    }
    if (k - i < 0) break;
    int lef = m - (i + k - i + k - i);
    if (lef < 0) {
      continue;
    }
    int l = 0, r = MAXT;
    while (l < r) {
      int mid = l + r >> 1;
      if (ask(cnt, mid) >= lef)
        r = mid;
      else
        l = mid + 1;
    }
    if (r == MAXT) {
      continue;
    }
    int tmp;
    if (l == 0)
      tmp = 0;
    else
      tmp = ask(sum, l - 1) + l * (lef - ask(cnt, l - 1));
    if (ans > prea[i] + preb[k - i] + prec[k - i] + tmp) {
      ans = prea[i] + preb[k - i] + prec[k - i] + tmp;
      maxi = i;
      maxl = l;
    }
  }
  if (ans == LINF) {
    printf("-1\n");
    return;
  }
  printf("%d\n", ans);
  for (int i = 1; i <= maxi; i++)
    printf("%d ", a[i].second), st.erase({a[i].first, a[i].second});
  for (int i = 1; i <= k - maxi; i++)
    printf("%d %d ", b[i].second, c[i].second),
        st.erase({b[i].first, b[i].second}),
        st.erase({c[i].first, c[i].second});
  for (int i = 1; i <= m - (maxi + k - maxi + k - maxi); i++)
    printf("%d ", (*st.begin()).second), st.erase(st.begin());
}
int main() { work(); }
