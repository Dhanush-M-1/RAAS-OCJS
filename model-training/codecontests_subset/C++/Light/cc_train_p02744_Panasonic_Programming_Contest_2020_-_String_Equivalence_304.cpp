#include <iostream>
#include <string>
int N;

void Search(std::string s, int n) {
  if (s.size() == N) {
    std::cout << s << std::endl;;
    return;
  }
  for (int i = 0; i < n; i++) {
    Search(s+(char)('a'+i), n);
  }
  Search(s+(char)('a'+n), n+1);
}

int main() {
  std::cin >> N;
  Search("a", 1);
}
