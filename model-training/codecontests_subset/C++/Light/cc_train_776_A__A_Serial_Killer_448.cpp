#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, n;
  string t, p, tt, pp;
  cin >> t >> p;
  cout << t << " " << p << endl;
  cin >> n;
  while (n--) {
    cin >> tt >> pp;
    if (t.compare(tt) == 0)
      t.assign(pp);
    else
      p.assign(pp);
    cout << t << " " << p << endl;
  }
}
