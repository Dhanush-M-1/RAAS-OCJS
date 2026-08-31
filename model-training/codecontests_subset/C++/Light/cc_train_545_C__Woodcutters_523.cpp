#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > X;
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x, h;
    cin >> x >> h;
    X.push_back(make_pair(x, h));
  }
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  }
  sort(X.begin(), X.end());
  int cnt = 1;
  for (int i = 1; i < n - 1; i++) {
    if (X[i].first - X[i].second > X[i - 1].first) {
      cnt++;
      continue;
    }
    if (X[i].first + X[i].second < X[i + 1].first) {
      cnt++;
      X[i].first = X[i].first + X[i].second;
      continue;
    }
  }
  cnt++;
  cout << cnt;
  return 0;
}
