#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  while (b) {
    int c = a % b;
    a = b;
    b = c;
  }
  return a;
}
pair<int, int> F(int n) {
  int m = 0;
  for (int i = n; i; i /= 10) m = m * 10 + i % 10;
  int d = gcd(n, m);
  return pair<int, int>(n / d, m / d);
}
const int N = 100000 + 10;
pair<int, int> a[N], b[N];
int main() {
  int n, m, w;
  scanf("%d %d %d", &n, &m, &w);
  map<pair<int, int>, int> A, B;
  for (int i = 1; i < N; ++i) {
    a[i] = F(i);
    b[i] = pair<int, int>(a[i].second, a[i].first);
  }
  int i = 1, j;
  int cnt = 0;
  for (j = 1; j <= m; ++j) B[a[j]]++;
  for (i = 1; i <= n; ++i) {
    A[a[i]]++;
    cnt += B[b[i]];
    if (cnt >= w) break;
  }
  if (cnt < w) {
    puts("-1");
    return 0;
  }
  j = m;
  while (true) {
    if (cnt - A[b[j]] < w) break;
    cnt -= A[b[j]];
    B[a[j]]--;
    --j;
  }
  int ret = i * j;
  int ret_i = i, ret_j = j;
  for (++i; i <= n; ++i) {
    A[a[i]]++;
    cnt += B[b[i]];
    while (true) {
      if (cnt - A[b[j]] < w) break;
      cnt -= A[b[j]];
      B[a[j]]--;
      --j;
    }
    if (i * j < ret) {
      ret = i * j;
      ret_i = i;
      ret_j = j;
    }
  }
  printf("%d %d\n", ret_i, ret_j);
  return 0;
}
