#include <bits/stdc++.h>
using namespace std;
int n, k, dai, dem, vt, ck, max1, min1, kq, tong;
int h[111];
int g[111];
void sol() {
  int i, j;
  dem = 0;
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (h[i] == g[j]) dem++;
    }
  }
  cout << dem << endl;
}
int main() {
  int i, j;
  while (scanf("%d", &n) > 0) {
    for (i = 0; i < n; i++) {
      scanf("%d %d", &h[i], &g[i]);
    }
    sol();
  }
  return 0;
}
