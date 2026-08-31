#include <bits/stdc++.h>
using namespace std;
inline long long mod(long long n, long long m) {
  long long ret = n % m;
  if (ret < 0) ret += m;
  return ret;
}
long long gcd(long long a, long long b) {
  return (b == 0LL ? a : gcd(b, a % b));
}
long long exp(long long a, long long b, long long m) {
  if (b == 0LL) return 1LL;
  if (b == 1LL) return mod(a, m);
  long long k = mod(exp(a, b / 2, m), m);
  if (b & 1LL) {
    return mod(a * mod(k * k, m), m);
  } else
    return mod(k * k, m);
}
const long long N = 80;
struct coisa {
  long long a, b, id;
  coisa() {}
  coisa(long long A, long long B, long long C) { a = A, b = B, id = C; }
} v[N];
long long dp[N][N];
long long n, k;
long long solve(long long id, long long j) {
  if (id == n + 1) {
    if (j != k) return -1e9;
    return 0;
  }
  long long& x = dp[id][j];
  if (x != -1) return x;
  long long nao = solve(id + 1, j) + (k - 1) * v[id].b;
  if (j == k) return x = nao;
  long long pega = solve(id + 1, j + 1) + v[id].b * (j) + v[id].a;
  return x = max(pega, nao);
}
vector<long long> tira, col;
void rool(long long id, long long j) {
  if (id == n + 1) return;
  if (j == k) {
    tira.push_back(id);
    rool(id + 1, j);
    return;
  }
  if (solve(id, j) == solve(id + 1, j) + (k - 1) * v[id].b) {
    tira.push_back(id);
    rool(id + 1, j);
    return;
  }
  col.push_back(id);
  rool(id + 1, j + 1);
  return;
}
void solve() {
  cin >> n >> k;
  for (long long i = 1; i <= n; i++) {
    long long a, b;
    cin >> a >> b;
    v[i] = coisa(a, b, i);
  }
  sort(v + 1, v + 1 + n, [&](coisa a, coisa b) { return a.b < b.b; });
  if (k == 1) {
    sort(v + 1, v + 1 + n, [&](coisa a, coisa b) { return a.a > b.a; });
    cout << 1 << "\n";
    cout << v[1].id << "\n";
    return;
  }
  if (k == n) {
    cout << n << "\n";
    for (long long i = 1; i <= n; i++) {
      cout << v[i].id << " ";
    }
    cout << "\n";
    return;
  }
  memset(dp, -1, sizeof(dp));
  tira.clear();
  col.clear();
  rool(1, 0);
  vector<long long> ans;
  for (long long i = 0; i < (long long)col.size() - 1; i++)
    ans.push_back(v[col[i]].id);
  for (long long x : tira) ans.push_back(v[x].id), ans.push_back(-v[x].id);
  if ((long long)col.size() - 1 >= 0)
    ans.push_back(v[col[(long long)col.size() - 1]].id);
  cout << ans.size() << "\n";
  for (long long x : ans) cout << x << " ";
  cout << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long t;
  cin >> t;
  while (t--) {
    solve();
  }
}
