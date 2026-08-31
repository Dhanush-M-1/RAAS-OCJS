#include <bits/stdc++.h>
using namespace std;
bool comp(pair<long long int, long long int> a,
          pair<long long int, long long int> b) {
  if (a.first != b.first)
    return a.first < b.first;
  else
    return a.second > b.second;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int TESTS = 1;
  while (TESTS--) {
    long long int n;
    cin >> n;
    vector<pair<long long int, long long int> > v;
    for (long long int i = 0; i < n; i++) {
      long long int k;
      cin >> k;
      v.push_back({k, i});
    }
    sort(v.begin(), v.end(), comp);
    long long int m;
    cin >> m;
    while (m--) {
      long long int k, pos;
      cin >> k >> pos;
      vector<pair<long long int, long long int> > a;
      for (long long int i = n - k; i < n; i++)
        a.push_back({v[i].second, v[i].first});
      sort(a.begin(), a.end());
      cout << a[pos - 1].second << '\n';
    }
  }
  return 0;
}
