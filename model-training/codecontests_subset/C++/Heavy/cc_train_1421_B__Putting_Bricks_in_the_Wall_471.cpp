#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    string s[n];
    for (long long i = 0; i < n; i++) {
      cin >> s[i];
    }
    vector<pair<long long, long long> > arr;
    if (s[0][1] == '0' || s[1][0] == '0') {
      if (s[n - 1][n - 2] == '1' || s[n - 2][n - 1] == '1') {
        if (s[0][1] == '1') {
          arr.push_back(make_pair(1, 2));
        }
        if (s[1][0] == '1') {
          arr.push_back(make_pair(2, 1));
        }
        if (s[n - 1][n - 2] == '0') {
          arr.push_back(make_pair(n, n - 1));
        }
        if (s[n - 2][n - 1] == '0') {
          arr.push_back(make_pair(n - 1, n));
        }
      } else {
        if (s[0][1] == '0') {
          arr.push_back(make_pair(1, 2));
        }
        if (s[1][0] == '0') {
          arr.push_back(make_pair(2, 1));
        }
      }
    } else {
      if (s[n - 1][n - 2] == '1') {
        arr.push_back(make_pair(n, n - 1));
      }
      if (s[n - 2][n - 1] == '1') {
        arr.push_back(make_pair(n - 1, n));
      }
    }
    cout << arr.size() << endl;
    for (long long i = 0; i < arr.size(); i++) {
      cout << arr[i].first << " " << arr[i].second << endl;
    }
  }
}
