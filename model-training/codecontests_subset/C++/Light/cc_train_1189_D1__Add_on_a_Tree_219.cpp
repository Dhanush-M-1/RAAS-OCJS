#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
int main() {
  long long n;
  cin >> n;
  vector<long long> a[100001];
  for (long long i = 0; i < n - 1; i++) {
    long long x, y;
    cin >> x >> y;
    a[x].push_back(y);
    a[y].push_back(x);
  }
  for (long long i = 1; i <= n; i++) {
    if (a[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
