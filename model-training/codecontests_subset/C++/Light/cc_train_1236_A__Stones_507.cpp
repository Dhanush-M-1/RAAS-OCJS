#include <bits/stdc++.h>
using namespace std;
int t, a, b, c;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  scanf("%d", &t);
  while (t--) {
    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);
    int ans = min(b, c / 2);
    b -= ans;
    ans *= 3;
    ans += 3 * min(a, b / 2);
    printf("%d\n", ans);
  }
  return 0;
}
