#include <bits/stdc++.h>
using namespace std;
const int MAXN = 110000;
int ele[100];
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int rev(int x) {
  int l = 0;
  while (x) {
    ele[++l] = x % 10;
    x /= 10;
  }
  for (int i = 1; i <= l; i++) {
    x = x * 10 + ele[i];
  }
  return x;
}
struct Solve {
  map<int, int> fac[MAXN];
  int now;
  void init(int x) {
    for (int i = 1; i <= x; i++) fac[i].clear();
    now = 0;
  }
  void add() {
    now++;
    int a = now, b = rev(now);
    int c = gcd(a, b);
    b /= c;
    a /= c;
    fac[b][a]++;
  }
  void del() {
    int a = now, b = rev(now);
    int c = gcd(a, b);
    a /= c;
    b /= c;
    fac[b][a]--;
    now--;
  }
  int calc(int x) {
    int a = x, b = rev(x);
    int c = gcd(a, b);
    a /= c;
    b /= c;
    return fac[a][b];
  }
} solve[2];
int ansx, ansy;
long long ans = (1ll << 60);
int main() {
  int mx, my, k;
  scanf("%d %d %d", &mx, &my, &k);
  solve[0].init(mx);
  solve[1].init(my);
  long long now = 0;
  for (int i = 1; i <= my; i++) {
    solve[1].add();
  }
  for (int i = 1; i <= mx; i++) {
    now += solve[1].calc(i);
    solve[0].add();
    while (1) {
      if (solve[1].now == 0) break;
      int tmp = solve[0].calc(solve[1].now);
      if (now - tmp >= k) {
        solve[1].del();
        now -= tmp;
      } else {
        break;
      }
    }
    if (now >= k && (long long)solve[0].now * solve[1].now < ans) {
      ans = (long long)solve[0].now * solve[1].now;
      ansx = solve[0].now;
      ansy = solve[1].now;
    }
  }
  if (ans == (1ll << 60)) {
    printf("-1\n");
  } else {
    printf("%d %d\n", ansx, ansy);
  }
  return 0;
}
