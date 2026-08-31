#include <bits/stdc++.h>
const long long int maxn = 1e10;
const long long mod = 1e9 + 7;
using namespace std;
long long int power(long long int a, long long int b) {
  long long int res = 1;
  while (b > 0) {
    if (b % 2 == 1) res = res * a;
    a = a * a;
    b = b / 2;
  }
  return res;
}
long long po(long long x, long long y) {
  long long res = 1;
  x = x % mod;
  while (y > 0) {
    if (y & 1) res = ((res % mod) * (x % mod)) % mod;
    y = y >> 1;
    x = ((x % mod) * (x % mod)) % mod;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  cin >> t;
  while (t--) {
    long long int n, l, r;
    cin >> n >> l >> r;
    long long int count = 0;
    int i = 1;
    long long int ini = 2 * (n - 1);
    while (1) {
      if (count + ini >= l || i == n) break;
      count += ini;
      ini -= 2;
      i++;
    }
    count++;
    vector<pair<long long int, long long int> > p;
    while (count <= r) {
      if (count == n * (n - 1) + 1) {
        p.push_back({1, count});
        count++;
        continue;
      }
      int it = i + 1, flag = 1;
      for (int j = 0; j < ini; j++) {
        if (flag) {
          p.push_back({i, count});
          count++;
          flag = 0;
        } else {
          p.push_back({it, count});
          count++;
          it++;
          flag = 1;
        }
      }
      ini -= 2;
      i++;
    }
    for (int j = 0; j < p.size(); j++) {
      if (p[j].second <= r && p[j].second >= l) cout << p[j].first << " ";
    }
    cout << endl;
  }
}
