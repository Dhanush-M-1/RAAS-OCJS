#include <bits/stdc++.h>
using namespace std;
int dv(pair<int, int> p1, pair<int, int> p2) {
  if (p1.first < p2.first) return 0;
  if (p1.first > p2.first) return 1;
  if (p1.second > p2.second) return 0;
  return 1;
}
int main() {
  int t, n, m, p, k, a, b, c, l, r;
  cin >> n;
  int A[n];
  for (int i = 0; i < n; i++) cin >> A[i];
  vector<pair<int, int> > v;
  for (int i = 0; i < n; i++) v.push_back({A[i], i});
  sort(v.begin(), v.end(), dv);
  cin >> m;
  for (int i = 0; i < m; i++) {
    vector<int> pos;
    cin >> k >> p;
    for (int i = 0; i < k; i++) {
      pos.push_back(v[i].second);
    }
    sort(pos.begin(), pos.end());
    cout << A[pos[p - 1]] << endl;
  }
}
