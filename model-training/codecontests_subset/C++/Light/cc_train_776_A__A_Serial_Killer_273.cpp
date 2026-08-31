#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1, s2;
  cin >> s1 >> s2;
  int n;
  cin >> n;
  vector<pair<string, string> > v(n + 1);
  for (int i = 1; i <= n; i++) {
    cin >> v[i].first >> v[i].second;
  }
  v[0] = {s1, s2};
  cout << s1 << " " << s2 << endl;
  for (int i = 1; i <= n; i++) {
    cout << v[i].second << " ";
    if (v[i - 1].first != v[i].first) {
      cout << v[i - 1].first << endl;
      v[i].first = v[i - 1].first;
    } else {
      cout << v[i - 1].second << endl;
      v[i].first = v[i - 1].second;
    }
  }
  return 0;
}
