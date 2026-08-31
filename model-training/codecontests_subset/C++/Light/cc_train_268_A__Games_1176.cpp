#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, h, g;
  vector<int> v1, v2;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> h >> g;
    v1.push_back(h);
    v2.push_back(g);
  }
  int ans = 0;
  for (auto it = v1.begin(); it != v1.end(); it++) {
    for (auto it2 = v2.begin(); it2 != v2.end(); it2++) {
      if (*it == *it2) ans++;
    }
  }
  cout << ans << endl;
}
