#include <bits/stdc++.h>
using namespace std;
int a[2000];
int b[2000];
int main() {
  int m;
  cin >> m;
  while (m--) {
    memset(a, 0, sizeof(a));
    memset(b, 0, sizeof(b));
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int j = 0; j < k; j++) cin >> b[j];
    sort(a, a + n);
    sort(b, b + k);
    int num = 0;
    int flag;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        flag = 0;
        if (b[j] == a[i]) {
          flag = 1;
          num = a[i];
          break;
        }
      }
      if (flag == 1) break;
    }
    if (num != 0) {
      cout << "YES" << endl;
      ;
      cout << 1 << ' ' << num << endl;
    } else
      cout << "NO" << endl;
  }
}
