#include <bits/stdc++.h>
using namespace std;
const long long LIM = 1e18;
const int MAXN = 1e5;
int N;
bool possible = true;
long long A[MAXN], B[MAXN];
vector<pair<int, int> > T[MAXN];
void dfs(int v) {
  for (int i = 0; i < (int)T[v].size(); i++) {
    int u = T[v][i].first;
    int c = T[v][i].second;
    dfs(u);
    if (B[u] >= A[u])
      B[v] += B[u] - A[u];
    else if (A[u] - B[u] > (double)LIM / c)
      possible = false;
    else if (B[v] < -LIM + (A[u] - B[u]) * c)
      possible = false;
    else
      B[v] -= (A[u] - B[u]) * c;
  }
}
int main() {
  scanf("%d", &N);
  for (int i = 0; i < (int)N; i++) scanf("%lld", &B[i]);
  for (int i = 0; i < (int)N; i++) scanf("%lld", &A[i]);
  for (int i = 1; i < (int)N; i++) {
    int p, c;
    scanf("%d", &p), scanf("%d", &c);
    T[p - 1].push_back({i, c});
  }
  dfs(0);
  printf("%s\n", B[0] >= A[0] && possible ? "YES" : "NO");
}
