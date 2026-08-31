#include <bits/stdc++.h>
int main() {
  int n;
  std::cin >> n;
  int counter = 0;
  if (n < 11) {
    std::cout << 0;
    return 0;
  } else if (n > 100) {
    return 0;
  }
  char *buf = new char;
  bool validNumber = false;
  std::cin >> buf;
  for (int x = 0; x < n; x++) {
    if (buf[x] == '8') {
      counter++;
      validNumber = true;
    }
  }
  if (!validNumber) {
    std::cout << 0;
    return 0;
  }
  double d;
  d = n / 11;
  d = trunc(d);
  if (d > counter) {
    std::cout << counter;
  } else {
    std::cout << d;
  }
  return 0;
}
