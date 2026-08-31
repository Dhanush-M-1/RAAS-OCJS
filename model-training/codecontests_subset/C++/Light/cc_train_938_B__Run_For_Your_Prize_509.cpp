#include <bits/stdc++.h>
using namespace std;
const int u = 1000000;
int ans;
int n;
int main() {
  scanf("%d", &n);
  while (n--) {
    int x;
    scanf("%d", &x);
    ans = max(ans, min(x - 1, u - x));
  }
  cout << ans << endl;
  return 0;
}
