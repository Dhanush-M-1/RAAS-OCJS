#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const int MX = 2e6 + 8;
map<string, int> mp;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string name1, name2;
  cin >> name1 >> name2;
  int n;
  cin >> n;
  vector<pair<string, string> > a;
  a.push_back({name1, name2});
  for (int i = 0; i < n; i++) {
    string x, y;
    cin >> x >> y;
    a.push_back({x, y});
  }
  string cur1, cur2;
  cur1 = a[0].first;
  cur2 = a[0].second;
  cout << cur1 << ' ' << cur2 << '\n';
  for (int i = 1; i <= n; i++) {
    string prev1 = a[i].first;
    string prev2 = a[i].second;
    if (prev1 == cur1) {
      cur1 = cur2;
      cur2 = prev2;
    } else if (prev1 == cur2) {
      cur2 = cur1;
      cur1 = prev2;
    } else if (prev2 == cur1) {
      cur1 = cur2;
      cur2 = prev1;
    } else if (prev2 == cur2) {
      cur2 = cur1;
      cur1 = prev1;
    }
    cout << cur1 << ' ' << cur2 << '\n';
  }
  return 0;
}
