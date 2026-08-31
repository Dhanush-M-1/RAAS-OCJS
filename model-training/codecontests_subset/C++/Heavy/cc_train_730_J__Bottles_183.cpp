#include <bits/stdc++.h>
using namespace std;
long long mem[101][10010], t[101][10010];
long long n, a[101], b[101], total;
long long dp(long long cur, long long ob) {
  if (ob == 0) {
    t[cur][ob] = 0;
    return 0;
  }
  if (n == cur) {
    t[cur][ob] = 999999;
    return 200;
  }
  long long &ret = mem[cur][ob];
  if (ret != -1) return ret;
  long long cob, x;
  if (ob < b[cur]) {
    x = ob - a[cur];
    cob = 0;
  } else {
    cob = ob - b[cur];
    x = b[cur] - a[cur];
  }
  ret = 1 + dp(cur + 1, cob);
  t[cur][ob] = x + t[cur + 1][cob];
  if (ret == dp(cur + 1, ob)) {
    t[cur][ob] = min(t[cur][ob], t[cur + 1][ob]);
  } else if (ret > dp(cur + 1, ob)) {
    ret = dp(cur + 1, ob);
    t[cur][ob] = t[cur + 1][ob];
  }
  return ret;
}
int main() {
  long long total = 0;
  memset(mem, -1, sizeof(mem));
  scanf("%lld", &n);
  for (long long i = 0; i < n; i++) {
    scanf("%lld", a + i);
    total += a[i];
  }
  for (long long i = 0; i < n; i++) scanf("%lld", b + i);
  cout << dp(0, total);
  printf(" ");
  cout << t[0][total] << endl;
  return 0;
}
