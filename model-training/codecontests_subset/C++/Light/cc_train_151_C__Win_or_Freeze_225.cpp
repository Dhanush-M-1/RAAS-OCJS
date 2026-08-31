#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, realn, j;
  vector<long long> v;
  cin >> n;
  j = sqrt(n);
  realn = n;
  if (n == 1) {
    cout << 1 << "\n" << 0;
    return 0;
  }
  for (long long i = 2; i <= j; i++) {
    while ((n / i) * i == n) {
      v.push_back(i);
      n /= i;
    }
  }
  if (n > 1) v.push_back(n);
  if (v.size() == 1)
    cout << 1 << "\n" << 0;
  else if (v.size() == 2)
    cout << 2;
  else {
    cout << 1 << "\n" << v[0] * v[1];
  }
  return 0;
}
