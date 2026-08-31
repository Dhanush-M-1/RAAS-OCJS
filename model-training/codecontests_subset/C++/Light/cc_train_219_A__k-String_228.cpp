#include <bits/stdc++.h>
using namespace std;
string s;
int n;
int main() {
  cin >> n >> s;
  vector<int> v(26);
  for (auto x : s) v[x - 'a']++;
  for (auto x : v)
    if (x && (x < n || x % n)) {
      cout << "-1\n";
      return 0;
    }
  string x = "";
  for (int i = 0; i < 26; ++i)
    for (int j = 0, d = v[i] / n; j < d; ++j) x += i + 'a';
  for (int i = 0; i < n; ++i) cout << x;
  cout << "\n";
}
