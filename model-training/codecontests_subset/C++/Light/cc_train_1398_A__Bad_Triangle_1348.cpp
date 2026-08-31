#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5e4 + 5;
int a[MAXN];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    int sum = a[0] + a[1];
    int c = -1;
    for (int i = 2; i < n; i++) {
      if (a[i] >= sum) {
        c = i;
        break;
      }
    }
    if (c == -1) {
      cout << c << endl;
    } else {
      cout << "1 2 " << c + 1 << endl;
    }
  }
  return 0;
}
