#include <bits/stdc++.h>
using namespace std;
long long int a, b;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> a >> b;
  long long int ans = 0;
  while (a > 0) {
    a--;
    ans++;
    if (ans % b == 0) a++;
  }
  cout << ans << '\n';
  return 0;
}
