#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int main() {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  n *= 2;
  int n_;
  int res = 0;
  for (int a_ = 0; a_ < a + 1; ++a_)
    for (int b_ = 0; b_ < b + 1; ++b_) {
      n_ = n - a_ - (b_ << 1);
      if (n_ < 0) continue;
      if (n_ & 3) continue;
      n_ >>= 2;
      if (n_ <= c) ++res;
    }
  printf("%d\n", res);
  return 0;
}
