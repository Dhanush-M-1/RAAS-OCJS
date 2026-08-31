#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, c1 = 0, c2 = 0, s = 0, a;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    s += a;
    if (a == 100)
      c1++;
    else
      c2++;
  }
  if ((s / 100) & 1 || (c2 & 1 && !c1))
    cout << "NO";
  else
    cout << "YES";
  return 0;
}
