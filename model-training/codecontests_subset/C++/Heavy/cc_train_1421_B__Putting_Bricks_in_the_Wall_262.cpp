#include <bits/stdc++.h>
using namespace std;
const long long INF64 = 1e18;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int chu;
  cin >> chu;
  while (chu--) {
    long long int n;
    cin >> n;
    string s[n];
    for (long long int i = 0; i < n; i++) cin >> s[i];
    if (s[0][1] == s[1][0]) {
      int ct = 0;
      vector<pair<int, int> > v;
      char c = s[0][1];
      if (s[n - 1][n - 2] == c) {
        ct++;
        v.push_back({n, n - 1});
      }
      if (s[n - 2][n - 1] == c) {
        ct++;
        v.push_back({n - 1, n});
      }
      cout << ct << "\n";
      for (long long int i = 0; i < v.size(); i++)
        cout << v[i].first << " " << v[i].second << "\n";
    } else if (s[n - 2][n - 1] == s[n - 1][n - 2]) {
      int ct = 0;
      vector<pair<int, int> > v;
      char c = s[n - 1][n - 2];
      if (s[0][1] == c) {
        ct++;
        v.push_back({1, 2});
      }
      if (s[1][0] == c) {
        ct++;
        v.push_back({2, 1});
      }
      cout << ct << "\n";
      for (long long int i = 0; i < v.size(); i++)
        cout << v[i].first << " " << v[i].second << "\n";
    } else {
      cout << 2 << "\n";
      if (s[0][1] != '0') {
        cout << 1 << " " << 2 << "\n";
      } else {
        cout << 2 << " " << 1 << "\n";
      }
      if (s[n - 1][n - 2] != '1') {
        cout << n << " " << n - 1 << "\n";
      } else {
        cout << n - 1 << " " << n << "\n";
      }
    }
  }
  return 0;
}
