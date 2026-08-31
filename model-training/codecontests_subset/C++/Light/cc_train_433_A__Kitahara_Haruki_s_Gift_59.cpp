#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  int cnt1 = 0, cnt2 = 0, temp;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    if (temp == 100)
      cnt1++;
    else
      cnt2++;
  }
  if (cnt1 == 0) {
    if (cnt2 % 2 == 0)
      cout << "YES\n";
    else
      cout << "NO\n";
  } else if (cnt2 == 0) {
    if (cnt1 % 2 == 0)
      cout << "YES\n";
    else
      cout << "NO\n";
  } else {
    int diff = -1;
    cnt1 *= 100;
    cnt2 *= 200;
    if (cnt1 > cnt2)
      diff = cnt1 - cnt2;
    else
      diff = cnt2 - cnt1;
    if (diff % 200 == 0)
      cout << "YES\n";
    else
      cout << "NO\n";
  }
  return 0;
}
