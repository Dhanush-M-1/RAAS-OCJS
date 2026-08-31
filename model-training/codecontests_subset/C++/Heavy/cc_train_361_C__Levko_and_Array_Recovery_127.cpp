#include <bits/stdc++.h>
using namespace std;
long long delta[5010], upper[5010];
int o[5010][4];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) {
    delta[i] = 0;
    upper[i] = 1000000000;
  }
  for (int i = 0; i < m; ++i) {
    for (int j = 0; j < 4; ++j) cin >> o[i][j];
    if (o[i][0] == 1) {
      for (int j = o[i][1]; j <= o[i][2]; ++j) delta[j] += o[i][3];
    } else {
      for (int j = o[i][1]; j <= o[i][2]; ++j)
        upper[j] = min(upper[j], o[i][3] - delta[j]);
    }
  }
  for (int i = 1; i <= n; ++i) delta[i] = upper[i];
  bool fail = false;
  for (int i = 0; !fail && i < m; ++i) {
    if (o[i][0] == 1) {
      for (int j = o[i][1]; j <= o[i][2]; ++j) delta[j] += o[i][3];
    } else {
      bool succ = false;
      for (int j = o[i][1]; !succ && j <= o[i][2]; ++j)
        if (delta[j] == o[i][3]) succ = true;
      if (!succ) fail = true;
    }
  }
  if (fail)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    for (int i = 1; i < n; ++i) cout << upper[i] << " ";
    cout << upper[n] << endl;
  }
  return 0;
}
