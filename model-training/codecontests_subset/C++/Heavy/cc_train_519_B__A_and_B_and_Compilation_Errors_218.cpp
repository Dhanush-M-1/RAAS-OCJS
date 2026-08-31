#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  map<int, bool> mp;
  int n, k;
  cin >> n;
  vector<int> v(n), v0(n - 1), v1(n - 2);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> v0[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> v1[i];
  }
  sort(v.begin(), v.end());
  sort(v0.begin(), v0.end());
  sort(v1.begin(), v1.end());
  int g = 0;
  for (int i = 0; i < n - 1; i++) {
    if (v[i] != v0[i]) {
      cout << v[i] << endl;
      g = 1;
      break;
    }
  }
  if (g == 0) cout << v[v.size() - 1] << endl;
  g = 0;
  for (int i = 0; i < n - 2; i++) {
    if (v1[i] != v0[i]) {
      cout << v0[i] << endl;
      g = 1;
      break;
    }
  }
  if (g == 0) cout << v0[v0.size() - 1] << endl;
}
