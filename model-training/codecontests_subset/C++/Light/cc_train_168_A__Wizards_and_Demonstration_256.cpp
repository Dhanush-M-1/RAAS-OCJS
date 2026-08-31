#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, x, y, numClones = 0;
  cin >> n >> x >> y;
  float percent = (float)(x) / n * 100;
  while (percent < y) {
    x++;
    numClones++;
    percent = (float)(x) / n * 100;
  }
  cout << numClones << '\n';
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  solve();
}
