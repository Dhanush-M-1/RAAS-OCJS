#include <bits/stdc++.h>
using namespace std;
long long int binary(vector<pair<long long int, long long int> >& v,
                     long long int n) {
  long long int st = 0, ed = (long long int)v.size() - 1LL;
  while (st <= ed) {
    long long int mid = (st + ed) / 2;
    if (v[mid].first == n)
      return v[mid].second;
    else if (v[mid].first > n)
      ed = mid - 1;
    else
      st = mid + 1;
  }
  return 0;
}
int main() {
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int> > v(n);
  for (auto& x : v) cin >> x.first >> x.second;
  if (n == 1) {
    cout << 1;
    return 0;
  }
  long long int cnt = 1;
  v[0].second = v[0].first - v[0].second;
  for (long long int i = 1; i < n - 1; i++) {
    if (v[i].first - v[i].second > v[i - 1].first &&
        v[i].first - v[i].second > v[i - 1].second) {
      cnt++;
      v[i].second = v[i].first - v[i].second;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      cnt++;
      v[i].second = v[i].first + v[i].second;
    } else
      v[i].second = v[i].first;
  }
  cout << cnt + 1 << "\n";
  return 0;
}
