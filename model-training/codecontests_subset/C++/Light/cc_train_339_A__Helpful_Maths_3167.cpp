#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, k = "";
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (i % 2 == 0) k += s[i];
  }
  sort(k.begin(), k.end());
  for (int i = 0; i < k.size(); i++) {
    cout << k[i];
    if (i != k.size() - 1) cout << "+";
  }
  return 0;
}
