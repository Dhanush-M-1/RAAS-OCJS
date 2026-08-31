#include <bits/stdc++.h>
using namespace std;
void solve() {
  int s = 0;
  for (int i = 0; i < 5; i++) {
    int x;
    cin >> x;
    s += x;
  }
  if (s > 0 && s % 5 == 0)
    cout << s / 5 << "\n";
  else
    cout << "-1\n";
}
int main() {
  solve();
  return 0;
}
