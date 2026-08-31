#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> a(n);
  vector<pair<int, int>> ps(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    ps[i] = make_pair(a[i], i);
  }
  sort(ps.begin(), ps.end(), [](pair<int, int>& a, pair<int, int>& b) {
    if (a.first == b.first) {
      return a.second < b.second;
    }
    return a.first > b.first;
  });
  int m;
  cin >> m;
  for (int query = 0; query < m; query++) {
    int k, pos;
    cin >> k >> pos;
    priority_queue<int> q;
    for (int i = 0; i < k; i++) {
      q.push(ps[i].second);
      if (i >= pos) {
        q.pop();
      }
    }
    cout << a[q.top()] << endl;
  }
  return 0;
}
