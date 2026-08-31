#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int grand(int x) { return uniform_int_distribution<int>(0, x - 1)(rng); }
long long getInt() {
  bool minus = false;
  long long result = 0;
  char ch;
  ch = getchar();
  while (true) {
    if (ch == '-') break;
    if (ch >= '0' && ch <= '9') break;
    ch = getchar();
  }
  if (ch == '-')
    minus = true;
  else
    result = ch - '0';
  while (true) {
    ch = getchar();
    if (ch < '0' || ch > '9') break;
    result = result * 10 + (ch - '0');
  }
  if (minus)
    return -result;
  else
    return result;
}
long long gcd(long long x, long long y) {
  if (x < y) return gcd(y, x);
  if (y == 0) return x;
  return gcd(y, x % y);
}
const long long mod = 1e9 + 7;
long long modexp(long long x, long long ex) {
  long long ans = 1ll;
  while (ex > 0) {
    if (ex & 1ll) ans = (ans * x) % mod;
    ex >>= 1ll;
    x = (x * x) % mod;
  }
  return ans;
}
const long long maxn = 1e6 + 7;
const long long N = 1e6 + 7;
const long long inf = 1e151515151515151515151515151515 + 7;
long long srr[N];
long long per[N];
pair<long long, long long> tree[N];
long long lzy[N];
void build(long long nd, long long st, long long en) {
  if (st == en) {
    tree[nd] = {srr[st], -st};
    return;
  }
  long long mid = (st + en) >> 1;
  build(nd + nd, st, mid);
  build(nd + nd + 1, mid + 1, en);
  tree[nd] = min(tree[nd + nd], tree[nd + nd + 1]);
}
inline void push(long long x) {
  if (lzy[x] == 0) return;
  tree[x + x].first += lzy[x];
  tree[x + x + 1].first += lzy[x];
  lzy[x + x] += lzy[x];
  lzy[x + x + 1] += lzy[x];
  lzy[x] = 0;
}
void upd(long long nd, long long st, long long en, long long l, long long r,
         long long val) {
  if (en < l || r < st) return;
  if (l <= st && en <= r) {
    tree[nd].first += val;
    lzy[nd] += val;
    return;
  }
  push(nd);
  long long mid = (st + en) >> 1;
  upd(nd + nd, st, mid, l, r, val);
  upd(nd + nd + 1, mid + 1, en, l, r, val);
  tree[nd] = min(tree[nd + nd], tree[nd + nd + 1]);
}
pair<long long, long long> qry(long long nd, long long st, long long en,
                               long long l, long long r) {
  if (en < l || r < st) return {inf, 0};
  if (l <= st && en <= r) return tree[nd];
  push(nd);
  long long mid = (st + en) >> 1;
  return min(qry(nd + nd, st, mid, l, r), qry(nd + nd + 1, mid + 1, en, l, r));
}
int32_t main() {
  {
    ios ::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
  };
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> srr[i];
  }
  build(1, 1, n);
  for (long long i = 1; i <= n; i++) {
    auto p = qry(1, 1, n, 1, n);
    per[-p.second] = i;
    upd(1, 1, n, -p.second + 1, n, -i);
    upd(1, 1, n, -p.second, -p.second, inf);
  }
  for (long long i = 1; i <= n; i++) {
    cout << per[i] << " ";
  }
  cout << "\n";
}
