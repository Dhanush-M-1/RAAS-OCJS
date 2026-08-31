#include <bits/stdc++.h>
using namespace std;
bool debug = 1;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
long long ln, lk, lm;
int a[105];
int main() {
  scanf("%d%d", &n, &m);
  for (int(i) = 1; (i) <= (int)(n); (i)++) scanf("%d", a + i);
  for (int(i) = 1; (i) <= (int)(n - 1); (i)++) {
    k = max(k, a[i] - a[i + 1]);
  }
  k -= m;
  printf("%d\n", max(k, 0));
  return 0;
}
