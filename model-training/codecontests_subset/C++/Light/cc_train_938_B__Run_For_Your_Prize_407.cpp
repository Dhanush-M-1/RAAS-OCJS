#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false), cin.tie(0);
  int n;
  cin >> n;
  int ma = 0;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    ma = max(ma, min(a - 1, 1000000 - a));
  }
  cout << ma << endl;
  return 0;
}
