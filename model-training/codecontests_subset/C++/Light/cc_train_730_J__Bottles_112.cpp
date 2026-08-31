#include <bits/stdc++.h>
using namespace std;
const int N = 1e2 + 5;
struct node {
  int a, b;
} c[N];
int n, ans, suma, sumb, k = 0, f[N * N][N];
bool cmp(node x, node y) { return x.b > y.b; }
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> c[i].a;
    suma += c[i].a;
  }
  for (int i = 1; i <= n; i++) {
    cin >> c[i].b;
  }
  sort(c + 1, c + n + 1, cmp);
  while (sumb < suma) sumb += c[++k].b;
  cout << k << " ";
  memset(f, 128, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++)
    for (int j = sumb; j >= c[i].b; j--)
      for (int kk = 1; kk <= k; kk++) {
        f[j][kk] = max(f[j][kk], f[j - c[i].b][kk - 1] + c[i].a);
      }
  for (int i = suma; i <= sumb; i++) ans = max(ans, f[i][k]);
  cout << suma - ans;
  return 0;
}
