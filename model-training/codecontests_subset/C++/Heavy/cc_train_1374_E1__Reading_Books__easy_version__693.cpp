#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, t, a, b;
  int all[200000];
  int Alice[200000];
  int Bob[200000];
  int numAll = 0;
  int numAlice = 0;
  int numBob = 0;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> t >> a >> b;
    if (a == b && a == 1) {
      all[numAll] = t;
      numAll++;
    } else if (a == 1) {
      Alice[numAlice] = t;
      numAlice++;
    } else if (b == 1) {
      Bob[numBob] = t;
      numBob++;
    }
  }
  sort(all, all + numAll);
  sort(Alice, Alice + numAlice);
  sort(Bob, Bob + numBob);
  int x = 0;
  int y = 0;
  int ans = 0;
  if (numAll + min(numAlice, numBob) >= k) {
    for (int i = 0; i < k; i++) {
      if (x >= numAll) {
        ans += Alice[y] + Bob[y];
        y++;
        continue;
      }
      if (y >= min(numAlice, numBob)) {
        ans += all[x];
        x++;
        continue;
      }
      if (all[x] <= Alice[y] + Bob[y]) {
        ans += all[x];
        x++;
      } else {
        ans += Alice[y] + Bob[y];
        y++;
      }
    }
  } else {
    ans = -1;
  }
  cout << ans << endl;
}
