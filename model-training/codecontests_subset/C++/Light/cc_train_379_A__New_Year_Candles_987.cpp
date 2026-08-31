#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int a, b;
  cin >> a >> b;
  long long int ans = a, tem = a / b, tem2 = a % b, tem3 = tem;
  while (tem > 0) {
    ans += tem;
    tem3 = (tem3 + tem2) / b;
    if (tem + tem2 < b) {
      tem2 = 0;
    } else {
      tem2 = (tem + tem2) % b;
    }
    tem = tem3;
  }
  cout << ans << "\n";
  return 0;
}
