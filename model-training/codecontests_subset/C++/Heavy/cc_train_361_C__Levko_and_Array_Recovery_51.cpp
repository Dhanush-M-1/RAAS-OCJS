#include <bits/stdc++.h>
using namespace std;
int N, M;
vector<pair<pair<pair<int, int>, long long>, vector<long long> > > ranges;
long long ans[5001];
long long best[5001];
int main() {
  cin >> N >> M;
  vector<long long> offset(N + 1);
  for (int i = 0; i < M; ++i) {
    int a, b, c;
    long long d;
    cin >> a >> b >> c >> d;
    if (a == 1) {
      for (int j = b; j <= c; ++j) {
        offset[j] += d;
      }
    } else {
      ranges.push_back(make_pair(make_pair(make_pair(b, c), d), offset));
    }
  }
  bool possible = true;
  for (int i = 1; i <= N; ++i) {
    ans[i] = 1000000000;
    best[i] = 1000000000;
    for (int j = 0; j < ranges.size(); ++j) {
      int left = ranges[j].first.first.first;
      int right = ranges[j].first.first.second;
      long long val = ranges[j].first.second;
      ranges[j].second;
      if (left <= i && i <= right) {
        ans[i] = min(ans[i], val - ranges[j].second[i]);
      }
    }
  }
  for (int j = 0; j < ranges.size(); ++j) {
    int left = ranges[j].first.first.first;
    int right = ranges[j].first.first.second;
    long long val = ranges[j].first.second;
    bool b = false;
    for (int i = left; i <= right; ++i) {
      if (ans[i] + ranges[j].second[i] == val) {
        b = true;
      } else if (ans[i] + ranges[j].second[i] > val) {
        possible = false;
      }
    }
    if (!b) {
      possible = false;
    }
  }
  if (possible) {
    cout << "YES" << endl;
    for (int i = 1; i <= N; ++i) {
      if (i != 1) {
        cout << " ";
      }
      cout << ans[i];
    }
    cout << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
