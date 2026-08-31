#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:167772160000")
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int ans = 1E9;
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < (n); i++) {
    int a;
    cin >> a;
    if (k % a != 0) continue;
    ans = min(ans, k / a);
  }
  cout << ans;
  return 0;
}
