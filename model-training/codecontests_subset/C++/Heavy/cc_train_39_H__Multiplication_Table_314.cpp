#include <bits/stdc++.h>
using namespace std;
int a[110][110], c[100010];
long long mn = 1e9, mx = -1e9, ans, cnt, sm;
bool ok, okk, used[1000010], use[10];
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < 10; i++) {
    a[1][i] = i;
  }
  for (int i = 1; i < 10; i++) {
    a[i][1] = i;
  }
  for (int i = 2; i < 10; i++) {
    for (int j = 2; j < 10; j++) {
      a[i][j] = i * j;
    }
  }
  for (int i = 1; i < k; i++) {
    string s = "";
    for (int j = 1; j < k; j++) {
      s = "";
      int x = a[i][j];
      while (x) {
        s += (x % k + '0');
        x /= k;
      }
      cout.width(3);
      reverse(s.begin(), s.end());
      cout << s;
    }
    cout << endl;
  }
  return 0;
}
