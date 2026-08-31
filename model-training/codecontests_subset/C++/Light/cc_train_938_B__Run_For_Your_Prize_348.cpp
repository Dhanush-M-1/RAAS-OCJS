#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, num, ans = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> num;
    if (num <= 1e6 / 2)
      ans = max(num - 1, ans);
    else
      ans = max(ans, 1000000 - num);
  }
  cout << ans << endl;
}
