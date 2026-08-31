#include <bits/stdc++.h>
using namespace std;
bool cmp(pair<long long int, int> p, pair<long long int, int> q) {
  if (p.first > q.first)
    return 1;
  else if (p.first < q.first)
    return 0;
  else {
    if (p.second < q.second)
      return 1;
    else
      return 0;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  long long int a[n];
  vector<pair<long long int, int> > v;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    v.push_back({a[i], i});
  }
  sort(v.begin(), v.end(), cmp);
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    vector<int> temp;
    for (int i = 0; i < k; i++) temp.push_back(v[i].second);
    sort(temp.begin(), temp.end());
    cout << a[temp[pos - 1]] << "\n";
  }
  return 0;
}
