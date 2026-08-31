#include <bits/stdc++.h>
using namespace std;
const int maxn = 2000;
char a[maxn], b[maxn];
int c[maxn];
int main() {
  int n, cnt1 = 1, flag1 = 0;
  cin >> n >> a;
  memset(c, 0, sizeof(c));
  sort(a, a + strlen(a));
  for (int i = 0; i < strlen(a); i++) {
    if (a[i] == a[i + 1]) {
      cnt1++;
    } else {
      if (cnt1 % n == 0) {
        c[i] = cnt1;
        cnt1 = 1;
      } else {
        cout << "-1" << endl;
        flag1 = 1;
        break;
      }
    }
  }
  int p = 0;
  if (!flag1) {
    for (int j = 0; j < strlen(a); j++) {
      if (c[j] != 0) {
        for (int k = 1; k <= c[j] / n; k++) {
          b[p++] = a[j];
        }
      }
    }
    for (int m = 0; m < n; m++) {
      cout << b;
    }
    cout << endl;
  }
  return 0;
}
