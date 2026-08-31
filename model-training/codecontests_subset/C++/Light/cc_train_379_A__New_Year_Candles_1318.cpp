#include <bits/stdc++.h>
using namespace std;
const long long int INF = LLONG_MAX / 2;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long int t = 1, i, j;
  while (t--) {
    long long int a, b;
    cin >> a >> b;
    long long int ans = a, temp;
    while (a >= b) {
      temp = a % b;
      a /= b;
      ans += a;
      a += temp;
    }
    cout << ans << "\n";
  }
  return 0;
}
