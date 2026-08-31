#include <bits/stdc++.h>
using namespace std;
long long i, i1, j, k, k1, t, n, m, res, flag[10], a, b, mt[210][210], f[210];
char x;
vector<array<long long, 2>> sl;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> t;
  while (t--) {
    cin >> n;
    sl.clear();
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= n; j++) {
        cin >> x;
        if (x == '1')
          mt[i][j] = 1;
        else
          mt[i][j] = 0;
      }
    }
    mt[1][2] ^= 1;
    mt[2][1] ^= 1;
    f[0] = 0;
    f[1] = 0;
    long long d1[5] = {1, 2, 1, 2, 3};
    long long d2[5] = {2, 1, 3, 2, 1};
    for (i = 0; i < 5; i++) {
      f[mt[d1[i]][d2[i]]]++;
    }
    for (i = 0; i < 5; i++) {
      if (f[mt[d1[i]][d2[i]]] <= 2) sl.push_back({d1[i], d2[i]});
    }
    cout << sl.size() << "\n";
    for (auto u : sl) cout << u[0] << ' ' << u[1] << "\n";
  }
  return 0;
}
