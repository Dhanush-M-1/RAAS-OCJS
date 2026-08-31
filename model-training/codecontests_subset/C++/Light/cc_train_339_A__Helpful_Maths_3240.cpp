#include <bits/stdc++.h>
int main() {
  std::string str, str1;
  std::cin >> str;
  std::vector<int> st;
  for (auto& elem : str) {
    if (std::isdigit(elem)) {
      st.push_back(elem);
    }
  }
  std::sort(st.begin(), st.end());
  for (auto& elem : st) {
    str1.push_back(elem);
    str1.push_back('+');
  }
  str1.erase(str1.length() - 1, 1);
  std::cout << str1 << std::endl;
  return 0;
}
