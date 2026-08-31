#include <bits/stdc++.h>
using namespace std;
int main() {
  if (false) {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
  }
  int n;
  cin >> n;
  int ni = 0;
  int na = 0;
  int nf = 0;
  for (int i = 0; i < n; i++) {
    char b;
    cin >> b;
    if (b == 'I') {
      ni++;
    } else if (b == 'A') {
      na++;
    } else if (b == 'F') {
      nf++;
    } else {
      cout << "wrong char" << endl;
      return -1;
    }
  }
  int ans;
  if (ni > 1) {
    ans = 0;
  } else if (ni == 1) {
    ans = 1;
  } else {
    ans = na;
  }
  cout << ans << endl;
  if (false) {
    fclose(stdin);
    fclose(stdout);
  }
  return 0;
}
