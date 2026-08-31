#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int i, j, n, m, x = 0, t, ans = 0, sum = 0;
  string s, a, b;
  bool f = 0, flag = 0;
  map<string, bool> mm;
  cin >> a >> b;
  mm[a] = 1;
  mm[b] = 1;
  cin >> n;
  cout << a << " " << b << endl;
  for (i = 0; i < n; i++) {
    cin >> a >> b;
    mm[a] = 0;
    map<string, bool>::iterator it;
    for (it = mm.begin(); it != mm.end(); it++) {
      if (mm[it->first] == 1) {
        cout << it->first;
        break;
      }
    }
    cout << " " << b << "\n";
    mm[b] = 1;
  }
  return 0;
}
