#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int> > vect;
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    vect.push_back(make_pair(x, y));
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (vect[i] != vect[j]) {
        if (vect[i].first == vect[j].second) ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
