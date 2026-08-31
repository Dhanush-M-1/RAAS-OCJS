#include <bits/stdc++.h>
using namespace std;
int n, m, l, r;
int main() {
  cin >> n;
  while (n--) {
    cin >> m;
    if (m == 100)
      l++;
    else
      r++;
  }
  if (l & 1)
    cout << "NO";
  else if (r & 1) {
    if (!l)
      cout << "NO";
    else
      cout << "YES";
  } else {
    cout << "YES";
  }
  return 0;
}
