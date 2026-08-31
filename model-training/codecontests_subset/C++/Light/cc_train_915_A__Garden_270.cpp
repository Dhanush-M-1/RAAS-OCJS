#include <bits/stdc++.h>
const int INF = -0x3f3f3f3f;
using namespace std;
int main() {
  int n;
  int k;
  int a[105];
  cin >> n >> k;
  int min_1 = INF;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] > min_1 && k % a[i] == 0) {
      min_1 = a[i];
    }
  }
  int res = k / min_1;
  cout << res << endl;
  return 0;
}
