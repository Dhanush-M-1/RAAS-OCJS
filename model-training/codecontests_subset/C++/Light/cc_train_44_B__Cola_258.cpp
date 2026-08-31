#include <bits/stdc++.h>
using namespace std;
const int inf = 1000005;
const int N = 105;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  n *= 2;
  int ans = 0;
  for (int i = 0; i <= a; i++) {
    for (int j = 0; j <= b; j++) {
      int remain = i + 2 * j;
      remain = n - remain;
      if (remain >= 0 && remain % 4 == 0 && remain / 4 <= c) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
