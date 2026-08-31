#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100000 + 10;
const long long inf = 100000000000000000ll;
int n;
long long a[MAX_N], b[MAX_N];
vector<pair<int, int> > G[MAX_N];
int degree[MAX_N];
long long dfs(int u, long long ratio = 1) {
  long long kilograms = b[u] - a[u];
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i].first;
    long long Ratio = G[u][i].second;
    kilograms += dfs(v, Ratio);
    if (kilograms <= -inf || kilograms >= inf) {
      printf("NO\n");
      exit(0);
    }
  }
  if (kilograms >= 0) {
    return kilograms;
  } else {
    kilograms *= -1ll;
    if (kilograms >= inf / ratio) {
      printf("NO\n");
      exit(0);
    }
    kilograms = kilograms * ratio * -1ll;
    if (kilograms <= -inf) {
      printf("NO\n");
      exit(0);
    }
    return kilograms;
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &b[i]);
  }
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
  }
  for (int i = 2; i <= n; i++) {
    int x, k;
    scanf("%d%d", &x, &k);
    G[x].push_back(pair<int, int>(i, k));
    degree[i]++;
  }
  for (int i = 1; i <= n; i++)
    if (degree[i] == 0) {
      if (dfs(i) < 0) {
        printf("NO\n");
        exit(0);
      }
    }
  printf("YES\n");
}
