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
string direc = "URDL";
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
vector<int> mp[200135];
int h[200135], sg[200135], s[200135];
int spg(int x) {
  int& tmp = sg[x];
  if (tmp != -1) return tmp;
  vector<int> vp;
  for (int c : mp[x]) vp.push_back(spg(c));
  sort(vp.begin(), vp.end());
  int N = unique(vp.begin(), vp.end()) - vp.begin();
  for (int(i) = 0; (i) < (int)(N); (i)++)
    if (i != vp[i]) {
      tmp = i;
      return tmp;
    }
  tmp = N;
  return tmp;
}
void fmain(int tid) {
  scanf("%d%d", &n, &m);
  for (int(i) = 1; (i) <= (int)(n); (i)++) scanf("%d", h + i);
  for (int(i) = 1; (i) <= (int)(m); (i)++) {
    int u, v;
    scanf("%d%d", &u, &v);
    mp[u].push_back(v);
  }
  memset(sg, -1, sizeof sg);
  for (int(i) = 1; (i) <= (int)(n); (i)++) {
    s[spg(i)] ^= h[i];
  }
  int tar = -1;
  for (int i = n; i >= 0; i--)
    if (s[i] != 0) {
      tar = i;
      break;
    }
  if (tar == -1) {
    puts("LOSE");
    return;
  }
  puts("WIN");
  int w = -1;
  for (int(i) = 1; (i) <= (int)(n); (i)++)
    if (sg[i] == tar) {
      if ((s[tar] ^ h[i]) < h[i]) {
        w = i;
        break;
      }
    }
  h[w] = s[tar] ^ h[w];
  for (int c : mp[w]) {
    h[c] = s[sg[c]] ^ h[c];
    s[sg[c]] = 0;
  }
  for (int(i) = 1; (i) <= (int)(n); (i)++) printf("%d ", h[i]);
}
int main() {
  int t = 1;
  for (int(i) = 1; (i) <= (int)(t); (i)++) {
    fmain(i);
  }
  return 0;
}
