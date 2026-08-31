#include <bits/stdc++.h>
using namespace std;
const int L = 1000000 + 5;
int la, lb;
int a[L * 2], b[L];
int bp[L];
int main() {
  scanf("%d%d", &la, &lb);
  for (int i = 1; i <= la; ++i) scanf("%d", &a[i]);
  for (int i = 1; i <= lb; ++i) scanf("%d", &b[i]);
  for (int i = 1; i <= la; ++i) a[la + i] = a[i];
  for (int i = 1; i <= lb; ++i) bp[b[i]] = i;
  int ans = 0;
  for (int j = 1, i = 1, turned = false; i <= 2 * la; ++i) {
    if (!bp[a[i]]) {
      j = i + 1;
      turned = false;
      continue;
    }
    while (i - j + 1 > la ||
           ((turned || bp[a[i]] < bp[a[i - 1]]) && bp[a[i]] > bp[a[j]]) ||
           (turned && bp[a[i]] < bp[a[i - 1]])) {
      if (turned && i - j >= 2 && bp[a[j]] > bp[a[j + 1]]) turned = false;
      ++j;
    }
    if (bp[a[i]] < bp[a[i - 1]]) turned = true;
    ans = max(ans, i - j + 1);
  }
  printf("%d\n", ans);
  return 0;
}
