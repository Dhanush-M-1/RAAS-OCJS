#include <bits/stdc++.h>
using namespace std;
int arr[100010];
int main() {
  int a, b, newa, newb;
  cin >> a >> b;
  bool flag = true;
  int ans = a;
  while (true) {
    newa = a;
    newa = a / b;
    if (newa == 0) break;
    newb = a % b;
    ans += newa;
    a = newa + newb;
  }
  cout << ans;
}
