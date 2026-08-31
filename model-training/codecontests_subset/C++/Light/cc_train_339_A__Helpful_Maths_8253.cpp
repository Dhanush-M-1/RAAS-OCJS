#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string s;
  cin >> s;
  int j = 0;
  sort(s.begin(), s.end());
  int l = ((s.size() - 1) / 2);
  string b[2 * (s.size() - l)];
  for (int i = l; i < s.size(); i++) {
    b[2 * j] = s[i];
    j++;
  }
  for (int i = 0; i < s.size(); i++) {
    if (i & 1) {
      b[i] = "+";
    }
  }
  for (int i = 0; i < s.size(); i++) {
    cout << b[i];
  }
}
