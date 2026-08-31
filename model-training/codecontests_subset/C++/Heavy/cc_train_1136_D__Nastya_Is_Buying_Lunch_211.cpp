#include <bits/stdc++.h>
using namespace std;
vector<long long int> graph[300000 + 1];
long long int pupil[300000 + 1];
int main() {
  ios_base::sync_with_stdio(false);
  int n, m, x, y;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> pupil[i];
  }
  for (int i = 0; i < m; i++) {
    cin >> x >> y;
    graph[x].push_back(y);
  }
  set<long long int> obs;
  obs.insert(pupil[n - 1]);
  long long int ans = 0;
  long long int found = 0;
  for (int i = n - 2; i >= 0; i--) {
    int curr = pupil[i];
    found = 0;
    for (auto x : graph[curr]) {
      if (obs.find(x) != obs.end()) {
        found++;
      }
    }
    if (found == obs.size()) {
      ans++;
    } else {
      obs.insert(curr);
    }
  }
  cout << ans << endl;
  return 0;
}
