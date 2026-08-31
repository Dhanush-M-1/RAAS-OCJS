#include <bits/stdc++.h>
using namespace std;
int ms[100005];
int main() {
  int a, b;
  cin >> a >> b;
  int ans = a;
  int tmp;
  while (true) {
    int new_s = a / b;
    ans += new_s;
    a = new_s + (a % b);
    if (a < b) break;
  }
  cout << ans << endl;
  return 0;
}
