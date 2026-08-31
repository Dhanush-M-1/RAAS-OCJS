#include <bits/stdc++.h>
using namespace std;
void file() {
  freopen("in.txt", "r", stdin);
  freopen("out.txt", "w", stdout);
}
const int MAX = 1e5 + 7, INF = (1 << 30);
int main() {
  int n, x, f;
  scanf("%d", &n);
  unordered_map<long long, int> m, m1;
  for (int i = 0; i < n; ++i) scanf("%d", &x), ++m[x];
  for (int i = 0; i < n - 1; ++i) {
    scanf("%d", &x), ++m1[x], --m[x];
  }
  for (auto k : m)
    if (m[k.first] > 0) {
      printf("%d\n", k.first);
      break;
    }
  for (int i = 0; i < n - 2; ++i) scanf("%d", &x), --m1[x];
  for (auto k : m)
    if (m1[k.first] > 0) {
      printf("%d\n", k.first);
      break;
    }
  return 0;
}
