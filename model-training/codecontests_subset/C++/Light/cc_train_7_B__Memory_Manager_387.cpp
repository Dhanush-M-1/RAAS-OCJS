#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5, mod = 1e9 + 7;
int a[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int q, m;
  cin >> q >> m;
  int c = 1;
  while (q--) {
    string s;
    cin >> s;
    if (s[0] == 'a') {
      int n;
      cin >> n;
      int kam = 0;
      bool found = 0;
      for (int i = 1; i <= m; i++) {
        if (a[i] == 0)
          kam++;
        else
          kam = 0;
        if (kam == n) {
          found = 1;
          for (int j = i; j >= i - n + 1; j--) a[j] = c;
          break;
        }
      }
      if (!found)
        cout << "NULL";
      else
        cout << c++;
      cout << '\n';
    } else if (s[0] == 'e') {
      int n;
      cin >> n;
      bool found = 0;
      for (int i = 1; i <= m; i++) {
        if (a[i] == n) {
          found = 1;
          a[i] = 0;
        }
      }
      if (!found || !n) cout << "ILLEGAL_ERASE_ARGUMENT\n";
    } else {
      vector<int> v;
      for (int i = 1; i <= m; i++) {
        if (a[i]) {
          v.push_back(a[i]);
        }
      }
      for (int i = 1; i <= m; i++) {
        a[i] = 0;
      }
      for (int i = 1; i <= v.size(); i++) {
        a[i] = v[i - 1];
      }
    }
  }
  return 0;
}
