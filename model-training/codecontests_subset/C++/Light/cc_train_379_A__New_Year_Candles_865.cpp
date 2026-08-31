#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, ans = 0;
  cin >> n >> m;
  for (int i = 1; n > 0; i++) {
    ans++;
    n--;
    if (i % m == 0) n++;
  }
  cout << ans;
  return 0;
}
