#include <bits/stdc++.h>
using namespace std;
int br[26];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, i, j;
  string s;
  cin >> n >> s;
  for (i = n - 1; i >= 0; i--) {
    br[s[i] - 'a'] = i;
    for (j = s[i] - 'a' - 1; j >= 0; j--)
      if (br[j]) {
        cout << "YES\n" << i + 1 << " " << br[j] + 1 << '\n';
        return 0;
      }
  }
  cout << "NO\n";
}
