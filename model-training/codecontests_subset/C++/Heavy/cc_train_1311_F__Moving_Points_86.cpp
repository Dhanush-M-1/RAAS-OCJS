#include <bits/stdc++.h>
using namespace std;
long long read() {
  long long a = 0, b = getchar(), c = 1;
  while (!isdigit(b)) c = b == '-' ? -1 : 1, b = getchar();
  while (isdigit(b)) a = a * 10 + b - '0', b = getchar();
  return a * c;
}
long long n, ans, p[200005];
pair<long long, long long> a[200005];
int main() {
  n = read();
  for (int i = 1; i <= n; i++) {
    a[i].second = read();
    p[i] = a[i].second;
  }
  for (int i = 1; i <= n; i++) a[i].first = read();
  sort(a + 1, a + n + 1);
  sort(p + 1, p + n + 1);
  for (int i = 1; i <= n; i++)
    ans += (lower_bound(p + 1, p + n + 1, a[i].second) - p - n + i - 1) *
           a[i].second;
  cout << ans;
  return 0;
}
