#include <bits/stdc++.h>
using namespace std;
int a, b;
void solve() {
  int tot{a};
  while (a / b != 0) {
    tot += a / b;
    a = a / b + a % b;
  }
  cout << tot;
}
int main() {
  cin >> a >> b;
  solve();
}
