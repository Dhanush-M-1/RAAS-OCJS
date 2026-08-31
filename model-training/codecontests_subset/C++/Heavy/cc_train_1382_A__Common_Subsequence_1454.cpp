#include <bits/stdc++.h>
int main() {
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);
  int t;
  std::cin >> t;
  for (int i = 0; i < t; i++) {
    int n, m;
    std::cin >> n >> m;
    int arr1[n], arr2[m];
    std::unordered_set<int> lookup;
    for (int j = 0; j < n; j++) {
      std::cin >> arr1[j];
      lookup.insert(arr1[j]);
    }
    for (int j = 0; j < m; j++) {
      std::cin >> arr2[j];
    }
    bool ans = false;
    for (int j = 0; j < m; j++) {
      if (lookup.find(arr2[j]) != lookup.end()) {
        std::cout << "YES\n";
        std::cout << "1 " << arr2[j] << "\n";
        ans = true;
        break;
      }
    }
    if (!ans) std::cout << "NO\n";
  }
  return 0;
}
