#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-10;
int dblcmp(double d) {
  if (fabs(d) < eps) return 0;
  return (d > 0) ? 1 : -1;
}
int n, m, T;
int cnt[28];
string str;
int main() {
  cin >> n >> str;
  m = (str).length();
  memset(cnt, 0, sizeof(cnt));
  for (int i = 0; i < m; ++i) ++cnt[str[i] - 'a'];
  for (int i = 0; i < 26; ++i) {
    if (cnt[i] % n != 0) {
      printf("-1\n");
      return 0;
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < 26; ++j) {
      for (int k = 0; k < cnt[j] / n; ++k) printf("%c", j + 'a');
    }
  }
  printf("\n");
}
