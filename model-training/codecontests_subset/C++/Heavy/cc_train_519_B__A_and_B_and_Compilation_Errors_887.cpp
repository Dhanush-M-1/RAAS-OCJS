#include <bits/stdc++.h>
using namespace std;
int di[] = {0, 1, 0, -1};
int dj[] = {1, 0, -1, 0};
int dik[] = {1, 1, 2, 2, -1, -1, -2, -2};
int djk[] = {2, -2, 1, -1, -2, 2, -1, 1};
long long gcd(long long x, long long y) { return !y ? x : gcd(y, x % y); }
int main() {
  int n, a, b;
  cin >> n, a = b = -1;
  vector<int> x(n), y(n - 1), z(n - 2);
  for (int i = 0; i < int(n); i++) scanf("%d", &x[i]);
  for (int i = 0; i < int(n - 1); i++) scanf("%d", &y[i]);
  for (int i = 0; i < int(n - 2); i++) scanf("%d", &z[i]);
  sort(x.begin(), x.end()), sort(y.begin(), y.end()), sort(z.begin(), z.end());
  for (int i = 0; i < int(n - 1); i++)
    if (x[i] != y[i]) {
      a = x[i];
      break;
    }
  if (a == -1) a = x.back();
  for (int i = 0; i < int(n - 2); i++)
    if (y[i] != z[i]) {
      b = y[i];
      break;
    }
  if (b == -1) b = y.back();
  printf("%d\n%d\n", a, b);
  return 0;
}
