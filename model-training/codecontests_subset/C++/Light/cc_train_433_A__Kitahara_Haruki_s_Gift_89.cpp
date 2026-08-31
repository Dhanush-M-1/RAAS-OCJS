#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, tmp;
  int c100 = 0, c200 = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    if (tmp == 100)
      c100++;
    else
      c200++;
  }
  if (c100 & 1) {
    cout << "NO\n";
    return 0;
  } else if (c200 & 1 && c100 == 0) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
}
