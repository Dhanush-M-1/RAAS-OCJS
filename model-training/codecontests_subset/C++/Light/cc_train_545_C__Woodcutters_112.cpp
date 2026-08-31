#include <bits/stdc++.h>
int main() {
  int n;
  std::vector<std::pair<int, int> > v;
  std::cin >> n;
  v.resize(n);
  for (int i = 0; i < n; ++i) std::cin >> v[i].first >> v[i].second;
  int ans = 2;
  for (int i = 1; i < n - 1; ++i) {
    if (v[i].first - v[i].second > v[i - 1].first)
      ++ans;
    else if (v[i].first + v[i].second < v[i + 1].first) {
      ++ans;
      v[i].first += v[i].second;
    }
  }
  std::cout << (n == 1 ? 1 : ans) << std::endl;
  return 0;
}
