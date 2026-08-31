#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  ;
  int n;
  cin >> n;
  string s;
  cin >> s;
  map<char, int> mp;
  for (int i = 0; i < n; i++) mp[s[i]] = i;
  for (int i = 0; i < n; i++) {
    char x = s[i];
    for (char c = 'a'; c < x; c++) {
      if (mp[c] > i) return (cout << "YES\n" << i + 1 << " " << (mp[c] + 1), 0);
    }
  }
  cout << "NO";
}
