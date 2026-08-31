#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, f = 0;
  cin >> n;
  string s, ga = "";
  cin >> s;
  unordered_map<char, long long int> map;
  for (long long int i = 0; i < s.length(); i++) map[s[i]]++;
  for (auto &x : map) {
    if (x.second % n != 0) {
      cout << "-1";
      f = 0;
      break;
    } else {
      int no = x.second / n;
      while (no--) ga += x.first;
      f = 1;
    }
  }
  if (f == 1) {
    while (n--) cout << ga;
  }
  return 0;
}
