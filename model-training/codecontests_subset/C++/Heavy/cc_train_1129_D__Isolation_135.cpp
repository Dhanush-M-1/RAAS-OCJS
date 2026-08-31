#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int N = 2e5 + 5;
const int M = 505;
const ll mod = 998244353;
ll add(ll a, ll b) { return (a + b >= mod ? a + b - mod : a + b); }
ll sub(ll a, ll b) { return (a - b < 0 ? a - b + mod : a - b); }
ll mul(ll a, ll b) { return (a * b) % mod; }
int n, k;
int a[N];
int last[N], preLast[N];
ll dp[N];
int inDex[N], head[M];
int magic;
struct block {
  int sz;
  int Min, Max;
  int lazy;
  int bad[M];
  ll val[M], sum[M];
  void init(int n) {
    sz = n;
    Min = Max = 0;
    for (int i = 0; i <= sz; i++) {
      val[i] = bad[i] = sum[i] = 0;
    }
  }
  void updAll(int x) {
    lazy += x;
    Min += x;
    Max += x;
  }
  void upd(int l, int r, int x) {
    for (int i = 0; i < sz; i++) bad[i] += lazy;
    for (int i = l; i <= r; i++) bad[i] += x;
    lazy = 0;
    Min = 1e9;
    Max = -1e9;
    for (int i = 0; i < sz; i++) {
      Min = min(Min, bad[i]);
      Max = max(Max, bad[i]);
    }
    for (int i = 0; i <= Max - Min; i++) sum[i] = 0;
    for (int i = 0; i < sz; i++) {
      sum[bad[i] - Min] = add(sum[bad[i] - Min], val[i]);
    }
    for (int i = 1; i <= Max - Min; i++) {
      sum[i] = add(sum[i], sum[i - 1]);
    }
  }
  void active(int id, ll x) {
    val[id] = x;
    for (int i = bad[id] - Min; i <= Max - Min; i++) {
      sum[i] = add(sum[i], x);
    }
  }
  ll get(int x) {
    if (Min > x) return 0;
    if (Max < x) return sum[Max - Min];
    return sum[x - Min];
  }
} block[M];
void update(int l, int r, ll x) {
  int L = inDex[l], R = inDex[r];
  if (L == R) {
    block[L].upd(l - head[L], r - head[L], x);
    return;
  }
  block[L].upd(l - head[L], head[L + 1] - head[L] - 1, x);
  block[R].upd(0, r - head[R], x);
  for (int i = L + 1; i < R; i++) {
    block[i].updAll(x);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    preLast[i] = -1;
  }
  magic = sqrt(n);
  int now = 1, cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (head[now] == 0) head[now] = i;
    inDex[i] = now;
    cnt++;
    if (cnt == magic || i == n) {
      block[now].init(i - head[now] + 1);
      now++;
      cnt = 0;
    }
  }
  head[now] = n + 1;
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    update(last[a[i]] + 1, i, 1);
    if (preLast[a[i]] != -1) {
      update(preLast[a[i]] + 1, last[a[i]], -1);
    }
    preLast[a[i]] = last[a[i]];
    last[a[i]] = i;
    block[inDex[i]].active(i - head[inDex[i]], dp[i - 1]);
    for (int j = 1; j <= inDex[i]; j++) {
      dp[i] = add(dp[i], block[j].get(k));
    }
  }
  cout << dp[n];
}
