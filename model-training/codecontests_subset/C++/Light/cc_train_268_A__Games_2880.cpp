#include <bits/stdc++.h>
using namespace std;
int main() {
  pair<int, int> p[35];
  int n, a, b, ans = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> b;
    p[i] = make_pair(a, b);
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (p[i].first == p[j].second) ans++;
    }
  }
  cout << ans << endl;
}
