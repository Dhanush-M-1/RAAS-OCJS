#include <bits/stdc++.h>
using namespace std;
const int infint = INT_MAX;
const long long infll = LLONG_MAX;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  multiset<int> errs[3];
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < n - i; j++) {
      int v;
      cin >> v;
      errs[i].insert(v);
    }
  }
  int frst = 0;
  multiset<int> cp = errs[0];
  for (auto i : errs[1]) {
    auto iter = cp.find(i);
    if (iter != cp.end()) cp.erase(iter);
  }
  frst = *cp.begin();
  for (auto i : errs[2]) {
    auto iter = errs[1].find(i);
    if (iter != errs[1].end()) errs[1].erase(iter);
  }
  cout << frst << "\n" << *errs[1].begin();
  return 0;
}
