#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, i, j;
  string s;
  cin >> n >> s;
  long long int a[26];
  memset(a, 0, sizeof(a));
  for (i = 0; i < s.length(); i++) {
    a[s[i] - 'a']++;
  }
  long long int f = 0;
  for (i = 0; i < 26; i++) {
    if (a[i] % n != 0) {
      cout << -1;
      f = 1;
      break;
    }
  }
  vector<char> vc;
  if (f == 0) {
    for (i = 0; i < 26; i++) {
      for (j = 0; j < a[i] / n; j++) {
        vc.push_back(char(i + 'a'));
      }
    }
    for (i = 0; i < n; i++) {
      for (auto k = vc.begin(); k != vc.end(); k++) {
        cout << *k;
      }
    }
  }
}
