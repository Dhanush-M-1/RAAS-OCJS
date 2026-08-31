#include <bits/stdc++.h>
using namespace std;
void print(vector<int>& a) {
  for (int i = 0; i < (int)a.size(); ++i) printf("%d ", a[i]);
  puts("");
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  vector<int> a(n, 1000000000), v(n, 0);
  vector<vector<int> > qur(m, vector<int>(4));
  for (int i = 0; i < m; ++i) {
    for (int j = 0; j < 4; ++j) {
      scanf("%d", &qur[i][j]);
    }
    for (int k = qur[i][1] - 1; k < qur[i][2]; ++k) {
      if (qur[i][0] == 1)
        v[k] += qur[i][3];
      else {
        a[k] = min(a[k], qur[i][3] - v[k]);
      }
    }
  }
  fill(v.begin(), v.end(), 0);
  for (int i = 0; i < m; ++i) {
    bool ok = false;
    for (int k = qur[i][1] - 1; k < qur[i][2]; ++k) {
      if (qur[i][0] == 1)
        v[k] += qur[i][3];
      else {
        if (a[k] + v[k] == qur[i][3]) ok = true;
      }
    }
    if (qur[i][0] == 2 && !ok) {
      puts("NO");
      return 0;
    }
  }
  puts("YES");
  print(a);
  return 0;
}
