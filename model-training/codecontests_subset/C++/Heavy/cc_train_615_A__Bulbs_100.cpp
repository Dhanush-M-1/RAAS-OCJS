#include <bits/stdc++.h>
const long long MAX = 1000001;
const int mod = 1e9 + 7;
const double pi1 = acos(-1.0);
using namespace std;
long long binpow(long long a, long long n) {
  long long res = 1;
  while (n > 0) {
    if (n & 1) {
      res *= a;
    }
    a *= a;
    n >>= 1;
  }
  return res;
}
int m, n, num;
bool bulbs[105];
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m;
  memset(bulbs, false, sizeof(bulbs));
  for (int i = 0; i < n; i++) {
    cin >> num;
    int input;
    for (int j = 0; j < num; j++) {
      cin >> input;
      bulbs[input] = true;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!bulbs[i]) {
      cout << "NO\n";
      return 0;
    }
  }
  cout << "YES\n";
  return 0;
}
