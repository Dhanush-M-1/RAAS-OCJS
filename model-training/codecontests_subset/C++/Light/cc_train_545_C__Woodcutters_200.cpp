#include <bits/stdc++.h>
using namespace std;
struct tree {
  int x, h;
};
int main() {
  int n;
  cin >> n;
  vector<tree> t(n);
  for (int i = 0; i < n; i++) {
    cin >> t[i].x >> t[i].h;
  }
  if (n == 1) {
    cout << 1;
    return 0;
  }
  int now = t[0].x;
  int a = 1;
  for (int i = 1; i < n - 1; i++) {
    if (t[i].x - t[i].h > now) {
      now = t[i].x;
      a++;
    } else if (t[i].x + t[i].h < t[i + 1].x) {
      now = t[i].x + t[i].h;
      a++;
    } else {
      now = t[i].x;
    }
  }
  cout << a + 1;
  return 0;
}
