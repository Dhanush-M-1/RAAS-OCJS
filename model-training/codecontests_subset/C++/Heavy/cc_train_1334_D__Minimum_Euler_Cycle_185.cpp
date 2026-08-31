#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
const double pi = acos(-1.0);
const long long int inf = 0x3f3f3f3f3f3f3f3f;
const long long int mod = 998244353;
bool isPowerOfTwo(int x) { return x && (!(x & (x - 1))); }
void fast() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
long long int power(long long int x, long long int y, long long int p) {
  long long int res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long int modInverse(long long int n, long long int p) {
  return power(n, p - 2, p);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, l, r;
    cin >> n >> l >> r;
    long long int k1 = 0, k2 = 0, i1, i2;
    for (i2 = 1; i2 < n; i2++) {
      k2 += 2 * (n - i2);
      if (k2 >= r) break;
    }
    for (i1 = 1; i1 < n; i1++) {
      k1 += 2 * (n - i1);
      if (k1 >= l) break;
    }
    i2++;
    vector<long long int> v, a;
    k1 -= (n - i1) * 2;
    for (int i = i1; i < i2; i++) {
      for (int j = i + 1; j < n + 1; j++) {
        a.emplace_back(i);
        a.emplace_back(j);
      }
    }
    for (long long int i = l; i <= r; i++) {
      if (i == (n * (n - 1) + 1))
        cout << "1 ";
      else
        cout << a[i - k1 - 1] << " ";
    }
    cout << '\n';
  }
  return 0;
}
