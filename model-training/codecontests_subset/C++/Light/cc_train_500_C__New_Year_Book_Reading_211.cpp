#include <bits/stdc++.h>
using namespace std;
int n, m, w[1005], b[1005], done[1005];
vector<int> uq;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%d", &w[i]);
  for (int i = 0; i < m; i++) {
    scanf("%d", &b[i]);
    --b[i];
    if (!done[b[i]]) {
      done[b[i]] = true;
      uq.push_back(b[i]);
    }
  }
  int ans = 0;
  for (int i = 0; i < m; i++) {
    int j = 0, s = 0;
    while (j < n) {
      if (uq[j] == b[i]) break;
      s += w[uq[j]];
      j++;
    }
    ans += s;
    uq.erase(uq.begin() + j);
    uq.insert(uq.begin(), b[i]);
  }
  printf("%d\n", ans);
  return 0;
}
