#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, last1 = "", last2 = "";
  cin >> a >> b;
  int n;
  cin >> n;
  vector<pair<string, string> > ans;
  ans.push_back({a, b});
  for (int i = 0; i < n; i++) {
    string tmp, tmp1;
    cin >> tmp >> tmp1;
    if (tmp == a) {
      a = tmp1;
      ans.push_back({a, b});
    } else {
      b = tmp1;
      ans.push_back({a, b});
    }
  }
  for (int i = 0; i < ans.size(); i++)
    cout << ans[i].first << " " << ans[i].second << "\n";
}
