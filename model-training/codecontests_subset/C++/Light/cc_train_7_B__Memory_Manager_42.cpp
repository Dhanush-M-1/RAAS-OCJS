#include <bits/stdc++.h>
using namespace std;
int main() {
  std::array<int, 100> Arr{0};
  int t, m;
  std::cin >> t >> m;
  int id = 1;
  std::string Command;
  while (t--) {
    std::cin >> Command;
    if (Command[0] == 'a') {
      int p;
      std::cin >> p;
      int cnt = 0, idx = 0;
      bool OK = false;
      for (int i = 0; i < m; ++i) {
        if (!Arr[i])
          ++cnt;
        else {
          cnt = 0;
          idx = i + 1;
        }
        if (cnt == p) {
          OK = true;
          break;
        }
      }
      if (OK) {
        for (int i = idx; i < idx + p; ++i) Arr[i] = id;
        std::cout << id++ << std::endl;
      } else
        std::puts("NULL");
    } else if (Command[0] == 'e') {
      int p;
      std::cin >> p;
      if (p > id || p <= 0)
        std::puts("ILLEGAL_ERASE_ARGUMENT");
      else {
        int f = false;
        int i;
        for (i = 0; i < m; ++i)
          if (Arr[i] == p) break;
        while (Arr[i] == p) {
          Arr[i] = 0;
          ++i;
          f = true;
        }
        if (!f) std::puts("ILLEGAL_ERASE_ARGUMENT");
      }
    } else {
      int idx = 0;
      for (int i = 0; i < m; ++i)
        if (Arr[i]) Arr[idx++] = Arr[i];
      for (int i = idx; i < m; ++i) Arr[i] = 0;
    }
  }
  return 0;
}
