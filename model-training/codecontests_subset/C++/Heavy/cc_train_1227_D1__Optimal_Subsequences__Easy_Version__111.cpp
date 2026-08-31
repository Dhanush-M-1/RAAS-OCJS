#include <bits/stdc++.h>
using namespace std;
bool comp(const pair<long long int, long long int> &a,
          const pair<long long int, long long int> &b) {
  if (a.first == b.first) {
    return a.second < b.second;
  }
  return a.first > b.first;
}
int main() {
  int n;
  cin >> n;
  vector<long long int> arr(n);
  vector<pair<long long int, long long int>> temp(n);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    temp[i] = {arr[i], i};
  }
  sort(temp.begin(), temp.end(), comp);
  int m, k, pos;
  cin >> m;
  while (m--) {
    cin >> k >> pos;
    vector<pair<long long int, long long int>> curr;
    for (int i = 0; i < k; i++) {
      curr.push_back({temp[i].second, temp[i].first});
    }
    sort(curr.begin(), curr.end());
    cout << curr[pos - 1].second << endl;
  }
}
