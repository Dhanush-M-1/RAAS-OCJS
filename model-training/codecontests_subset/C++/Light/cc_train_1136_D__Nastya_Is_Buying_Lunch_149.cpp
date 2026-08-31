#include <bits/stdc++.h>
using namespace std;
int n, i, j, m, k, l, h, g, ye, a, b, rez;
int p[300005], f[300005], ct[300005];
int v[300005], nv;
bool comp(int x, int y) { return f[x] < f[y]; }
int main() {
  cin >> n >> m;
  for (i = 1; i <= n; i++) cin >> p[i], f[p[i]] = i;
  ye = p[n];
  for (i = 1; i <= m; i++) {
    cin >> a >> b;
    if (f[a] < f[b]) ct[a]++;
    if (b == p[n]) v[++nv] = a;
  }
  sort(v + 1, v + nv + 1, comp);
  for (i = nv; i >= 1; i--) {
    if (ct[v[i]] >= (n - f[v[i]]) - rez) rez++;
  }
  cout << rez << "\n";
}
