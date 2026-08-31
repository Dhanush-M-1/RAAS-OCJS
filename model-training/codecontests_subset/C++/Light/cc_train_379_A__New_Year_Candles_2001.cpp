#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long int a, b;
  cin >> a >> b;
  long long int ans = a;
  while (a / b >= 1) {
    ans += a / b;
    a = a / b + a % b;
  }
  cout << ans;
}
