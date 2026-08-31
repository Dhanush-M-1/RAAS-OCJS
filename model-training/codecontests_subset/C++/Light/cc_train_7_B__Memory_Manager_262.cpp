#include <bits/stdc++.h>
int Memory[100];
int t, m, id = 0, i, j, len, n, x;
char order[20];
int main() {
  for (i = 0; i <= 100; i++) Memory[i] = 0;
  std::cin >> t >> m;
  while (t--) {
    bool flag = true;
    std::cin >> order;
    if (order[0] == 'a') {
      std::cin >> n;
      for (i = 0; i <= m - n; i++) {
        for (j = i; j < i + n; j++)
          if (Memory[j] != 0) {
            flag = true;
            break;
          }
        if (j == i + n) {
          flag = false;
          break;
        }
      }
      if (flag) {
        std::cout << "NULL" << std::endl;
        continue;
      }
      id++;
      for (j = i; j < i + n; j++) Memory[j] = id;
      std::cout << id << std::endl;
    } else if (order[0] == 'e') {
      std::cin >> x;
      flag = false;
      if (x == 0)
        std::cout << "ILLEGAL_ERASE_ARGUMENT" << std::endl;
      else {
        for (i = 0; i < m; i++)
          if (Memory[i] == x) {
            flag = true;
            Memory[i] = 0;
          }
        if (!flag) std::cout << "ILLEGAL_ERASE_ARGUMENT" << std::endl;
      }
    } else {
      len = m;
      for (i = 0; i < len; i++) {
        if (Memory[i] == 0) {
          memmove(Memory + i, Memory + i + 1, (m - i - 1) * 4);
          len--;
          i--;
        }
      }
      for (i = len; i < m; i++) Memory[i] = 0;
    }
  }
  return 0;
}
