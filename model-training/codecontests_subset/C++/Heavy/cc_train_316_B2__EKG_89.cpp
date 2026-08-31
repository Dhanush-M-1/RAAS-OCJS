#include <bits/stdc++.h>
using namespace std;
int n, x;
int a[1005];
bool tail[1005];
int main() {
  while (scanf("%d%d", &n, &x) != EOF) {
    --x;
    for (int i = 0; i < (n); ++i) scanf("%d", &a[i]), --a[i];
    for (int i = 0; i < (n); ++i) tail[i] = true;
    for (int i = 0; i < (n); ++i)
      if (a[i] != -1) tail[a[i]] = false;
    vector<int> cnt;
    for (int i = 0; i < (n); ++i)
      if (tail[i]) {
        int c = 0, k;
        for (k = i; k != -1; k = a[k]) {
          if (k == x) break;
          ++c;
        }
        if (k == -1) cnt.push_back(c);
      }
    int base = 0;
    for (int k = x; k != -1; k = a[k]) ++base;
    set<int> dp1, dp2;
    dp1.insert(0);
    for (int i = 0; i < (((int)cnt.size())); ++i) {
      dp2 = dp1;
      for (set<int>::iterator it = dp1.begin(); it != dp1.end(); ++it) {
        dp2.insert(*it + cnt[i]);
      }
      dp1 = dp2;
    }
    for (set<int>::iterator it = dp1.begin(); it != dp1.end(); ++it) {
      printf("%d\n", base + *it);
    }
  }
  return 0;
}
