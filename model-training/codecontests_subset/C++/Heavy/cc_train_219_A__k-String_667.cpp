#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long n;
  cin >> n;
  string s;
  cin >> s;
  if (n == 1)
    cout << s << "\n";
  else {
    if (s.length() % n)
      cout << "-1"
           << "\n";
    else {
      vector<long long> v(26, 0);
      for (long long i = 0; i < s.length(); i++) v[s[i] - 'a']++;
      for (long long i = 0; i < v.size(); i++) {
        if (v[i] % n) {
          cout << "-1"
               << "\n";
          return 0;
        }
      }
      for (long long i = 0; i < n; i++) {
        for (long long j = 0; j < v.size(); j++) {
          char ch = j + 'a';
          for (long long k = 0; k < v[j] / n; k++) {
            cout << ch;
          }
        }
      }
    }
  }
}
