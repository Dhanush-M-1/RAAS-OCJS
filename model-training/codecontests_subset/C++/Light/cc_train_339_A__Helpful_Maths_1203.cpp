#include <bits/stdc++.h>
std::string solve(std::string input) {
  int n = input.length();
  if (n == 1) return input;
  for (int i = 0; i < n - 1; i += 2) {
    for (int j = 0; j < n - i - 1; j += 2) {
      int current = input.at(j) - '0';
      int next = input.at(j + 2) - '0';
      if (current > next) {
        int temp = input.at(j);
        input.at(j) = input.at(j + 2);
        input.at(j + 2) = temp;
      }
    }
  }
  return input;
}
int main() {
  std::string input;
  std::getline(std::cin, input);
  std::cout << solve(input) << std::endl;
  return 0;
}
