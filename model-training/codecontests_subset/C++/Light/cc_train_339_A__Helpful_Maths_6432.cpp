#include <bits/stdc++.h>
int main() {
  int i, j, min;
  char temp;
  std::string input{};
  std::getline(std::cin, input);
  if (input.length() == 1) {
    std::cout << input[0];
    exit(0);
  }
  for (i = 0; i <= input.length() - 3; i += 2) {
    min = i;
    for (j = i + 2; j <= input.length() - 1; j += 2) {
      if (input[j] < input[min]) min = j;
    }
    temp = input[min];
    input[min] = input[i];
    input[i] = temp;
  }
  for (i = 0; i <= input.length() - 1; i++) std::cout << input[i];
  return 0;
}
