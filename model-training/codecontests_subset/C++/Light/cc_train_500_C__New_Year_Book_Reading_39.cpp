#include <bits/stdc++.h>
using namespace std;
int n, m;
int w[1005];
int b[1005];
vector<int> vec;
int pos[1005];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) scanf("%d", &w[i]);
  for (int i = 1; i <= m; ++i) scanf("%d", &b[i]);
  for (int i = 1; i <= m; ++i) {
    if (!pos[b[i]]) {
      vec.push_back(b[i]);
      pos[b[i]] = vec.size();
    }
  }
  int ans = 0;
  for (int i = 1; i <= m; ++i) {
    int p = pos[b[i]] - 1;
    for (int j = 0; j < p; ++j) ans += w[vec[j]];
    for (int j = p - 1; j >= 0; --j) {
      vec[j + 1] = vec[j];
      pos[vec[j]]++;
    }
    vec[0] = b[i];
    pos[vec[0]] = 1;
  }
  printf("%d\n", ans);
  return 0;
}
