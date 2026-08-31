#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const long double PI = 3.141592653589793238462643383279502884197;
long long fac[1] = {1}, inv[1] = {1};
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long mp(long long a, long long b) {
  long long ret = 1;
  while (b) {
    if (b & 1) ret = ret * a % MOD;
    a = a * a % MOD;
    b >>= 1;
  }
  return ret;
}
long long cmb(long long r, long long c) {
  return (c > r || c < 0) ? 0 : fac[r] * inv[c] % MOD * inv[r - c] % MOD;
}
char s[300001];
vector<int> v[300000];
int p[600001];
int rotn[600001];
char vis[600001];
int find(int a) {
  if (p[a] == -1) return a;
  return p[a] = find(p[a]);
}
void merge(int a, int b) {
  a = find(a);
  b = find(b);
  if (a == b) return;
  if (a > b) swap(a, b);
  p[b] = a;
  rotn[a] = min((int)1e9, rotn[b] + rotn[a]);
}
int main() {
  memset(p, -1, sizeof(p));
  int n, k;
  scanf("%d %d", &n, &k);
  scanf("%s", s);
  for (int i = 0; i < n; i++) s[i] -= '0';
  for (int i = 0; i < k; i++) rotn[i] = 1;
  for (int i = 0; i < k; i++) {
    int t;
    scanf("%d", &t);
    for (int j = 0; j < t; j++) {
      int tt;
      scanf("%d", &tt);
      tt--;
      v[tt].push_back(i);
    }
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j : v[i]) {
      if (vis[find(j)]) ans -= rotn[find(j)], vis[find(j)] = 0;
      if (vis[find(j + k)]) ans -= rotn[find(j + k)], vis[find(j + k)] = 0;
    }
    if (s[i] == 0) {
      if ((int)(v[i]).size() == 2) {
        merge(v[i][0] + k, v[i][1]);
        merge(v[i][0], v[i][1] + k);
      } else
        rotn[find(v[i][0] + k)] = 1e9;
    } else {
      if ((int)(v[i]).size() == 2) {
        merge(v[i][0], v[i][1]);
        merge(v[i][0] + k, v[i][1] + k);
      } else if ((int)(v[i]).size() == 1)
        rotn[find(v[i][0])] = 1e9;
    }
    for (int j : v[i]) {
      if (vis[find(j)] || vis[find(j + k)]) continue;
      int ne;
      if (rotn[find(j)] > rotn[find(j + k)])
        ne = find(j + k);
      else
        ne = find(j);
      vis[ne] = 1;
      ans += rotn[ne];
    }
    printf("%d\n", ans);
  }
}
