#include <bits/stdc++.h>
using namespace std;
bool cmp(pair<int, int> p1, pair<int, int> p2) {
  if (p1.first == p2.first) {
    return p1.second < p2.second;
  } else {
    return p1.first > p2.first;
  }
}
int fc(int k, int pos, vector<pair<int, int> > a, vector<int> b) {
  vector<int> y;
  for (int i = 0; i < k; i++) {
    y.push_back(a[i].second);
  }
  sort(y.begin(), y.end());
  return y[pos - 1];
}
int main() {
  int n;
  cin >> n;
  vector<pair<int, int> > a(n);
  vector<int> b(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
    a[i].second = i;
    b[i] = a[i].first;
  }
  sort(a.begin(), a.end(), cmp);
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int k, pos;
    cin >> k >> pos;
    int x = fc(k, pos, a, b);
    cout << b[x] << endl;
  }
  return 0;
}
