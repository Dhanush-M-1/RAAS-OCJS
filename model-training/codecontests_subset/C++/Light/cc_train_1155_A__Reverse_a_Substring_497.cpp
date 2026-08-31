#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int maxn = 1e6 + 10;
string l;
int main() {
  int n;
  scanf("%d", &n);
  cin >> l;
  bool flag = false;
  int x, y;
  for (int i = 0; i < n - 1; ++i) {
    if (l[i + 1] < l[i]) {
      flag = true;
      y = i + 2;
      x = i + 1;
      break;
    }
  }
  if (flag) {
    cout << "YES" << endl;
    cout << x << " " << y << endl;
  } else
    cout << "No" << endl;
  return 0;
}
