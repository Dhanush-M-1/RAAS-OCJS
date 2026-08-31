#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1000000007;
long long int power(int x, int y) {
  long long int res = 1;
  while (y > 0) {
    if (y & 1) res = ((res % mod) * (x % mod)) % mod;
    y = y >> 1;
    x = ((x % mod) * (x % mod)) % mod;
  }
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int i = c / 2;
    int stone = 0;
    if (b - i > 0) {
      stone += i * 2 + i;
      b -= i;
    } else {
      stone += b * 2 + b;
      b = 0;
    }
    int j = b / 2;
    if (a - j > 0)
      stone += j * 2 + j;
    else
      stone += a * 2 + a;
    cout << stone << '\n';
  }
}
