#include <bits/stdc++.h>
int main() {
  int n, m;
  int book;
  std::vector<int> weights;
  std::vector<int> readOrder;
  std::vector<int> readOrderDuplicate;
  std::cin >> n >> m;
  for (int i = 0; i < n; ++i) {
    std::cin >> book;
    weights.push_back(book);
  }
  for (int i = 0; i < m; ++i) {
    std::cin >> book;
    readOrder.push_back(book);
  }
  readOrderDuplicate = readOrder;
  std::vector<int> stackOrder;
  for (int i = 0; i < n; ++i) {
    book = readOrderDuplicate[0];
    stackOrder.push_back(book);
    for (int j = 0; j < readOrderDuplicate.size(); ++j) {
      if (readOrderDuplicate[j] == book) {
        readOrderDuplicate.erase(readOrderDuplicate.begin() + j);
        j -= 1;
      }
    }
  }
  int mass = 0;
  int bookPos;
  for (int i = 0; i < readOrder.size(); ++i) {
    book = readOrder[i];
    for (int j = 0; j < stackOrder.size(); ++j) {
      if (book == stackOrder[j]) {
        bookPos = j;
        j = stackOrder.size();
      } else {
        mass += weights[stackOrder[j] - 1];
      }
    }
    stackOrder.erase(stackOrder.begin() + bookPos);
    stackOrder.insert(stackOrder.begin(), book);
  }
  std::cout << mass << std::endl;
  return 0;
}
