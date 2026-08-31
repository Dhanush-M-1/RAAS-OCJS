#include <bits/stdc++.h>
using namespace std;
const int MAXN = 10005;
map<string, bool> map1;
int main() {
  int n;
  string a, b, x, y;
  cin >> a >> b;
  map1[a] = false;
  map1[b] = false;
  cin >> n;
  cout << a << " " << b << endl;
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    map1[x] = true;
    if (!map1[a]) {
      cout << a << " " << y << endl;
      b = y;
    } else {
      cout << y << " " << b << endl;
      a = y;
    }
  }
  return 0;
}
