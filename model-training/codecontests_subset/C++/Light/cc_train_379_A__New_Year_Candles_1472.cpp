#include <bits/stdc++.h>
using namespace std;
int n, m, cnt, rem;
int main() {
  cin >> n >> m;
  rem = cnt = n;
  while (rem >= m) {
    rem -= m;
    cnt++;
    rem++;
  }
  cout << cnt;
  return 0;
}
