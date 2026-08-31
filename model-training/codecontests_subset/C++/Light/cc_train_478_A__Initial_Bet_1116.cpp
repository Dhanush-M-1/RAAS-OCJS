#include <bits/stdc++.h>
using namespace std;
long long s;
long long temp;
int main() {
  ios::sync_with_stdio(false);
  int n = 5;
  s = 0;
  while (n--) {
    cin >> temp;
    s += temp;
  }
  if (s % 5 == 0 && s / 5 != 0) {
    cout << s / 5;
  } else {
    cout << -1;
  }
  return 0;
}
