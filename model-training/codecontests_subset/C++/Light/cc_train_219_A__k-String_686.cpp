#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(NULL), cin.tie(NULL), cout.tie(NULL);
  int n;
  cin >> n;
  string c;
  cin >> c;
  vector<int> isp(27, 0);
  for (int i = 0; i < c.length(); ++i) {
    isp[c[i] - 'a']++;
  }
  for (int i = 0; i < 26; ++i) {
    if (isp[i] % n != 0) {
      cout << "-1\n";
      return 0;
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 26; j++) {
      if (isp[j] != 0) {
        for (int r = 0; r < (isp[j] / n); r++) {
          cout << (char)(j + 'a');
        }
      }
    }
  }
  return 0;
}
