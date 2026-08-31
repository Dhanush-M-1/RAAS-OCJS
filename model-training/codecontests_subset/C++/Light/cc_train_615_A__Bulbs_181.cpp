#include <bits/stdc++.h>
using namespace std;
set<int> v1;
int main() {
  int b, c, i, p, j, x;
  cin >> b >> c;
  for (i = 1; i <= b; i++) {
    cin >> p;
    for (j = 1; j <= p; j++) {
      cin >> x;
      if (x <= c) v1.insert(x);
    }
  }
  if (v1.size() == c)
    cout << "YES\n";
  else
    cout << "NO\n";
  v1.clear();
}
