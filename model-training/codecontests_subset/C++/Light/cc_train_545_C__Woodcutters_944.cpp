#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  pair<long long, long long> v[n];
  for (int i = 0; i < n; i++) {
    cin >> v[i].first >> v[i].second;
  }
  long long mx = v[0].first;
  int cnt = min(2, n);
  for (int i = 1; i < n - 1; i++) {
    mx = max(v[i - 1].first, mx);
    if (v[i].first - v[i].second > mx) {
      mx = v[i].first;
      cnt++;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      mx = v[i].first + v[i].second;
      cnt++;
    }
  }
  cout << cnt;
}
