#include <bits/stdc++.h>
using namespace std;
set<int> s;
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  int d;
  for (int i = 0; i < n; i++) {
    scanf("%d", &d);
    while (d--) {
      int x;
      scanf("%d", &x);
      s.insert(x);
    }
  }
  if (s.size() == m)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
