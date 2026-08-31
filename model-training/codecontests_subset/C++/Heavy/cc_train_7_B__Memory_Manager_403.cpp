#include <bits/stdc++.h>
int t, m;
std::vector<int> memory;
int number = 1;
void alloc(int size) {
  for (int i = 0; i < m; i++) {
    if (memory[i] == 0) {
      int start = i, space = 1;
      while (++i < m && memory[i] == 0) {
        space++;
      }
      if (space >= size) {
        for (int j = start; j < start + size; j++) memory[j] = number;
        std::cout << number++ << std::endl;
        return;
      }
    }
  }
  std::cout << "NULL" << std::endl;
}
void erase(int n) {
  if (n <= 0) {
    std::cout << "ILLEGAL_ERASE_ARGUMENT" << std::endl;
    return;
  }
  for (int i = 0; i < m; i++) {
    if (memory[i] == n) {
      int start = i, space = 1;
      while (++i < m && memory[i] == n) {
        space++;
      }
      for (int j = start; j < start + space; j++) memory[j] = 0;
      return;
    }
  }
  std::cout << "ILLEGAL_ERASE_ARGUMENT" << std::endl;
}
void defragment() {
  std::vector<int> new_memory;
  for (int i = 0; i < m; i++) {
    if (memory[i] != 0) new_memory.push_back(memory[i]);
  }
  new_memory.resize(m, 0);
  memory = new_memory;
}
int main() {
  std::cin >> t >> m;
  std::vector<std::string> commands(t);
  std::vector<int> arguments(t, 0);
  for (int i = 0; i < t; i++) {
    std::cin >> commands[i];
    if (commands[i] == "alloc" || commands[i] == "erase")
      std::cin >> arguments[i];
  }
  memory.resize(m, 0);
  for (int i = 0; i < t; i++) {
    if (commands[i] == "alloc") {
      alloc(arguments[i]);
    } else if (commands[i] == "erase") {
      erase(arguments[i]);
    } else if (commands[i] == "defragment") {
      defragment();
    }
  }
  return 0;
}
