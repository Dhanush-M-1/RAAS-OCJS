#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 10;
const int SIZ_TREE = 3e5 + 10;
char ch[100];
bool f[N];
int n;
int cnt1, f1[N];
int cnt2, f2[N];
void init() {
  bool s = true;
  cnt1 = cnt2 = 0;
  while (true) {
    scanf("%s", ch);
    if (ch[0] == '=') {
      scanf("%d", &n);
      break;
    }
    if (ch[0] == '?') {
      if (s)
        cnt1++;
      else
        cnt2++;
    } else {
      s = (ch[0] == '+');
      f[cnt1 + cnt2] = s;
    }
  }
}
void work() {
  if (cnt1 * n - cnt2 < n || cnt1 - cnt2 * n > n) {
    printf("Impossible\n");
    return;
  }
  int now = cnt1 - cnt2;
  for (int i = 1; i <= cnt1; i++) f1[i] = 1;
  for (int i = 1; i <= cnt2; i++) f2[i] = 1;
  int d;
  for (int i = 1; i <= cnt1 && now < n; i++) {
    d = min(n - now, n - f1[i]);
    f1[i] += d;
    now += d;
  }
  for (int i = 1; i <= cnt2 && now > n; i++) {
    d = min(now - n, n - f2[i]);
    f2[i] += d;
    now -= d;
  }
  int i1 = 1, i2 = 0;
  printf("Possible\n");
  printf("%d ", f1[1]);
  for (int i = 1; i < cnt1 + cnt2; i++) {
    if (f[i])
      printf("+ %d ", f1[++i1]);
    else
      printf("- %d ", f2[++i2]);
  }
  printf("= %d\n", n);
}
int main() {
  init();
  work();
  return 0;
}
