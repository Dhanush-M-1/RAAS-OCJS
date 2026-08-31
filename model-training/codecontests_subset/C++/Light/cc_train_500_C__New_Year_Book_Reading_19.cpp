#include <bits/stdc++.h>
int main() {
  int n, m;
  std::cin >> n >> m;
  std::vector<int> w(n);
  std::vector<int> b(m);
  std::vector<std::vector<int> > above(n);
  std::vector<int> above_sum(n);
  bool is_above[n][n];
  for (int i = 0; i < n; ++i) {
    above_sum[i] = 0;
    std::cin >> w[i];
    for (int j = 0; j < n; ++j) {
      is_above[i][j] = false;
    }
  }
  for (int i = 0; i < m; ++i) {
    std::cin >> b[i];
  }
  int ttl = 0;
  for (auto it : b) {
    int i = it - 1;
    ttl += above_sum[i];
    above_sum[i] = 0;
    for (int j = 0; j < n; ++j) {
      if (j == i) continue;
      is_above[j][i] = false;
      if (!is_above[i][j]) {
        is_above[i][j] = true;
        above_sum[j] += w[i];
      }
    }
  }
  std::cout << ttl << std::endl;
  return 0;
}
