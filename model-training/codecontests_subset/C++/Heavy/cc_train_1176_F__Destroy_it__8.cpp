#include <bits/stdc++.h>
using namespace std;
long long f[10];
long long nf[10];
int w[4][4];
int main() {
  int n;
  scanf("%d", &n);
  memset(f, -1, sizeof f);
  f[0] = 0;
  for (int it = 0; it < n; ++it) {
    int m;
    scanf("%d", &m);
    memset(w, 0, sizeof w);
    while (m--) {
      int x, y;
      scanf("%d%d", &x, &y);
      w[x][3] = -y;
      sort(w[x], w[x] + 4);
    }
    memcpy(nf, f, sizeof nf);
    for (int i = 0; i < 10; ++i) {
      if (f[i] == -1) {
        continue;
      }
      for (int a = 0; a <= 3; ++a) {
        for (int b = 0; a + b * 2 <= 3; ++b) {
          for (int c = 0; a + b * 2 + c * 3 <= 3; ++c) {
            vector<int> cur;
            for (int j = 0; j < a; ++j) {
              if (w[1][j] < 0) {
                cur.push_back(w[1][j]);
              }
            }
            for (int j = 0; j < b; ++j) {
              if (w[2][j] < 0) {
                cur.push_back(w[2][j]);
              }
            }
            for (int j = 0; j < c; ++j) {
              if (w[3][j] < 0) {
                cur.push_back(w[3][j]);
              }
            }
            if ((int)cur.size() == a + b + c) {
              sort(cur.begin(), cur.end());
              long long sum = 0;
              for (int e : cur) {
                sum -= e;
              }
              int ni = i + a + b + c;
              if (ni >= 10) {
                sum -= cur[0];
              }
              nf[ni % 10] = max(nf[ni % 10], f[i] + sum);
            }
          }
        }
      }
    }
    memcpy(f, nf, sizeof f);
  }
  long long ans = 0;
  for (int i = 0; i < 10; ++i) {
    ans = max(ans, f[i]);
  }
  printf("%lld\n", ans);
}
