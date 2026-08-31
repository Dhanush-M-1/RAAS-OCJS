#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100 + 10;
string p[MAX_N];
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  string s;
  int n;
  cin >> s >> n;
  for (int i = 0; i < n; i++) {
    cin >> p[i];
    if (p[i] == s) return cout << "YES", 0;
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (s[0] == p[i][1] && s[1] == p[j][0]) return cout << "YES", 0;
  cout << "NO";
}
