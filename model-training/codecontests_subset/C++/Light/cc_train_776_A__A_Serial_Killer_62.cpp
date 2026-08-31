#include <bits/stdc++.h>
using namespace std;
map<string, string> mp;
vector<pair<string, string>> ans;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string f, s;
  cin >> f >> s;
  int n;
  cin >> n;
  ans.push_back({f, s});
  for (int i = 0; i < n; i++) {
    string a, b;
    cin >> a >> b;
    if (a == f) {
      ans.push_back({b, s});
      f = b;
    } else {
      ans.push_back({f, b});
      s = b;
    }
  }
  for (int i = 0; i < n + 1; i++)
    cout << ans[i].first << " " << ans[i].second << '\n';
  return 0;
}
