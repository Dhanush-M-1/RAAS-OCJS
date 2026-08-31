#include <cstdio>
#include <cassert>
#include <string>
#include <vector>
#include <utility>
#include <algorithm>

bool nya(std::vector<int> const& w, size_t k) {
  std::vector<int> haiku{5, 7, 5, 7, 7};
  int j = 0;
  for (size_t i = k; i < w.size(); ++i) {
    if (haiku[j] < w[i]) return false;
    haiku[j] -= w[i];
    if (haiku[j] == 0) {
      if (++j == 5) return true;
    }
  }
  return false;
}

int testcase_ends() {
  size_t n;
  scanf("%zu", &n);
  if (n == 0) return 1;

  std::vector<int> w(n);
  for (auto& wi: w) {
    char buf[16];
    scanf("%s", buf);
    wi = std::string(buf).length();
  }

  for (size_t i = 0; i < n; ++i)
    if (nya(w, i)) return !printf("%zu\n", i+1);

  assert(false);
}

int main() {
  while (!testcase_ends()) {}
}

