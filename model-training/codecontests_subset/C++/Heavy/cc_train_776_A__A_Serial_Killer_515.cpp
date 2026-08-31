#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  string s1, s2;
  while (cin >> s1 >> s2) {
    long long int n;
    cin >> n;
    vector<pair<string, string>> v;
    v.push_back({s1, s2});
    for (long long int i = 1; i <= n; i++) {
      string s3, s4;
      cin >> s3 >> s4;
      if (s3 == v[i - 1].first) {
        v.push_back({s4, v[i - 1].second});
      } else if (s3 == v[i - 1].second) {
        v.push_back({v[i - 1].first, s4});
      }
    }
    for (long long int i = 0; i < v.size(); i++) {
      cout << v[i].first << " " << v[i].second << endl;
    }
  }
  return 0;
}
