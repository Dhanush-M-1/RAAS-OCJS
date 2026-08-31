#include <bits/stdc++.h>
const int INF = 2e9 + 1;
int main() {
  std::ios::sync_with_stdio(false);
  std::cin.tie(NULL);
  int n, k;
  std::cin >> n >> k;
  std::vector<int> t(n), a(n), b(n);
  std::vector<int> v[2][2];
  for (int i = 0; i < n; i++) {
    std::cin >> t[i] >> a[i] >> b[i];
    v[a[i]][b[i]].push_back(t[i]);
  }
  long long answer = INF;
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 2; j++) {
      for (int K = 0; K < k; ++K) {
        v[i][j].push_back(INF);
      }
      std::sort(v[i][j].begin(), v[i][j].end());
    }
  }
  long long now = 0;
  for (int i = 0; i < k; i++) {
    now += v[1][1][i];
  }
  answer = std::min(answer, now);
  for (int i = 0; i < k; i++) {
    now -= v[1][1][k - i - 1];
    now += v[1][0][i];
    now += v[0][1][i];
    answer = std::min(answer, now);
  }
  if (answer < INF)
    std::cout << answer << '\n';
  else
    std::cout << -1 << '\n';
  return 0;
}
