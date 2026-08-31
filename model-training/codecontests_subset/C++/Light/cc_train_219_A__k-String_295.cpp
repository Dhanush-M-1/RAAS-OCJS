#include <bits/stdc++.h>
using namespace std;
int main() {
  map<char, int> a;
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    a[s[i]]++;
  }
  string ans;
  int x = 1;
  for (auto it : a) {
    if (it.second % n != 0) {
      cout << -1;
      return 0;
    }
  }
  string p = "";
  sort(s.begin(), s.end());
  for (int i = 0; i < s.size(); i++) {
    if ((i + 1) % n == 0) p += s[i];
  }
  for (int i = 0; i < n; i++) cout << p;
}
