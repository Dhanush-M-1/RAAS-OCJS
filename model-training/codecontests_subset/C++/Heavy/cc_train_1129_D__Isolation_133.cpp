#include <bits/stdc++.h>
using namespace std;
long long modpow(long long a, long long b,
                 long long mod = (long long)(1e9 + 7)) {
  if (!b) return 1;
  a %= mod;
  return modpow(a * a % mod, b / 2, mod) * (b & 1 ? a : 1) % mod;
}
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const int mxn = 2e5, mod = 998244353;
const int B = 300;
int n, k;
int a[mxn], dp[mxn], values[mxn];
vector<int> oc[mxn];
void init() {
  for (int i = 0; i < mxn; i++) dp[i] = values[i] = 0;
  for (int i = 0; i < mxn; i++) oc[i].push_back(-1);
}
void add(int &a, int b) { a = a + b >= mod ? a + b - mod : a + b; }
int id(int i) { return i / B; }
struct Bucket {
  int prefix[B];
  int offset;
  Bucket() {
    for (int i = 0; i < B; i++) prefix[i] = 0;
    offset = 0;
  }
  void rebuild(int id) {
    int newoffset = mod;
    int f = id * B, s = (id + 1) * B - 1;
    for (int i = f; i <= s; i++)
      (newoffset) = min((newoffset), (values[i] + offset));
    for (int i = f; i <= s; i++) values[i] += offset - newoffset;
    offset = newoffset;
    for (int i = 0; i < B; i++) prefix[i] = 0;
    for (int i = f; i <= s; i++) add(prefix[values[i]], dp[i]);
    for (int i = 0; i < B; i++)
      if (i) add(prefix[i], prefix[i - 1]);
  }
} b[mxn / B + 1];
void add(int i, int j, int x) {
  for (int k = i; k <= j && id(k) == id(i); k++) values[k] += x;
  b[id(i)].rebuild(id(i));
  if (id(i) == id(j)) return;
  for (int k = id(i) + 1; k < id(j); k++) b[k].offset += x;
  for (int k = j; k >= 0 && id(k) == id(j); k--) values[k] += x;
  b[id(j)].rebuild(id(j));
}
void solve() {
  scanf("%d", &n);
  scanf("%d", &k);
  init();
  dp[0] = 1;
  b[id(0)].rebuild(id(0));
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    a[i]--;
    if (oc[a[i]].size() >= 2)
      add(oc[a[i]].end()[-2] + 1, oc[a[i]].end()[-1], -1);
    add(oc[a[i]].end()[-1] + 1, i, 1);
    dp[i + 1] = 0;
    for (int j = 0; j <= id(i); j++) {
      int x = k - b[j].offset;
      if (x >= 0) add(dp[i + 1], b[j].prefix[min(x, B - 1)]);
    }
    b[id(i + 1)].rebuild(id(i + 1));
    oc[a[i]].push_back(i);
  }
  cout << dp[n] << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
