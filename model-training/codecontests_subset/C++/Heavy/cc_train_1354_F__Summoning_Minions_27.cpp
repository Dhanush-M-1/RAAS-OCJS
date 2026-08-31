#include <bits/stdc++.h>
using namespace std;
const long long N = 105;
long long n, k;
struct P {
  long long x, y, id;
} a[N];
long long f[N][N], g[N][N];
bool maximize(long long &x, long long y) {
  if (x < y) {
    x = y;
    return true;
  }
  return false;
}
void Main() {
  cin >> n >> k;
  for (long long i = 1, __c = n; i <= __c; ++i)
    cin >> a[i].x >> a[i].y, a[i].id = i;
  memset(f, -1, sizeof(f));
  memset(g, 0, sizeof(g));
  sort(a + 1, a + n + 1, [](P x, P y) { return x.y < y.y; });
  f[0][0] = 0;
  for (long long i = 0, __c = n - 1; i <= __c; ++i) {
    for (long long j = 0, __c = k; j <= __c; ++j)
      if (f[i][j] != -1) {
        if (maximize(f[i + 1][j], f[i][j] + (k - 1) * a[i + 1].y))
          g[i + 1][j] = 1;
        if (j < k)
          if (maximize(f[i + 1][j + 1], f[i][j] + j * a[i + 1].y + a[i + 1].x))
            g[i + 1][j + 1] = 2;
      }
  }
  vector<long long> pa;
  vector<long long> nope;
  long long now = k;
  for (long long i = n, __c = 1; i >= __c; --i) {
    if (g[i][now] == 2)
      pa.push_back(a[i].id), now--;
    else
      nope.push_back(a[i].id);
  }
  reverse(begin(pa), end(pa));
  now = pa.back();
  pa.pop_back();
  for (auto &i : nope) pa.push_back(i), pa.push_back(-i);
  pa.push_back(now);
  cout << pa.size() << '\n';
  for (auto &v : pa) cout << v << ' ';
  cout << '\n';
}
int32_t main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  if (fopen("TASK"
            ".inp",
            "r"))
    freopen(
        "TASK"
        ".inp",
        "r", stdin);
  long long T;
  cin >> T;
  for (long long _ = 1, __c = T; _ <= __c; ++_) {
    Main();
  }
}
