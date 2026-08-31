#include <bits/stdc++.h>
void IntToString(int val, std::string& res, int iRadix) {
  res = "";
  for (; val; val /= iRadix) res = "0123456789abcdef"[val % iRadix] + res;
}
int main() {
  std::ios_base::sync_with_stdio(0);
  int k, res;
  std::cin >> k;
  std::string buf;
  for (int i(1); i < k; i++) {
    for (int j(1); j < k; j++) {
      res = i * j;
      IntToString(res, buf, k);
      std::cout << buf << ' ';
    }
    std::cout << std::endl;
  }
  return 0;
}
