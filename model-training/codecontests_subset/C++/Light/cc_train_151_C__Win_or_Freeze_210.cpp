#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long i, n;
  cin >> n;
  vector<long long> v;
  for (i = 2; i <= sqrt(n); i++) {
    while (n % i == 0) {
      n /= i;
      v.push_back(i);
    }
  }
  if (n > 1) v.push_back(n);
  if (v.size() > 2) {
    cout << 1 << "\n";
    cout << v[0] * v[1];
    return 0;
  }
  if (v.size() <= 1) {
    cout << 1 << "\n" << 0;
    return 0;
  }
  cout << 2;
  return 0;
}
