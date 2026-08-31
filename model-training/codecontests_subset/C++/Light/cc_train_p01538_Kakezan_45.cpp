#include <cstdio>
#include <cstdint>
#include <string>
#include <algorithm>
#include <vector>

intmax_t f(intmax_t r) {
  std::string s = std::to_string(r);
  intmax_t res = 0;
  for (size_t i = 1; i < s.length(); ++i) {
    std::string s0 = s.substr(0, i);
    std::string s1 = s.substr(i);
    intmax_t r0 = std::stoi(s0);
    intmax_t r1 = std::stoi(s1);
    res = std::max(res, r0*r1);
  }
  if (res > 1e9) return -1;
  return res;
}

int testcase_ends() {
  intmax_t R;
  scanf("%jd", &R);

  int res = 0;
  while (R > 9) {
    R = f(R);
    ++res;
  }
  printf("%d\n", res);
  return 0;
}

int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) testcase_ends();
}

