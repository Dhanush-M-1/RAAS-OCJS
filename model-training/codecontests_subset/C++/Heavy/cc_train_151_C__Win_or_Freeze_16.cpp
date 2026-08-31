#include <bits/stdc++.h>
using namespace std;
vector<long long> res;
int main() {
  cin.tie(0);
  cout.tie(0);
  ios::sync_with_stdio(0);
  long long n, f = 0, m;
  cin >> n;
  m = n;
  for (int i = 2; i <= sqrt(m); i++) {
    if (n % i == 0) {
      while (n % i == 0) {
        res.push_back(i);
        n /= i;
        if (res.size() == 3) {
          f = 1;
          break;
        }
      }
    }
  }
  if (res.size() == 2) {
    if (m == res[0] * res[1])
      cout << 2;
    else
      cout << 1 << endl << res[0] * res[1];
    return 0;
  }
  if (f) {
    cout << 1 << endl << (res[0] * res[1]);
    return 0;
  }
  if (res.empty())
    cout << 1 << endl << 0;
  else
    cout << 2;
  return 0;
}
