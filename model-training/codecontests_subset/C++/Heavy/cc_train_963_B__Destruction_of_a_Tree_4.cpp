#include <bits/stdc++.h>
using namespace std;
vector<long long> v[200000];
vector<long long> w;
long long f[200000];
stack<long long> s;
void dfs(long long x, long long p) {
  for (auto y : v[x])
    if (y != p) dfs(y, x);
  if (f[x] % 2 == 0) {
    w.push_back(x + 1), f[x] = 0;
    for (auto y : v[x]) f[y]--;
  } else
    s.push(x + 1);
}
int main() {
  long long n, i, x;
  memset(f, 0, sizeof(f));
  scanf("%lld", &n);
  for (i = 0; i <= n - 1; i++) {
    scanf("%lld", &x);
    if (x != 0) x--, v[x].push_back(i), v[i].push_back(x), f[x]++, f[i]++;
  }
  dfs(0, -1);
  if (f[0] % 2 == 1)
    printf("NO\n");
  else {
    printf("YES\n");
    for (auto x : w) printf("%lld\n", x);
    while (!s.empty()) printf("%lld\n", s.top()), s.pop();
  }
}
