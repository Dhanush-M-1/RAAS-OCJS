#include <bits/stdc++.h>
using namespace std;
struct team {
  int h, a;
};
int main() {
  int n;
  cin >> n;
  team t[n];
  for (int i = 0; i < n; i++) cin >> t[i].h >> t[i].a;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i == j) continue;
      if (t[i].h == t[j].a) ans++;
    }
  }
  cout << ans << endl;
}
