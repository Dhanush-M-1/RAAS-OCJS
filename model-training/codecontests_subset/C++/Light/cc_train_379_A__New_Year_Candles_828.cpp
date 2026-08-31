#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int t = 0, ans = 0;
  while (n != 0) {
    ans++;
    t++;
    n--;
    if (t == k) {
      n++;
      t -= k;
    }
  }
  cout << ans;
  return 0;
}
