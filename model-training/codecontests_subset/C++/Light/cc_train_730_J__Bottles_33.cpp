#include <bits/stdc++.h>
using namespace std;
struct node {
  int a, b;
} c[101];
bool cmp(node x, node y) { return x.b > y.b; }
int n, suma, sumb, num, ans, f[101][10001];
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
  while (sumb < suma) sumb += c[++num].b;
  cout << num << " ";
  memset(f, 128, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sumb; j >= c[i].b; j--) {
      for (int k = 1; k <= num; k++) {
        f[k][j] = max(f[k][j], f[k - 1][j - c[i].b] + c[i].a);
      }
    }
  }
  for (int i = suma; i <= sumb; i++) {
    ans = max(ans, f[num][i]);
  }
  cout << suma - ans;
  return 0;
}
