#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int a, b;
  cin >> a >> b;
  int cnt = a;
  while (a >= b) {
    a = a - b + 1;
    cnt++;
  }
  cout << cnt;
  return 0;
}
