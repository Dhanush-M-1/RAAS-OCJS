#include <bits/stdc++.h>
using namespace std;
const long double EPS = 1e-8;
const long long INF = 1e18 + 7;
const int inf = 2139062143;
int n;
string work(int x) {
  string res;
  res.clear();
  while (x) {
    res += char(x % n + 48);
    x /= n;
  }
  reverse(res.begin(), res.end());
  return res;
}
int main() {
  scanf("%d", &n);
  int i, j;
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) {
      printf("%s ", work(i * j).c_str());
    }
    putchar(10);
  }
  return 0;
}
