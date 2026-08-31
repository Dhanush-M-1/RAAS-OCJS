#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  if (n == 1) {
    cout << 1;
    return 0;
  }
  pair<long long, long long> a[n];
  for (int i = 0; i < n; ++i) {
    cin >> a[i].first >> a[i].second;
  }
  long long ans = 2;
  a[0].second = a[0].first;
  a[n - 1].second = a[n - 1].first;
  for (long long i = 1; i < n - 1; i++) {
    if (a[i].first - a[i].second > max(a[i - 1].first, a[i - 1].second)) {
      ans++;
      a[i].second = a[i].first - a[i].second;
    } else if (a[i].first + a[i].second < a[i + 1].first) {
      ans++;
      a[i].second = a[i].first + a[i].second;
    } else {
      a[i].second = a[i].first;
    }
  }
  cout << ans;
  return 0;
}
