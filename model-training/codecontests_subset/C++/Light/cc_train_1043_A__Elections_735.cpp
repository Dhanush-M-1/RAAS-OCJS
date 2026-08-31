#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0, mx = 0;
  cin >> n;
  vector<int> v(n);
  for (auto &it : v) {
    cin >> it;
    mx = max(mx, it);
    sum += it;
  }
  sum *= 2;
  sum += n;
  sum /= n;
  cout << max(sum, mx) << '\n';
  return 0;
}
