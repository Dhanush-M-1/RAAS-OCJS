#include <bits/stdc++.h>
static void init() {
  std::ios::sync_with_stdio(false);
  std::cin.tie(nullptr);
}
int main(int argc, char** argv) {
  init();
  int n, len;
  std::cin >> n >> len;
  std::vector<int> vec(n);
  for (size_t i = 0; i < n; i++) std::cin >> vec[i];
  std::sort(vec.begin(), vec.end());
  std::vector<int>::reverse_iterator it = vec.rbegin();
  while (it != vec.rend()) {
    if (len % *it == 0) {
      std::cout << len / *it << std::endl;
      return 0;
    }
    it++;
  }
  return 0;
}
