#include <bits/stdc++.h>
using namespace std;
long long D[2][10];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ((void)0);
  ((void)0);
  ((void)0);
  int N;
  long long ans = 0;
  memset(D, -1, sizeof(D));
  cin >> N;
  D[0][0] = 0;
  for (int i = 1; i <= N; i++) {
    int k, p;
    long long q, a1 = -1, a2 = -1, a3 = -1, b = -1, c = -1, t31 = -1, t32 = -1,
                 t21 = -1, t22 = -1, t1 = -1;
    for (int j = 0; j < 10; j++) D[i & 1][j] = -1;
    for (cin >> k; k--;) {
      cin >> p >> q;
      if (p == 1) {
        if (a1 < q) {
          a3 = a2;
          a2 = a1;
          a1 = q;
        } else if (a2 < q) {
          a3 = a2;
          a2 = q;
        } else if (a3 < q)
          a3 = q;
      } else if (p == 2)
        b = max(b, q);
      else
        c = max(c, q);
    }
    if (a3 != -1) {
      t31 = a1 + a2 + a3;
      t32 = t31 + max({a1, a2, a3});
    }
    if (a1 != -1 && b != -1) {
      t21 = a1 + b;
      t22 = t21 + max(a1, b);
    }
    if (a2 != -1) {
      t21 = max(t21, a1 + a2);
      t22 = max(t22, a1 + a2 + max(a1, a2));
    }
    t1 = max({a1, b, c});
    for (int j = 0; j < 10; j++)
      if (D[(i - 1) & 1][j] != -1) {
        D[i & 1][j] = max(D[i & 1][j], D[(i - 1) & 1][j]);
        D[i & 1][(j + 1) % 10] = max(D[i & 1][(j + 1) % 10],
                                     D[(i - 1) & 1][j] + (j == 9 ? 2 : 1) * t1);
        if (t21 != -1)
          D[i & 1][(j + 2) % 10] = max(
              D[i & 1][(j + 2) % 10], D[(i - 1) & 1][j] + (j >= 8 ? t22 : t21));
        if (t31 != -1)
          D[i & 1][(j + 3) % 10] = max(
              D[i & 1][(j + 3) % 10], D[(i - 1) & 1][j] + (j >= 7 ? t32 : t31));
      }
  }
  for (int i = 0; i < 10; i++) ans = max(ans, D[N & 1][i]);
  cout << ans << '\n';
  return 0;
}
