#include <bits/stdc++.h>
using namespace std;
vector<unsigned long long int> vec;
void factors(unsigned long long int n) {
  if (n % 2LL == 0) {
    while (n % 2LL == 0) {
      n /= 2LL;
      vec.push_back(2LL);
    }
  }
  for (unsigned long long int i = 3; i * i <= n; i += 2) {
    if (n % i == 0) {
      while (n % i == 0) {
        n /= i;
        vec.push_back(i);
      }
    }
  }
  if (n > 1) vec.push_back(n);
}
void solve() {
  unsigned long long int x;
  cin >> x;
  factors(x);
  if (vec.size() > 1) {
    if (vec.size() == 2)
      cout << 2 << '\n';
    else {
      cout << 1 << '\n' << vec[0] * vec[1] << '\n';
    }
  } else
    cout << 1 << '\n' << 0 << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);
  ;
  unsigned long long int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
