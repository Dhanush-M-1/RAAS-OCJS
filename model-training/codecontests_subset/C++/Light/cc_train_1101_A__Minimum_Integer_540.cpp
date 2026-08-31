#include <bits/stdc++.h>
using namespace std;
int q;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> q;
  int l, r, d;
  for (int _ = 0; _ < (signed)(q); _++) {
    cin >> l >> r >> d;
    if (l > d)
      cout << d;
    else
      cout << ((r + d) / d) * d;
    cout << "\n";
  }
  return 0;
}
