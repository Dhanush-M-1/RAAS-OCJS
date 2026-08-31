#include <bits/stdc++.h>
using namespace std;
string get(int n, int radix) {
  string s = "";
  if (n == 0) {
    s += '0';
  }
  while (n > 0) {
    int dig = n % radix;
    s += dig + '0';
    n /= radix;
  }
  reverse(s.begin(), s.end());
  return s;
}
int main() {
  int k;
  scanf("%d", &k);
  for (int i = 1; i < k; ++i) {
    for (int j = 1; j < k; ++j) {
      printf("%s%c", get(i * j, k).c_str(), (j == k - 1) ? '\n' : ' ');
    }
  }
  return (0);
}
