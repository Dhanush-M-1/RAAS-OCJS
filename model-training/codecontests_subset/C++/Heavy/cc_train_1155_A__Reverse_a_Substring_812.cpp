#include <bits/stdc++.h>
using namespace std;
const long long int MOD = 1e9 + 7;
void solve() {
  long long int n;
  cin >> n;
  string s;
  cin >> s;
  string str = s;
  sort(s.begin(), s.end());
  long long int idx1 = -1;
  long long int idx2 = -1;
  bool check = true;
  if (s == str) {
    cout << "NO"
         << "\n";
    ;
    return;
  } else {
    for (int i = 0; i < str.length(); i++) {
      if (s[i] == str[i])
        continue;
      else {
        check = false;
        idx1 = i + 1;
        for (int j = i + 1; j < str.length(); j++) {
          if (str[j] == s[i]) {
            idx2 = j + 1;
            break;
          }
        }
      }
      if (check == false) break;
    }
  }
  cout << "YES"
       << "\n";
  ;
  cout << idx1 << " " << idx2 << "\n";
  ;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t = 1;
  while (t--) {
    solve();
  }
}
