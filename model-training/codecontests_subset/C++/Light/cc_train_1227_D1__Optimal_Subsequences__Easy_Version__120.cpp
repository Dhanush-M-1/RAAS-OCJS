#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> arr(n);
  set<pair<int, int>> left;
  for (int i = 0; i < arr.size(); i++) {
    cin >> arr[i];
    left.insert(make_pair(arr[i], i * -1));
  }
  int m;
  cin >> m;
  while (m--) {
    int k, j;
    cin >> k >> j;
    j--;
    set<pair<int, int>> test = left;
    while (test.size() > k) {
      auto t = test.begin();
      test.erase(t);
    }
    vector<pair<int, int>> fil;
    for (auto a : test) {
      fil.push_back(make_pair(a.second * -1, a.first));
    }
    sort(fil.begin(), fil.end());
    cout << fil[j].second << "\n";
  }
  return 0;
}
