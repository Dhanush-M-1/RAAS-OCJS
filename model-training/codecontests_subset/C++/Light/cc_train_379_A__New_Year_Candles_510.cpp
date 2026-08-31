#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int ans = 0;
  int add = 0;
  for (int i = a; i > 0; i--) {
    ans++;
    add++;
    if (add == b) {
      i++;
      add = 0;
    }
  }
  cout << ans;
}
