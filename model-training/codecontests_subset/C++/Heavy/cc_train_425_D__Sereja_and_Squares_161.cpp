#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int INF = (int)1e9;
const long long LINF = (long long)1e18;
const long double PI = acos((long double)-1);
const long double EPS = 1e-9;
inline long long gcd(long long a, long long b) {
  long long r;
  while (b) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
inline long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
inline long long fpow(long long n, long long k, int p = MOD) {
  long long r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
template <class T>
inline int chkmin(T& a, const T& val) {
  return a > val ? a = val, 1 : 0;
}
template <class T>
inline int chkmax(T& a, const T& val) {
  return a < val ? a = val, 1 : 0;
}
inline long long isqrt(long long k) {
  long long r = sqrt(k) + 1;
  while (r * r > k) r--;
  return r;
}
inline long long icbrt(long long k) {
  long long r = cbrt(k) + 1;
  while (r * r * r > k) r--;
  return r;
}
inline void addmod(int& a, int val, int p = MOD) {
  if ((a = (a + val)) >= p) a -= p;
}
inline void submod(int& a, int val, int p = MOD) {
  if ((a = (a - val)) < 0) a += p;
}
inline int mult(int a, int b, int p = MOD) { return (long long)a * b % p; }
inline int inv(int a, int p = MOD) { return fpow(a, p - 2, p); }
const int MAXN = 7654321;
const int NOTFOUND = -1;
struct HashMap {
  int cur, head[MAXN], next[MAXN];
  long long l[MAXN];
  int x[MAXN];
  HashMap() {
    cur = 0;
    fill_n(head, MAXN, 0);
    fill_n(next, MAXN, 0);
  }
  int find(long long key) {
    for (int i = head[key % MAXN]; i; i = next[i]) {
      if (l[i] == key) {
        return x[i];
      }
    }
    return NOTFOUND;
  }
  void erase(long long key) {
    for (int i = head[key % MAXN]; i; i = next[i]) {
      if (l[i] == key) {
        x[i] = NOTFOUND;
      }
    }
  }
  void insert(long long key, int val) {
    if (find(key) != NOTFOUND) return;
    l[++cur] = key;
    x[cur] = val;
    next[cur] = head[key % MAXN];
    head[key % MAXN] = cur;
  }
} hm;
long long phash(int u, int v) { return (((long long)u) << 20) + v; }
const int maxn = 100010;
const int magic = 320;
int n;
vector<int> ax[maxn];
vector<int> ay[maxn];
void solve() {
  cin >> n;
  for (int i = (0); i < (n); i++) {
    int u, v;
    cin >> u >> v;
    ax[u].push_back(v);
    hm.insert(phash(u, v), 1);
  }
  int ans = 0;
  for (int i = (0); i < (maxn); i++) {
    if (int((ax[i]).size()) < magic) {
      for (int j = (0); j < (int((ax[i]).size())); j++) {
        for (int k = (j + 1); k < (int((ax[i]).size())); k++) {
          int p = abs(ax[i][j] - ax[i][k]);
          if (i - p >= 0 && hm.find(phash(i - p, ax[i][j])) != NOTFOUND &&
              hm.find(phash(i - p, ax[i][k])) != NOTFOUND) {
            ans++;
          }
          if (i + p < maxn && hm.find(phash(i + p, ax[i][j])) != NOTFOUND &&
              hm.find(phash(i + p, ax[i][k])) != NOTFOUND) {
            ans++;
          }
        }
        hm.erase(phash(i, ax[i][j]));
      }
    } else {
      for (int j = (0); j < (int((ax[i]).size())); j++) {
        ay[ax[i][j]].push_back(i);
      }
    }
  }
  for (int i = (0); i < (maxn); i++) {
    for (int j = (0); j < (int((ay[i]).size())); j++) {
      for (int k = (j + 1); k < (int((ay[i]).size())); k++) {
        int p = abs(ay[i][j] - ay[i][k]);
        if (i - p >= 0 && hm.find(phash(ay[i][j], i - p)) != NOTFOUND &&
            hm.find(phash(ay[i][k], i - p)) != NOTFOUND) {
          ans++;
        }
        if (i + p < maxn && hm.find(phash(ay[i][j], i + p)) != NOTFOUND &&
            hm.find(phash(ay[i][k], i + p)) != NOTFOUND) {
          ans++;
        }
      }
      hm.erase(phash(ay[i][j], i));
    }
  }
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  solve();
  return 0;
}
