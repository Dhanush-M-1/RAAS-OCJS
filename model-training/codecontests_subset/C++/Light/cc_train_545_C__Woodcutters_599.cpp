#include <bits/stdc++.h>
using namespace std;
const long long int N = 1e5 + 5;
int n, x, y, cnt = 2, us[N];
pair<int, int> a[N];
int main() {
  cin >> n;
  if (n == 1) {
    cout << cnt - 1;
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    cin >> x >> y;
    a[i] = {x, y};
  }
  for (int i = 2; i < n; i++) {
    x = a[i].first, y = a[i].second;
    if (x - a[i - 1].first <= y && abs(x - a[i + 1].first) > y)
      a[i].first += y, cnt++;
    else if (x - a[i - 1].first > y && !us[i - 1])
      cnt++;
  }
  cout << cnt;
}
