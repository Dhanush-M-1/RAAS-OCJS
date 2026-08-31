#include <bits/stdc++.h>
using namespace std;
struct node {
  int t, l, r, w;
};
struct node num[5010];
int n, m;
int a[5010], b[5010];
int main(int argc, char const *argv[]) {
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    cin >> num[i].t >> num[i].l >> num[i].r >> num[i].w;
  }
  memset(a, 0x3f3f3f3f, sizeof(a));
  for (int i = m; i >= 1; i--) {
    if (num[i].t == 1) {
      for (int j = num[i].l; j <= num[i].r; j++) {
        if (a[j] < 0x3f3f3f3f) {
          a[j] -= num[i].w;
        }
      }
    } else {
      for (int j = num[i].l; j <= num[i].r; j++) {
        if (a[j] > num[i].w) {
          a[j] = num[i].w;
        }
      }
    }
  }
  memcpy(b, a, sizeof(a));
  int f = 1;
  for (int i = 1; i <= m; i++) {
    if (num[i].t == 1) {
      for (int j = num[i].l; j <= num[i].r; j++) {
        a[j] += num[i].w;
      }
    } else {
      int maxx = -0x3f3f3f3f;
      for (int j = num[i].l; j <= num[i].r; j++) {
        if (maxx < a[j]) {
          maxx = a[j];
        }
      }
      if (maxx != num[i].w) {
        f = 0;
        break;
      }
    }
  }
  if (!f) {
    printf("NO\n");
  } else {
    printf("YES\n");
    for (int i = 1; i <= n; i++) {
      if (i != 1) printf(" ");
      if (b[i] >= 1000000000)
        printf("1000000000");
      else
        printf("%d", b[i]);
    }
  }
  return 0;
}
