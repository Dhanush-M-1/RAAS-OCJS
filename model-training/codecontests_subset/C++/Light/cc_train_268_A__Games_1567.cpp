#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 0;
  vector<pair<int, int> > uniforms;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a, b;
    cin >> a >> b;
    uniforms.push_back(make_pair(a, b));
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (uniforms[i].first == uniforms[j].second) ++ans;
    }
  }
  cout << ans << endl;
}
