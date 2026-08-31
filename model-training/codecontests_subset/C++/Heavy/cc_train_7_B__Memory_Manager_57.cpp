#include <bits/stdc++.h>
struct block {
  block(int n, int start, int len) : n(n), start(start), len(len) {}
  int n;
  int start;
  int len;
};
int main() {
  int t = 0;
  int m = 0;
  std::cin >> t >> m;
  std::forward_list<block> memmap;
  int count = 0;
  while (t--) {
    std::string cmd;
    std::cin >> cmd;
    if (cmd == "alloc") {
      int size;
      std::cin >> size;
      if (memmap.empty()) {
        if (size <= m) {
          memmap.emplace_front(++count, 0, size);
          std::cout << count << std::endl;
        } else {
          std::cout << "NULL" << std::endl;
        }
      } else {
        bool found = false;
        auto it = memmap.cbegin();
        if (size <= it->start) {
          found = true;
          memmap.emplace_front(++count, 0, size);
          std::cout << count << std::endl;
        } else {
          for (auto it = memmap.cbegin(); it != memmap.cend(); ++it) {
            auto next = std::next(it);
            if (size <= (next == memmap.cend() ? m : next->start) - it->start -
                            it->len) {
              found = true;
              memmap.emplace_after(it, ++count, it->start + it->len, size);
              std::cout << count << std::endl;
              break;
            }
          }
        }
        if (!found) std::cout << "NULL" << std::endl;
      }
    } else if (cmd == "erase") {
      int n;
      std::cin >> n;
      bool found = false;
      auto prev = memmap.cbefore_begin();
      for (auto it = memmap.cbegin(); it != memmap.cend(); ++it, ++prev) {
        if (it->n == n) {
          found = true;
          memmap.erase_after(prev);
          break;
        }
      }
      if (!found) std::cout << "ILLEGAL_ERASE_ARGUMENT" << std::endl;
    } else if (cmd == "defragment") {
      auto it = memmap.begin();
      if (it != memmap.end()) {
        it->start = 0;
        for (auto next = std::next(it); next != memmap.end(); ++next) {
          next->start = it->start + it->len;
          it = next;
        }
      }
    }
  }
  return 0;
}
