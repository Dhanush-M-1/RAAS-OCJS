#include <bits/stdc++.h>
using namespace std;
void print(vector<int> v) {
  for (auto x : v) cout << x << " ";
  puts("");
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l or d > r)
      cout << d << endl;
    else
      cout << d * ((r / d) + 1) << endl;
  }
  return 0;
}
