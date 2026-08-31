#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int a, b;
  cin >> a >> b;
  int ans = 0, good = a, burnt = 0;
  while (true) {
    ans += good;
    int p = burnt;
    if (good + p < b) break;
    burnt = (good + p) % b;
    good = (good + p) / b;
  }
  cout << ans;
}
