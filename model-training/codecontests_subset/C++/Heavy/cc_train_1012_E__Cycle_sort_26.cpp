#include <bits/stdc++.h>
using namespace std;
template <typename T>
void maxtt(T& t1, T t2) {
  t1 = max(t1, t2);
}
template <typename T>
void mintt(T& t1, T t2) {
  t1 = min(t1, t2);
}
bool debug = 0;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
string direc = "RDLU";
long long ln, lk, lm;
void etp(bool f = 0) {
  puts(f ? "YES" : "NO");
  exit(0);
}
void addmod(int& x, int y, int mod = 998244353) {
  assert(y >= 0);
  x += y;
  if (x >= mod) x -= mod;
  assert(x >= 0 && x < mod);
}
void et(int x = -1) {
  printf("%d\n", x);
  exit(0);
}
long long fastPow(long long x, long long y, int mod = 998244353) {
  long long ans = 1;
  while (y > 0) {
    if (y & 1) ans = (x * ans) % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return ans;
}
long long gcd1(long long x, long long y) { return y ? gcd1(y, x % y) : x; }
int a[200105], p[200105], f[200105], now;
pair<int, int> b[200105];
bool vis[200105];
vector<int> vp[200105];
int ff(int x) { return x == f[x] ? x : f[x] = ff(f[x]); }
void lnk(int x, int y) {
  int fx = ff(x), fy = ff(y);
  if (fx == fy) return;
  f[fx] = fy;
}
void dfs(int x) {
  vis[x] = 1;
  vp[now].push_back(x);
  if (!vis[p[x]]) dfs(p[x]);
}
void fmain(int ID) {
  int s;
  scanf("%d%d", &n, &s);
  for (int(i) = 1; (i) <= (int)(n); (i)++) {
    scanf("%d", a + i);
    b[i] = {a[i], i};
  }
  sort(b + 1, b + 1 + n);
  for (int(i) = 1; (i) <= (int)(n); (i)++) p[b[i].second] = i;
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    if (a[i] == b[i].first && p[i] != i) {
      int j = p[i];
      p[b[i].second] = j;
      swap(b[i], b[j]);
      p[i] = i;
      assert(b[i].second == i);
    }
  for (int(i) = 1; (i) <= (int)(n); (i)++) f[i] = i;
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    if (p[i] != i) lnk(p[i], i);
  int lst = 0;
  for (int(i) = 1; (i) <= (int)(n); (i)++) {
    if (b[i].second == p[b[i].second]) continue;
    if (1 <= lst && a[lst] == a[b[i].second]) {
      int fx = ff(lst), fy = ff(b[i].second);
      if (fx == fy) continue;
      f[fx] = fy;
      swap(p[lst], p[b[i].second]);
    }
    lst = b[i].second;
  }
  now = 0;
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    if (!vis[i] && p[i] != i) {
      now++;
      dfs(i);
    }
  int sum = 0;
  for (int(i) = 1; (i) <= (int)(now); (i)++) sum += vp[i].size();
  if (s < sum) et();
  s -= sum;
  mintt(s, now);
  if (s <= 1) {
    printf("%d\n", now);
    for (int(i) = 1; (i) <= (int)(now); (i)++) {
      printf("%d\n", (int)vp[i].size());
      for (int c : vp[i]) printf("%d ", c);
      puts("");
    }
    return;
  }
  printf("%d\n", now - s + 2);
  for (int(i) = 1; (i) <= (int)(now - s); (i)++) {
    printf("%d\n", (int)vp[i + s].size());
    for (int c : vp[i + s]) printf("%d ", c);
    puts("");
    sum -= vp[i + s].size();
  }
  printf("%d\n", sum);
  for (int(i) = 1; (i) <= (int)(s); (i)++)
    for (int c : vp[i]) printf("%d ", c);
  puts("");
  printf("%d\n", s);
  for (int i = s; i; i--) printf("%d ", vp[i][0]);
  puts("");
}
int main() {
  int t = 1;
  for (int(i) = 1; (i) <= (int)(t); (i)++) {
    fmain(i);
  }
  return 0;
}
