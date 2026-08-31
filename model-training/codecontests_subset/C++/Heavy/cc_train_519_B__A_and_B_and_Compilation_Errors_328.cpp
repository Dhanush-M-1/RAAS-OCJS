#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v, mis, vis;
  for (int i = 0, x; i < n; i++) {
    cin >> x;
    v.push_back(x);
  }
  sort(v.begin(), v.end());
  for (int i = 0, x; i < n - 1; i++) {
    cin >> x;
    mis.push_back(x);
  }
  for (int i = 0, x; i < n - 2; i++) {
    cin >> x;
    vis.push_back(x);
  }
  sort(mis.begin(), mis.end());
  sort(vis.begin(), vis.end());
  int i;
  for (i = 0; i < n; i++) {
    if (v[i] - mis[i] != 0) break;
  }
  cout << v[i] << "\n";
  v.erase(v.begin() + i);
  for (i = 0; i < n - 1; i++) {
    if (v[i] - vis[i] != 0) break;
  }
  cout << v[i] << "\n";
  return 0;
}
