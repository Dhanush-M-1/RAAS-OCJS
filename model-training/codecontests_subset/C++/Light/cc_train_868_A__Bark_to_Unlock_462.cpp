#include <bits/stdc++.h>
using namespace std;
int n;
string s, t;
vector<string> v;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> s >> n;
  while (n--) {
    cin >> t;
    v.push_back(t);
  }
  for (int i = 0; i < v.size(); ++i) {
    if (v[i] == s) {
      cout << "YES" << endl;
      return 0;
    }
    if (v[i][1] == s[0]) {
      for (int j = 0; j < v.size(); ++j) {
        if (v[j][0] == s[1]) {
          cout << "YES" << endl;
          return 0;
        }
      }
    }
  }
  cout << "NO" << endl;
  return 0;
}
