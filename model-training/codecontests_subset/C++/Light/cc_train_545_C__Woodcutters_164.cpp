#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<pair<long long, long long>> a(n);
  for (long long i = 0; i < n; i++) {
    long long t1, t2;
    cin >> t1 >> t2;
    a[i] = make_pair(t1, t2);
  }
  a.push_back(make_pair(LLONG_MAX, -1));
  sort(a.begin(), a.end());
  long long res = 1;
  for (long long i = 1; i < n; i++) {
    if (a[i].first - a[i].second > a[i - 1].first) {
      res += 1;
    } else if (a[i].first + a[i].second < a[i + 1].first) {
      res += 1;
      a[i].first = a[i].first + a[i].second;
    }
  }
  cout << res << "\n";
}
