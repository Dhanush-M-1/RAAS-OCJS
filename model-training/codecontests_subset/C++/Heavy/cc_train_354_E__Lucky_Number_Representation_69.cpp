#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7, mod = 1e9 + 7, inf = 1e9 + 7;
const long long linf = (long long)1e18 + 7;
const long double eps = 1e-15, pi = 3.141592;
const int dx[] = {-1, 0, 1, 0, 1, -1, -1, 1},
          dy[] = {0, 1, 0, -1, 1, -1, 1, -1};
long long n;
long long res[7], p[20];
pair<int, int> first[50];
vector<int> d, ans;
inline bool Calc(long long x) {
  if (!x) return 1;
  for (auto i : d)
    if (i <= x && ((x - i) % 10) == 0) {
      ans.push_back(i);
      if (Calc((x - i) / 10)) return 1;
      ans.pop_back();
    }
  return 0;
}
inline void Solve() {
  long long x;
  scanf("%I64d", &x);
  ans.clear();
  if (!Calc(x))
    printf("-1\n");
  else {
    memset(res, 0, sizeof(res));
    for (int i = 0; i <= ans.size() - 1; i++) {
      for (int j = 1; j <= first[ans[i]].first; j++) res[j] += 4 * p[i];
      for (int j = 6 - first[ans[i]].second + 1; j <= 6; j++)
        res[j] += 7 * p[i];
    }
    for (int i = 1; i <= 6; i++) printf("%I64d ", res[i]);
    printf("\n");
  }
}
int main() {
  for (int i = 0; i <= 6; i++)
    for (int j = 0; j <= 6; j++)
      if (i + j <= 6) d.push_back(4 * i + 7 * j), first[d.back()] = {i, j};
  p[0] = 1;
  for (int i = 1; i <= 18; i++) p[i] = p[i - 1] * 10;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) Solve();
  exit(0);
}
