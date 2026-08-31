#include <bits/stdc++.h>
using namespace std;
const int NMAX = 505;
int n, m, cost[NMAX], b[NMAX * 2], perm[NMAX];
bitset<NMAX> viz;
long long sol;
int main() {
  int i, j, aux, poz;
  cin.sync_with_stdio(false);
  cin >> n >> m;
  for (i = 1; i <= n; i++) cin >> cost[i];
  for (i = 1; i <= m; i++) {
    cin >> b[i];
    if (!viz[b[i]]) {
      viz[b[i]] = 1;
      perm[++perm[0]] = b[i];
    }
  }
  aux = n / 2;
  for (i = 1; i <= aux; i++) swap(perm[i], perm[n - i + 1]);
  for (i = 1; i <= m; i++) {
    for (j = 1; j <= n; j++)
      if (perm[j] == b[i]) {
        poz = j;
        j = n + 1;
      }
    for (j = poz + 1; j <= n; j++) {
      sol += cost[perm[j]];
      swap(perm[j], perm[j - 1]);
    }
  }
  cout << sol << "\n";
  return 0;
}
