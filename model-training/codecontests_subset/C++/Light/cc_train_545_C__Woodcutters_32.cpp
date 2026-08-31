#include <bits/stdc++.h>
using namespace std;
int n, m[100001], ans;
pair<int, int> t[100001];
int main() {
  cin >> n;
  m[0] = -2e9;
  t[n + 1].first = 2e9 + 1;
  for (int i = 1; i <= n; i++) {
    cin >> t[i].first >> t[i].second;
  }
  for (int i = 1; i <= n; i++) {
    if (t[i].first - t[i].second > m[i - 1]) {
      m[i] = t[i].first;
      ans++;
    } else if (t[i].first + t[i].second < t[i + 1].first) {
      m[i] = t[i].first + t[i].second;
      ans++;
    } else {
      m[i] = t[i].first;
    }
  }
  cout << ans << endl;
}
