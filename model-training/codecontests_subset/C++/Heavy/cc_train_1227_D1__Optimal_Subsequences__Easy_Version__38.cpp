#include <bits/stdc++.h>
using namespace std;
bool compare(pair<int, int> p1, pair<int, int> p2) {
  if (p1.first == p2.first) {
    if (p1.second < p2.second)
      return true;
    else
      return false;
  } else if (p1.first < p2.first)
    return false;
  else
    return true;
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  int n;
  cin >> n;
  int a[n + 1];
  vector<pair<int, int>> v;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    v.push_back({x, i + 1});
    a[i + 1] = x;
  }
  int m;
  cin >> m;
  sort(v.begin(), v.end(), compare);
  while (m--) {
    set<int> s;
    int k, pos;
    cin >> k >> pos;
    int i = 0;
    while (k--) {
      s.insert(v[i].second);
      i++;
    }
    auto it = s.begin();
    pos--;
    while (pos--) {
      it++;
    }
    cout << a[*it] << endl;
  }
}
