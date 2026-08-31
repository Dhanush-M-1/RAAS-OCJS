#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 5;
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
int n, m;
set<int> all;
int use[101];
void miracle() {
  int n, m;
  cin >> n >> m;
  memset(use, 0, sizeof(use));
  int r = 0;
  for (int t = 0; t < n; t++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int l, OK = 0;
      cin >> l;
      for (int i = 0; i + l <= m; i++) {
        int ok = 1;
        for (int j = 0; j < l; j++)
          if (use[i + j]) ok = 0;
        if (ok) {
          OK = 1;
          r++;
          for (int j = 0; j < l; j++) use[i + j] = r;
          all.insert(r);
          cout << r << endl;
          break;
        }
      }
      if (!OK) cout << "NULL" << endl;
    } else if (s == "erase") {
      int x;
      cin >> x;
      if (all.find(x) == all.end())
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        all.erase(x);
        for (int j = 0; j < m; j++)
          if (use[j] == x) use[j] = 0;
      }
    } else {
      int mm = 0;
      for (int j = 0; j < m; j++) {
        if (use[j] != 0) {
          use[mm] = use[j];
          mm++;
        }
      }
      for (int j = mm; j < m; j++) use[j] = 0;
    }
  }
  return;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  miracle();
  return 0;
}
