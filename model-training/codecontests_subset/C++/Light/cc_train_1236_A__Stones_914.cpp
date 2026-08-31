#include <bits/stdc++.h>
using namespace std;
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  for (auto i : v) os << i << " ";
  return os;
}
template <typename T>
ostream& operator<<(ostream& os, const set<T>& v) {
  for (auto i : v) os << i << " ";
  return os;
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    int ans = 0;
    for (int i = 0; i < 100; ++i)
      for (int j = 0; j < 100; ++j) {
        if (i <= a && i * 2 + j <= b && j * 2 <= c)
          ans = max(ans, i * 3 + j * 3);
      }
    printf("%d\n", ans);
  }
  return 0;
}
