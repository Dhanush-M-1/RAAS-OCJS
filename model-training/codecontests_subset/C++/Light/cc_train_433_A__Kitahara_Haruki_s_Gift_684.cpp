#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, p, w, h = 0;
  cin >> n;
  p = n;
  while (n--) {
    cin >> w;
    if (w == 100) h++;
  }
  if (h % 2 != 0) {
    cout << "NO";
  } else if (p % 2 != 0 && h == 0) {
    cout << "NO";
  } else {
    cout << "YES";
  }
  cout << "\n";
  ;
  return 0;
}
