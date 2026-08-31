#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 7;
const int INF = 0x3f3f3f3f;
int main() {
  int n;
  scanf("%d", &n);
  int preCur = -INF, preH = 0, cur, h, ans = 0;
  bool isLeft = 1;
  while (n--) {
    scanf("%d %d", &cur, &h);
    if (!isLeft && preCur + preH < cur) ++ans, preCur += preH;
    isLeft = 0;
    if (cur - h > preCur) ++ans, ++isLeft;
    preCur = cur, preH = h;
  }
  if (!isLeft) ++ans;
  printf("%d\n", ans);
  return 0;
}
