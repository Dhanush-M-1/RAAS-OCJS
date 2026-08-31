#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n;
  cin >> n;
  while (n--) {
    int t;
    cin >> t;
    map<int, int> mp;
    int a[t], b[3];
    for (int i = 0; i < t; i++) {
      cin >> a[i];
      mp[a[i]] = i + 1;
    }
    sort(b, b + 3);
    if (a[0] + a[1] > a[t - 1]) {
      cout << -1;
    } else {
      cout << 1 << " " << 2 << " " << t;
    }
    cout << endl;
  }
}
