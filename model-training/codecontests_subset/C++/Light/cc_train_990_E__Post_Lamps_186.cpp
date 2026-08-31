#include <bits/stdc++.h>
using namespace std;
const long long inf = 1000000000000000000;
long long n, m, k;
vector<long long> dop;
void init(long long n) { dop.resize(n + 1); }
long long get(long long k) {
  long long l = 0, alr = 0, last = -1;
  while (l < n) {
    if (dop[l] <= last) return inf;
    last = dop[l];
    l = last + k;
    alr++;
  }
  return alr;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  init(n);
  vector<char> v(n + 1, true);
  vector<long long> money(k);
  for (long long c = 0; c < m; c++) {
    long long e;
    cin >> e;
    v[e] = false;
  }
  if (!v[0]) {
    cout << -1;
    return 0;
  }
  dop[0] = 0;
  for (long long c = 1; c <= n; c++) {
    if (v[c])
      dop[c] = c;
    else
      dop[c] = dop[c - 1];
  }
  for (long long c = 0; c < k; c++) cin >> money[c];
  long long mmin = inf;
  for (long long c = 1; c <= k; c++) {
    long long now = get(c);
    if (now == inf) continue;
    mmin = min(mmin, now * money[c - 1]);
  }
  cout << (mmin == inf ? -1 : mmin);
  return 0;
}
