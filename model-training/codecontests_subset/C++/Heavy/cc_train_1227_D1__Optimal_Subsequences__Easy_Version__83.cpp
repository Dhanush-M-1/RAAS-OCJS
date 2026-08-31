#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> arr(n);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int m;
  cin >> m;
  while (m--) {
    map<int, pair<int, vector<int>>> mp;
    int k, pos;
    cin >> k >> pos;
    vector<int> temp;
    mp[0] = make_pair(0, temp);
    for (int i = 0; i < n; i++) {
      vector<pair<int, vector<int>>> toadd;
      for (auto& a : mp) {
        if (a.first >= k) continue;
        int nsm = a.second.first + arr[i];
        vector<int> temp = a.second.second;
        ;
        temp.push_back(arr[i]);
        toadd.push_back(make_pair(nsm, temp));
      }
      for (auto& a : toadd) {
        if (!mp.count(a.second.size()) || mp[a.second.size()].first < a.first ||
            (mp[a.second.size()].first == a.first &&
             mp[a.second.size()].second > a.second)) {
          mp[a.second.size()] = a;
        }
      }
    }
    auto e = mp.end();
    e--;
    cout << e->second.second[pos - 1] << "\n";
  }
  return 0;
}
