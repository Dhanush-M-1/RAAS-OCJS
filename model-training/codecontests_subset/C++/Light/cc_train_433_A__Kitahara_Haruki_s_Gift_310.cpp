#include <bits/stdc++.h>
using namespace std;
void Solve() {
  int n;
  cin >> n;
  int One = 0, Two = 0;
  for (int64_t i = 0; i < n; ++i) {
    int x;
    cin >> x;
    if (x == 100) {
      One++;
    } else {
      Two++;
    }
  }
  if (One % 2 == 1) {
    cout << "NO" << endl;
  } else if (One == 0 && Two % 2 == 1) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
  }
}
int main() {
  ios::sync_with_stdio(NULL);
  cin.tie(NULL);
  cout.tie(NULL);
  Solve();
  return 0;
}
