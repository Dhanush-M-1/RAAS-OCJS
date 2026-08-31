#include <bits/stdc++.h>
using namespace std;
bool mycomparator(pair<long long int, int> p1, pair<long long int, int> p2) {
  if (p1.first == p2.first) {
    if (p1.second > p2.second) {
      return true;
    } else {
      return false;
    }
  }
  if (p1.first < p2.first) {
    return true;
  } else {
    return false;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<pair<long long int, int> > a;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    a.push_back(make_pair(x, i));
  }
  sort(a.begin(), a.end(), mycomparator);
  int m;
  cin >> m;
  for (int i = 0; i < m; i++) {
    int k, pos;
    cin >> k >> pos;
    map<long long int, long long int> p;
    vector<long long int> l;
    for (int i = n - 1; i >= n - k; i--) {
      p[a[i].second] = a[i].first;
      l.push_back(a[i].second);
    }
    sort(l.begin(), l.end());
    cout << p[l[pos - 1]] << "\n";
  }
}
