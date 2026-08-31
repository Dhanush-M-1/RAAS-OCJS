#include <bits/stdc++.h>
using namespace std;
long long ok[1000009], n, m, num[1000009], did, siz, u, v, p[1000009];
vector<long long> vec[1000009];
void solve() {
  for (long long i = n - 1; i > 0; i--) {
    if (ok[p[i]] and num[p[i]] + did == n - i - 1)
      did++;
    else {
      siz = vec[p[i]].size();
      for (long long j = 0; j < siz; j++) num[vec[p[i]][j]]++;
    }
  }
  cout << did << endl;
}
int main() {
  cin >> n >> m;
  for (long long i = 1; i <= n; i++) scanf("%lld", &p[i]);
  for (long long i = 1; i <= m; i++) {
    scanf("%lld", &u);
    scanf("%lld", &v);
    vec[v].push_back(u);
    if (v == p[n]) ok[u] = 1;
  }
  solve();
  return 0;
}
