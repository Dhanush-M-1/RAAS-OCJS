#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int ans = 0, take = 0;
  while (n) {
    ans++;
    n--;
    take++;
    if (take == k) {
      take = 0;
      n++;
    }
  }
  cout << ans << endl;
  return 0;
}
