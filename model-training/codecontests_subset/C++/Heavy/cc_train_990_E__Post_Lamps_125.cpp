#include <bits/stdc++.h>
using namespace std;
const int sz = 1e6 + 5;
int n, m, k;
bitset<sz> block;
long long p[sz], amt[sz], lst[sz];
void input() {
  scanf("%d %d %d", &n, &m, &k);
  int tmp;
  for (int i = 0; i < m; i++) {
    scanf("%d", &tmp);
    block[tmp] = 1;
  }
  for (int i = 0; i < k; i++) scanf("%d", &p[i + 1]);
  int cur = -1;
  for (int i = 0; i < n; i++) {
    if (!block[i]) cur = i;
    lst[i] = cur;
  }
}
int main() {
  input();
  if (block[0]) {
    cout << -1 << '\n';
    return 0;
  }
  long long bst = 1e15;
  for (int l = 1; l <= k; l++) {
    int ind = 0, mxColored = -1;
    while (mxColored < n - 1 && ind < n) {
      mxColored = min(ind + l - 1, n - 1);
      amt[l]++;
      if (mxColored == n - 1) break;
      int nxt = lst[mxColored + 1];
      if (nxt == ind)
        break;
      else
        ind = nxt;
    }
    if (mxColored < n - 1) amt[l] = 2e12;
    bst = min(bst, p[l] * amt[l]);
  }
  if (bst <= 1e12)
    printf("%lld\n", bst);
  else
    printf("-1\n");
  return 0;
}
