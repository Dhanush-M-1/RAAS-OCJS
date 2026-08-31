#include <bits/stdc++.h>
const int maxn = 1000;
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int a, b, c;
    int ans = 0;
    scanf("%d%d%d", &a, &b, &c);
    ans = ans + min(b, c / 2) * 3;
    b -= ans / 3;
    ans = ans + min(a, b / 2) * 3;
    cout << ans << endl;
  }
  return 0;
}
