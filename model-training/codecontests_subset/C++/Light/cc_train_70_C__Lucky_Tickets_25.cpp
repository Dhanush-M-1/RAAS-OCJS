#include <bits/stdc++.h>
using namespace std;
int n, m, w, x = -1, y, tot;
long long ans = (long long)1e18;
map<pair<int, int>, int> A, B;
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
pair<int, int> caln_A(int x) {
  int k = x, rev = 0;
  while (x > 0) {
    rev = rev * 10 + x % 10;
    x /= 10;
  }
  int d = gcd(k, rev);
  k /= d;
  rev /= d;
  return make_pair(k, rev);
}
pair<int, int> caln_B(int x) {
  pair<int, int> now = caln_A(x);
  swap(now.first, now.second);
  return now;
}
int main() {
  int j = 0;
  tot = 0;
  scanf("%d%d%d", &n, &m, &w);
  for (int i = 1; i <= n; i++) A[caln_A(i)]++;
  for (int i = n; i >= 1; i--) {
    while (tot < w && j < m) {
      j++;
      pair<int, int> now = caln_B(j);
      B[now]++;
      tot += A[now];
    }
    if (tot < w) continue;
    if ((long long)i * j <= ans) ans = (long long)i * j, x = i, y = j;
    pair<int, int> now = caln_A(i);
    tot -= B[now];
    A[now]--;
  }
  if (x == -1)
    printf("-1\n");
  else
    printf("%d %d\n", x, y);
}
