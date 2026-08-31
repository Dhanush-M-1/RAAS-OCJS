#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
double fRand(double fMin, double fMax) {
  double f = (double)rand() / RAND_MAX;
  return fMin + f * (fMax - fMin);
}
template <class T>
T min(T a, T b, T c) {
  return min(a, min(b, c));
}
template <class T>
T max(T a, T b, T c) {
  return max(a, max(b, c));
}
bool overflow(long long a, long long b) {
  return (a > 1000000000000000007LL / b);
}
int n;
long long a[100005], b[100005], dp[100005];
vector<pair<int, int> > g[100005];
void DFS(int u) {
  dp[u] = a[u] - b[u];
  for (pair<int, int> p : g[u]) {
    int v = p.first, k = p.second;
    DFS(v);
    if (dp[v] > 0) dp[u] += dp[v];
    if (dp[v] < 0) {
      if (overflow(-dp[v], k) || dp[u] + dp[v] * k < -1000000000000000007LL) {
        puts("NO");
        exit(0);
      }
      dp[u] += dp[v] * k;
    }
  }
}
int main() {
  scanf("%d", &n);
  for (int i = (1); i <= (n); ++i) scanf("%lld", &a[i]);
  for (int i = (1); i <= (n); ++i) scanf("%lld", &b[i]);
  for (int i = (2); i <= (n); ++i) {
    int x, k;
    scanf("%d%d", &x, &k);
    g[x].push_back(make_pair(i, k));
  }
  DFS(1);
  puts((dp[1] >= 0) ? "YES" : "NO");
  return 0;
}
