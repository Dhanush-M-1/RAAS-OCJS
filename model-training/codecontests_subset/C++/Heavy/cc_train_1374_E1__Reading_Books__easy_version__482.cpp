#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-10;
template <typename T>
void read(T &x) {
  int f = 1;
  x = 0;
  char s = getchar();
  while (s < '0' || s > '9') {
    if (s == '-') f = -1;
    s = getchar();
  }
  while (s >= '0' && s <= '9') {
    x = x * 10 + s - '0';
    s = getchar();
  }
  x *= f;
}
template <typename T>
void print(T x) {
  if (x < 0) putchar('-'), x = -x;
  if (x > 9) print(x / 10);
  putchar(x % 10 + '0');
}
template <typename T>
void println(T x) {
  if (x < 0) putchar('-'), x = -x;
  if (x > 9) print(x / 10);
  putchar(x % 10 + '0');
  putchar('\n');
}
template <typename T, typename... Args>
void read(T &x, Args &...args) {
  read(x);
  read(args...);
}
inline void reads(char *a) { scanf("%s", a); }
template <typename... Args>
void reads(char *a, Args *...args) {
  scanf("%s", a);
  reads(args...);
}
template <typename T, typename... Args>
void print(T x, Args... args) {
  print(x);
  putchar(' ');
  print(args...);
}
template <typename T, typename... Args>
void println(T x, Args... args) {
  print(x);
  putchar(' ');
  println(args...);
}
inline void prints(char *a) { printf("%s", a); }
template <typename T>
inline T sqr(T x) {
  return x * x;
}
template <typename T>
inline T random(T R) {
  return (double)rand() / RAND_MAX * R + ((T)0.5 == 0 ? 0.5 : 0.0);
}
template <typename T>
inline T random(T L, T R) {
  return random(R - L) + L;
}
long long ksm(long long a, long long k, long long Mod) {
  long long res = 1;
  while (k) {
    if (k & 1) (res *= a) %= Mod;
    (a *= a) %= Mod;
    k >>= 1;
  }
  return res % Mod;
}
inline long long inv(long long a, long long Mod) {
  return ksm(a, Mod - 2, Mod);
}
inline void cap_bit(long long x) {
  for (int i = 63; i >= 0; --i)
    if (x >> i & 1) {
      printf("Need (%d) = %lld\n", i + 1, 1LL << (i + 1));
      return;
    }
}
inline void cal_space(long long x) { printf("%lld MB\n", x >> 20); }
const int dx4[] = {0, 0, -1, 1};
const int dy4[] = {-1, 1, 0, 0};
const int dx6[] = {1, -1, 0, 0, 0, 0};
const int dy6[] = {0, 0, 1, -1, 0, 0};
const int dz6[] = {0, 0, 0, 0, 1, -1};
const int N = 2e5 + 5;
const int M = 26;
const long long Mod = 1e9 + 7;
const long long INF = 1e16;
pair<long long, long long> a[4][N];
long long ia[4];
long long n, m, k;
set<pair<long long, long long> > sf, ss;
long long ans, cur;
void adjust(int x) {
  long long cnt = x + 2 * (k - x);
  while (ss.size() && sf.size() && ss.rbegin()->first > sf.begin()->first) {
    cur -= ss.rbegin()->first;
    cur += sf.begin()->first;
    sf.insert(*ss.rbegin());
    ss.erase(*ss.rbegin());
    ss.insert(*sf.begin());
    sf.erase(*sf.begin());
  }
  while (ss.size() && cnt + ss.size() > m) {
    cur -= ss.rbegin()->first;
    sf.insert(*ss.rbegin());
    ss.erase(*ss.rbegin());
  }
  while (sf.size() && cnt + ss.size() < m) {
    cur += sf.begin()->first;
    ss.insert(*sf.begin());
    sf.erase(*sf.begin());
  }
}
int main() {
  cin >> n >> m >> k;
  for (int i = 0; i < 4; ++i) ia[i] = 0;
  for (int i = 1; i <= n; ++i) {
    long long t, ai, bi;
    cin >> t >> ai >> bi;
    int s = 0;
    if (ai) s += 1;
    if (bi) s += 2;
    a[s][++ia[s]] = {t, i};
  }
  if (ia[1] + ia[3] < k || ia[2] + ia[3] < k) {
    puts("-1");
    return 0;
  }
  for (int i = 0; i < 4; ++i) sort(a[i] + 1, a[i] + ia[i] + 1);
  long long st = 0;
  cur = -1;
  ans = -1;
  long long ians;
  while ((k - st) > ia[1] || (k - st) > ia[2]) st++;
  for (int i = st; i <= ia[3] && i <= k; ++i) {
    long long cnt = i + (k - i) * 2;
    if (cur == -1) {
      cur = 0;
      for (int j = 1; j <= ia[3]; ++j)
        if (j <= st)
          cur += a[3][j].first;
        else
          sf.insert(a[3][j]);
      for (int j = 1; j <= ia[2]; ++j)
        if (j <= (k - st))
          cur += a[2][j].first;
        else
          sf.insert(a[2][j]);
      for (int j = 1; j <= ia[1]; ++j)
        if (j <= (k - st))
          cur += a[1][j].first;
        else
          sf.insert(a[1][j]);
      for (int j = 1; j <= ia[0]; ++j) sf.insert(a[0][j]);
    } else {
      long long r = k - i;
      if (sf.find(a[3][i]) != sf.end())
        cur += a[3][i].first, sf.erase(a[3][i]);
      else
        ss.erase(a[3][i]);
      cur -= a[1][r + 1].first;
      cur -= a[2][r + 1].first;
      sf.insert(a[1][r + 1]);
      sf.insert(a[2][r + 1]);
    }
    adjust(i);
    if (cnt + ss.size() == m) {
      if (ans == -1 || cur < ans) {
        ans = cur;
        ians = i;
      }
    }
  }
  cout << ans << endl;
  if (ans == -1) return 0;
  vector<pair<long long, long long> > res;
  for (int i = 1; i <= ians; ++i) cout << a[3][i].second << " ";
  for (int i = ians + 1; i <= ia[3]; ++i) res.push_back(a[3][i]);
  for (int i = 1; i <= k - ians; ++i) cout << a[1][i].second << " ";
  for (int i = k - ians + 1; i <= ia[1]; ++i) res.push_back(a[1][i]);
  for (int i = 1; i <= k - ians; ++i) cout << a[2][i].second << " ";
  for (int i = k - ians + 1; i <= ia[2]; ++i) res.push_back(a[2][i]);
  for (int i = 1; i <= ia[0]; ++i) res.push_back(a[0][i]);
  sort((res).begin(), (res).end());
  for (int i = 1; i <= m - ians - 2 * (k - ians); ++i)
    cout << res[i - 1].second << " ";
  return 0;
}
