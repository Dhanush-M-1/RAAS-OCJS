#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, freq[27];
  string s;
  for (int i = 0; i < 27; i++) freq[i] = 0;
  cin >> k;
  cin >> s;
  for (int i = 0; i < s.length(); i++) freq[s[i] - 'a']++;
  for (int i = 0; i < 27; i++) {
    if (freq[i] % k) {
      cout << -1;
      goto end;
    }
  }
  for (int i = 0; i < k; i++) {
    for (int j = 0; j < 27; j++) {
      for (int l = 0; l < freq[j] / k; l++) {
        cout << char(j + 'a');
      }
    }
  }
end:
  return 0;
}
