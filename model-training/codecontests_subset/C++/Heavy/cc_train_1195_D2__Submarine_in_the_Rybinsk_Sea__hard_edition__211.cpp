#include <bits/stdc++.h>
using namespace std;
char buf[16];
int a[100005];
vector<int> bc[16];
long long sum[16][16];
int dig[100005];
const long long MOD = 998244353ll;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%s", buf);
    int dg = strlen(buf);
    sscanf(buf, "%d", a + i);
    bc[dg].push_back(a[i]);
    dig[i] = dg;
  }
  vector<int> stk;
  for (int dg1 = 1; dg1 <= 10; dg1++) {
    for (int dg2 = 1; dg2 <= 10; dg2++) {
      for (int x : bc[dg2]) {
        long long cur = 0ll;
        for (int i = 0; i < dg2; i++) {
          stk.push_back(x % 10);
          x /= 10;
        }
        reverse(stk.begin(), stk.end());
        long long cd = 1ll;
        int done = 0;
        while (!stk.empty()) {
          cd %= MOD;
          cur += cd * stk.back();
          cur %= MOD;
          stk.pop_back();
          if (done < dg1)
            cd *= 100ll;
          else
            cd *= 10ll;
          done++;
        }
        sum[dg1][dg2] += cur;
        sum[dg1][dg2] %= MOD;
      }
    }
  }
  long long ans = 0ll;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= 10; j++) {
      ans += sum[dig[i]][j];
      ans %= MOD;
      int x = a[i];
      for (int k = 0; k < dig[i]; k++) {
        stk.push_back(x % 10);
        x /= 10;
      }
      reverse(stk.begin(), stk.end());
      long long cd = 10ll;
      int done = 0;
      long long cur = 0ll;
      while (!stk.empty()) {
        cd %= MOD;
        cur += cd * stk.back();
        cur %= MOD;
        stk.pop_back();
        done++;
        if (done < j)
          cd *= 100ll;
        else
          cd *= 10ll;
      }
      cur %= MOD;
      cur *= 1ll * bc[j].size();
      cur %= MOD;
      ans += cur;
      ans %= MOD;
    }
  }
  printf("%lld\n", ans);
  return 0;
}
