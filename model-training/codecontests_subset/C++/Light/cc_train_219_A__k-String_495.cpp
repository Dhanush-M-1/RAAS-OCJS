#include <bits/stdc++.h>
using namespace std;
struct TP {};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  int ar[26];
  for (int i = 0; i < 26; i++) ar[i] = 0;
  string s;
  cin >> n >> s;
  int ln = (int)(s.length());
  for (int i = 0; i < ln; i++) ar[s[i] - 'a']++;
  for (int i = 0; i < 26; i++) {
    if (ar[i] % n) {
      cout << -1;
      return 0;
    }
  }
  for (int k = 0; k < n; k++) {
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < ar[i] / n; j++) {
        cout << (char)(i + 'a');
      }
    }
  }
  return 0;
}
