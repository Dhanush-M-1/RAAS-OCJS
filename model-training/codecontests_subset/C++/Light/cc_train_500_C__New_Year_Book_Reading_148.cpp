#include <bits/stdc++.h>
using namespace std;
int n, m;
int d[1005];
int w[506];
int ans[503];
signed long long int cost(int up, int dow) {
  signed long long int r = 0;
  for (int i = 1; i <= m; ++i) {
    if (d[i] == dow) {
      r += w[up];
      swap(up, dow);
    }
  }
  return r;
}
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) cin >> w[i], ans[i] = i;
  for (int i = 1; i <= m; ++i) cin >> d[i];
  for (int i = 1; i <= n; ++i) {
    for (int j = i + 1; j <= n; ++j) {
      if (cost(ans[i], ans[j]) > cost(ans[j], ans[i])) {
        swap(ans[i], ans[j]);
      }
    }
  }
  signed long long int f = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = i + 1; j <= n; ++j) {
      f += cost(ans[i], ans[j]);
    }
  }
  cout << f;
}
