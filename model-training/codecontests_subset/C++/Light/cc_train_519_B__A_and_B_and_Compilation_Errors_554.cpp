#include <bits/stdc++.h>
using namespace std;
long long n, m, ans, ans1, ans2;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> m;
    ans += m;
  }
  for (int i = 1; i < n; i++) {
    cin >> m;
    ans1 += m;
  }
  cout << ans - ans1 << '\n';
  for (int i = 1; i < n - 1; i++) {
    cin >> m;
    ans2 += m;
  }
  cout << ans1 - ans2;
}
