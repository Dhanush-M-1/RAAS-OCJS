#include <bits/stdc++.h>
using namespace std;
int n, k, cnt;
int main() {
  cin >> n >> k;
  while (n - k + 1 > 0) {
    n -= k;
    cnt += k;
    n++;
  }
  cout << cnt + n;
  return 0;
}
