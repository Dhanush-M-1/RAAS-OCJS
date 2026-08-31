#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000008;
const long long oo = 1LL << 50;
bool blocked[MAXN];
long long prices[MAXN];
int lastfree[2 * MAXN];
vector<pair<long long, long long> > estimates;
int main() {
  int n, m, k;
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 0; i < n; i++) {
    blocked[i] = false;
  }
  int x;
  for (int i = 0; i < m; i++) {
    scanf("%d", &x);
    blocked[x] = true;
  }
  int mxbl = 0, cbl = 0;
  int lstf = 0;
  for (int i = 0; i < n; i++) {
    if (blocked[i]) {
      cbl++;
      mxbl = max(mxbl, cbl);
    } else {
      cbl = 0;
      lstf = i;
    }
    lastfree[i] = lstf;
  }
  for (int i = n; i < 2 * n; i++) {
    lastfree[i] = i;
  }
  for (int i = 1; i <= k; i++) {
    scanf("%lld", &prices[i]);
  }
  if (blocked[0] || mxbl >= k) {
    printf("-1\n");
    return 0;
  }
  long long minpr = oo;
  for (int i = k; i > mxbl; i--) {
    if (prices[i] > minpr) continue;
    minpr = prices[i];
    long long epr = (n + i - 1) / i * prices[i];
    estimates.push_back(make_pair(epr, i));
  }
  sort(estimates.begin(), estimates.end());
  long long minres = oo;
  for (unsigned i = 0; i < estimates.size(); i++) {
    if (estimates[i].first >= minres) break;
    int clamp = estimates[i].second;
    int cpos = 0;
    long long cpr = 0;
    while (cpos < n) {
      cpr += prices[clamp];
      cpos = lastfree[cpos + clamp];
    }
    minres = min(minres, cpr);
  }
  printf("%lld\n", minres);
  return 0;
}
