#include <bits/stdc++.h>
using namespace std;
const int MAXK = 1000000;
const int MAXN = 1000000;
bool B[1 + MAXN];
int n, F[1 + MAXN];
long long C[1 + MAXK];
vector<pair<long long, int>> L;
long long cost(int l) {
  int x = 0;
  long long c = 0;
  while (x < n) {
    x = F[x];
    c += C[l];
    x += l;
  }
  return c;
}
int main() {
  int a, k, m;
  scanf("%d %d %d", &n, &m, &k);
  while (m--) {
    scanf("%d", &a);
    B[a] = true;
  }
  if (B[0]) {
    puts("-1");
    return 0;
  }
  for (int i = 1; i <= k; ++i) {
    scanf("%lld", C + i);
  }
  m = 0;
  a = B[0];
  for (int i = 1; i <= n; ++i) {
    if (B[i]) {
      ++a;
    } else {
      m = max(m, a);
      a = 0;
    }
  }
  m = max(m, a);
  if (k <= m) {
    puts("-1");
    return 0;
  }
  for (int i = 0; i <= n; ++i) {
    F[i] = i;
  }
  for (int i = 1; i <= n; ++i) {
    if (B[i]) {
      F[i] = F[i - 1];
    }
  }
  for (int i = m + 1; i <= k; ++i) {
    int j = n / i + !!(n % i);
    L.push_back({j * C[i], i});
  }
  sort(L.begin(), L.end());
  long long b = cost(L[0].second);
  for (int i = 1; i < (int)L.size() && L[i].first < b; ++i) {
    long long c = cost(L[i].second);
    b = min(b, c);
  }
  printf("%lld\n", b);
  return 0;
}
