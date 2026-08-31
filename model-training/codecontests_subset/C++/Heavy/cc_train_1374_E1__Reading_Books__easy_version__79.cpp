#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 7;
long long poww(long long a, long long b, long long mod) {
  long long ans = 1;
  while (b) {
    if (b & 1) ans = (ans * a) % mod;
    a = (a * a) % mod;
    b >>= 1;
  }
  return ans % mod;
}
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> a;
  vector<int> b;
  vector<int> c;
  vector<int> d;
  for (int i = 0; i < n; i++) {
    int z, x, y;
    cin >> z >> x >> y;
    if (x == 1 && y == 1) {
      a.push_back(z);
    } else if (x == 1) {
      b.push_back(z);
    } else if (y == 1) {
      c.push_back(z);
    }
  }
  if (a.size() + min(b.size(), c.size()) < k) {
    cout << -1 << endl;
    return 0;
  }
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  for (int i = 0; i < b.size() && i < c.size(); i++) {
    int z = b[i] + c[i];
    a.push_back(z);
  }
  sort(a.begin(), a.end());
  int sum = 0;
  for (int i = 0; i < k; i++) {
    sum += a[i];
  }
  cout << sum << endl;
}
