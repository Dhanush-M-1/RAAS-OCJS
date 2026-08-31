#include <bits/stdc++.h>
using namespace std;
const int N = 10005;
int n;
pair<int, int> memo[105][2 * N + 10];
int a[N], b[N];
pair<int, int> dp(int i, int l) {
  if (i == n) return (l <= N ? pair<int, int>(0, 0) : pair<int, int>(n, N));
  if (memo[i][l].first != -1) return memo[i][l];
  pair<int, int> r = dp(i + 1, l + a[i]);
  r.second += a[i];
  pair<int, int> p = dp(i + 1, l - b[i] + a[i]);
  p.first++;
  if (p.first == r.first) r.second = min(r.second, p.second);
  if (p.first < r.first) swap(p, r);
  return memo[i][l] = r;
}
int main() {
  scanf("%d", &n);
  for (int i = 0, qwer = n; i < qwer; i++) scanf("%d", a + i);
  for (int i = 0, qwer = n; i < qwer; i++) scanf("%d", b + i);
  memset(memo, -1, sizeof memo);
  pair<int, int> k = dp(0, N);
  printf("%d %d\n", k.first, k.second);
  return 0;
}
