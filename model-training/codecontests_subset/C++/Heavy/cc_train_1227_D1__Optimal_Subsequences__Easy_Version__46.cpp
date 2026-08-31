#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9 * 10;
long long arr[200];
vector<pair<long long, long long>> sortedVec, vec2;
bool comp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first > b.first) return true;
  if (b.first > a.first) return false;
  if (a.second > b.second) return false;
  return true;
}
int main() {
  int n, m;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    sortedVec.push_back(make_pair(arr[i], i));
  }
  cin >> m;
  sort(sortedVec.begin(), sortedVec.end(), comp);
  for (int i = 0; i < m; i++) {
    int k, pos;
    cin >> k >> pos;
    for (int j = 0; j < k; j++) {
      vec2.push_back(make_pair(sortedVec[j].second, sortedVec[j].first));
    }
    sort(vec2.begin(), vec2.end());
    cout << vec2[pos - 1].second << "\n";
    vec2.resize(0);
  }
  return 0;
}
