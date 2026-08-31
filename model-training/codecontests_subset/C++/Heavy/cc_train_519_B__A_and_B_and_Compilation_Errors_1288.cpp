#include <bits/stdc++.h>
using namespace std;
int i, j, k, n, m, x, y, T, ans, big, cas, num, len;
bool flag;
map<int, int> a, b;
int main() {
  scanf("%d", &n);
  a.clear();
  b.clear();
  int x;
  for (i = 1; i <= n; i++) {
    scanf("%d", &x);
    a[x]++;
    b[x]++;
  }
  for (i = 1; i <= n - 1; i++) {
    scanf("%d", &x);
    a[x]--;
  }
  for (i = 1; i <= n - 2; i++) {
    scanf("%d", &x);
    b[x]--;
  }
  int fir;
  for (map<int, int>::iterator j = a.begin(); j != a.end(); j++) {
    if (j->second) {
      fir = j->first;
      break;
    }
  }
  int sec = -1;
  int num = 0;
  int ans[100];
  for (map<int, int>::iterator j = b.begin(); j != b.end(); j++) {
    if (j->second) {
      for (i = 1; i <= j->second; i++) ans[num++] = j->first;
    }
  }
  printf("%d\n%d\n", fir, fir == ans[0] ? ans[1] : ans[0]);
  return 0;
}
