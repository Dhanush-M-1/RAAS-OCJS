#include <iostream>
#include <vector>

int main() {
  int n;

  constexpr int check[] = {5, 7, 5, 7, 7};

LOOP:
  while (std::cin >> n, n != 0) {
    std::vector<std::string> v(n);

    for (int i = 0; i < n; ++i) {
      std::cin >> v[i];
    }


    for (int i = 0; i < n; ++i) {
      int cnt = 0, idx = 0;
      for (int j = i; j < n; ++j) {
        cnt += v[j].size();
        if (cnt == check[idx]) {
          cnt = 0;
          idx++;
        }
        if (idx == 5) {
          std::cout << i + 1 << std::endl;
          goto LOOP;
        }
      }
    }
  }
}

