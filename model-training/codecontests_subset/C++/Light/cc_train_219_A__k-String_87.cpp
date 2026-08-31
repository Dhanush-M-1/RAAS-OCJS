#include <bits/stdc++.h>
using namespace std;
void k_string(string s, int k) {
  string a;
  int h[30] = {0};
  for (int i = 0; i < s.length(); i++) {
    h[s[i] - 97]++;
  }
  for (int i = 0; i <= 26; i++) {
    if (h[i] % k != 0 && h[i] != 0) {
      cout << "-1";
      return;
    } else {
      int x = h[i] / k;
      char ch = i + 97;
      for (int i = 0; i < x; i++) a.push_back(ch);
    }
  }
  for (int i = 0; i < k; i++) {
    cout << a;
  }
}
int main() {
  int k;
  cin >> k;
  string s;
  string a;
  cin >> s;
  k_string(s, k);
}
