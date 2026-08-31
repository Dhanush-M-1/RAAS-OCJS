#include <bits/stdc++.h>
using namespace std;
int main() {
  cout.sync_with_stdio(0);
  cin.tie(0);
  long long n;
  cin >> n;
  vector<long long> v;
  long long maxi = 0;
  for (long long i = 0; i < n; i++) {
    long long x;
    cin >> x;
    maxi = max(maxi, x);
    v.push_back(x);
  }
  long long esq = maxi, dir = 1e9, res = 1e9;
  while (esq <= dir) {
    long long mid = (esq + dir) / 2;
    long long a = 0;
    for (long long i = 0; i < n; i++) a += mid - v[i];
    long long b = mid * n - a;
    if (a > b) {
      dir = mid - 1;
      res = min(res, mid);
    } else
      esq = mid + 1;
  }
  cout << res << endl;
  return 0;
}
