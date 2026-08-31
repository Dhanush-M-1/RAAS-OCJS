#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const long long int INF = 1e9;
long long int gcd(long long int a, long long int b) {
  return b ? gcd(b, a % b) : a;
}
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main() {
  int t;
  cin >> t;
  for (int i = 0; i < (t); ++i) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    while (b > 0 && c > 1) {
      ans += 3;
      b--;
      c -= 2;
    }
    while (a > 0 && b > 1) {
      ans += 3;
      a--;
      b -= 2;
    }
    cout << ans << endl;
  }
  return 0;
}
