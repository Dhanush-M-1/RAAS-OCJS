#include <bits/stdc++.h>
using namespace std;
int f[1005], v[1005], pr[1005], x, cc = 0, cont = 0, cate[1005], contor = 0,
                                   sume[1005], sumi, rucsac[1005];
void dfs(int nod) {
  if (v[nod] != 0) {
    pr[v[nod]] = nod;
    if (f[v[nod]] == 0) {
      f[v[nod]] = 1;
      dfs(v[nod]);
    }
  }
}
void anti_dfs(int nod) {
  if (nod == 0) {
    return;
  }
  if (nod == x) cc = 1;
  cont++;
  anti_dfs(pr[nod]);
  cate[nod] = cate[pr[nod]] + 1;
}
int main() {
  int n;
  cin >> n >> x;
  for (int i = 1; i <= n; i++) {
    cin >> v[i];
  }
  for (int i = 1; i <= n; i++) {
    if (v[i] != 0 and f[i] == 0) {
      f[i] = 1;
      dfs(i);
    }
  }
  for (int i = 1; i <= n; i++) {
    if (v[i] == 0) {
      anti_dfs(i);
      if (cc == 1) {
        sumi = cate[i] - cate[x] + 1;
      } else {
        sume[++contor] = cate[i];
      }
      cc = 0;
      cont = 0;
    }
  }
  rucsac[0] = 1;
  for (int i = 1; i <= contor; i++) {
    for (int j = n; j >= 0; j--) {
      if (rucsac[j] == 1) {
        rucsac[j + sume[i]] = 1;
      }
    }
  }
  for (int i = 0; i <= n; i++) {
    if (rucsac[i] == 1) {
      cout << i + sumi << "\n";
    }
  }
  return 0;
}
