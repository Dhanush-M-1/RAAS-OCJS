#include <bits/stdc++.h>
using namespace std;
struct pair_hash {
  template <class T1, class T2>
  std::size_t operator()(const std::pair<T1, T2> &pair) const {
    return (int)((int)(pair.first * 2654435761ll) ^
                 (int)(pair.second * 2654435761ll) * 2654435761ll);
  }
};
unordered_set<pair<int, int>, pair_hash> BS;
vector<vector<pair<int, int>>> stupci(100001);
vector<vector<pair<int, int>>> retci(100001);
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int LIM = 300;
  vector<pair<int, int>> svi;
  int n;
  cin >> n;
  for (int i = 0; i < (n); i++) {
    int x, y;
    cin >> x >> y;
    BS.insert({x, y});
    stupci[x].push_back({x, y});
    retci[y].push_back({x, y});
    svi.push_back({x, y});
  }
  for (int i = 0; i < (100001); i++) sort(stupci[i].begin(), stupci[i].end());
  for (int i = 0; i < (100001); i++) sort(retci[i].begin(), retci[i].end());
  long long cnt = 0;
  for (pair<int, int> curr : svi) {
    if (retci[curr.second].size() <= LIM) {
      for (pair<int, int> myPair : retci[curr.second]) {
        if (myPair.first > curr.first) {
          int dist = myPair.first - curr.first;
          if (BS.count({curr.first, curr.second + dist}) &&
              BS.count({myPair.first, curr.second + dist}))
            cnt++;
        }
      }
    } else {
      for (pair<int, int> myPair : stupci[curr.first]) {
        if (myPair.second > curr.second) {
          int dist = myPair.second - curr.second;
          if (BS.count({curr.first + dist, curr.second}) &&
              BS.count({myPair.first + dist, myPair.second}))
            cnt++;
        }
      }
    }
  }
  cout << cnt;
}
