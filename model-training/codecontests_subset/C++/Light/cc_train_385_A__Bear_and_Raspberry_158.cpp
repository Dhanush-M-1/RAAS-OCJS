#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, c, temp;
  cin >> n >> c;
  pair<int, int> p;
  vector<int> v;
  for (int i = 0; i < int(n); ++i) {
    cin >> temp;
    v.push_back(temp);
  }
  p.first = v[0];
  p.second = v[1];
  if (n > 2) {
    for (int i = 1; i < n - 1; ++i) {
      if (p.first - p.second < v[i] - v[i + 1]) {
        p.first = v[i];
        p.second = v[i + 1];
      }
    }
  }
  int ans = p.first - p.second - c;
  ans = (ans > 0) ? ans : 0;
  cout << ans << endl;
}
