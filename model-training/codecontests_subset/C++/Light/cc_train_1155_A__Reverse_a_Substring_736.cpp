#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9 + 7;
string char_to_str(char c) {
  string tem(1, c);
  return tem;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  int n;
  cin >> n;
  string s;
  cin >> s;
  string s1;
  s1 = s;
  sort(s1.begin(), s1.end());
  if (s == s1) {
    cout << "NO";
  } else {
    int i = 0;
    for (i = 0; i < s.length() - 1; ++i) {
      if (s[i] > s[i + 1]) {
        break;
      }
    }
    cout << "YES" << endl;
    cout << i + 1 << " " << i + 2;
  }
  return 0;
}
