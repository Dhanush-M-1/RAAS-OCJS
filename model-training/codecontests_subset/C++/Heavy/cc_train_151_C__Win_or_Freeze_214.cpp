#include <bits/stdc++.h>
using namespace std;
long long least_prime_factor(long long x) {
  long long lim = sqrt(x);
  for (int i = int(2); i <= int(lim); i++) {
    if (x % i == 0) return i;
  }
  return x;
}
vector<long long> prime_factorise(long long x) {
  vector<long long> ans;
  while (x > 1) {
    ans.push_back(least_prime_factor(x));
    x /= ans.back();
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long q;
  cin >> q;
  vector<long long> factors = prime_factorise(q);
  if (factors.size() <= 1) {
    cout << 1 << '\n';
    cout << 0 << '\n';
  } else if (factors.size() == 2) {
    cout << 2 << '\n';
  } else {
    cout << 1 << '\n';
    cout << factors[0] * factors[1] << '\n';
  }
  return 0;
}
