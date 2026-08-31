#include <bits/stdc++.h>
using namespace std;
string gh = "here";
bool cmp(pair<int, int> a, pair<int, int> b) {
  if (a.first > b.first) {
    return true;
  } else if (a.first == b.first and a.second < b.second) {
    return true;
  }
  return false;
}
bool cmp2(pair<int, int> a, pair<int, int> b) {
  if (a.second < b.second) {
    return true;
  }
  return false;
}
int main() {
  int n;
  cin >> n;
  vector<pair<int, int> > v1(n, {0, 0});
  for (int i = 0; i < n; i++) {
    cin >> v1[i].first;
    v1[i].second = i;
  }
  sort(v1.begin(), v1.end(), cmp);
  int m;
  cin >> m;
  for (int ii = 0; ii < m; ii++) {
    int a, b;
    cin >> a >> b;
    b--;
    sort(v1.begin(), v1.begin() + a, cmp2);
    cout << ((v1.begin() + b)->first) << '\n';
    sort(v1.begin(), v1.begin() + a, cmp);
  }
  return 0;
}
