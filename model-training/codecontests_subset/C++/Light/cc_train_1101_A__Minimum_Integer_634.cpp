#include <bits/stdc++.h>
using namespace std;
int main(int argc, char **argv) {
  int n, a;
  cin >> n;
  int l, r, d;
  for (int i = 0; i < n; i++) {
    cin >> l >> r >> d;
    cout << (l - d <= 0 ? r - (r % d) + d : d) << endl;
  }
  return 0;
}
