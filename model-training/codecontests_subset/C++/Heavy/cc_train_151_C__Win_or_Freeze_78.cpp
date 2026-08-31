#include <bits/stdc++.h>
using namespace std;
vector<long long int> v;
int main() {
  ios::sync_with_stdio(0), ios_base::sync_with_stdio(0), cin.tie(0),
      cout.tie(0);
  ;
  long long int n, val, x = 1;
  cin >> n, val = n;
  for (long long int i = 2; i * i <= n; ++i) {
    while (n % i == 0) {
      if (i != val) v.push_back(i);
      n /= i;
    }
    if ((long long int)v.size() > 2) {
      cout << 1 << "\n";
      x = v.back();
      v.pop_back();
      cout << x * v.back() << "\n";
      return 0;
    }
  }
  if (n > 1 && n != val) v.push_back(n);
  if (v.size() == 2)
    return cout << 2 << "\n", 0;
  else if (v.size() > 2) {
    x = v.back();
    v.pop_back();
    return cout << 1 << "\n" << x * v.back() << "\n", 0;
  } else
    cout << "1\n0\n";
  return 0;
}
