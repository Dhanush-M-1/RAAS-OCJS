#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    ans = max(ans, min(x - 1, 1000000 - x));
  }
  cout << ans << endl;
  return 0;
}
