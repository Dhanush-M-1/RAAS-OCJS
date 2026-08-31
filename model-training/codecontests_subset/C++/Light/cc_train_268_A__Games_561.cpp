#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3f;
const int MOD = (int)1e9 + 7;
const int N = (int)1e6 + 7;
char s[N], s1[N], s2[N];
int n, k;
pair<int, int> a[N];
void Init() {}
int Solve() {
  for (int i = (0); i < (n); ++i) scanf("%d%d", &a[i].first, &a[i].second);
  int cnt = 0;
  for (int i = (0); i < (n); ++i)
    for (int j = (0); j < (n); ++j)
      if (i != j) {
        if (a[i].first == a[j].second) cnt++;
      }
  return printf("%d\n", cnt);
}
int main() {
  while (~scanf("%d", &n)) {
    Init();
    Solve();
  }
  return 0;
}
