#include <bits/stdc++.h>
using namespace std;
int Max(int a, int b) { return (((b - a) >> (32 - 1)) & (a ^ b)) ^ b; }
int Min(int a, int b) { return (((b - a) >> (32 - 1)) & (a ^ b)) ^ a; }
long long GCD(long long a, long long b) { return b != 0 ? GCD(b, a % b) : a; }
long long LCM(long long a, long long b) { return a * (b / GCD(a, b)); }
long long Pow(long long n, long long e) {
  if (e == 0) return 1;
  if (e == 1)
    return n;
  else if (e & 1) {
    long long t = Pow(n, e / 2);
    return n * t * t;
  } else {
    long long t = Pow(n, e / 2);
    return t * t;
  }
}
bool used[20][20];
bool dp[20][20];
int nextt[20][20];
int fours[20][20];
int sevens[20][20];
string num;
bool DP(int id, int carry) {
  if (id == (int)(num).size()) {
    if (carry == 0) return true;
    return false;
  }
  if (used[id][carry]) return dp[id][carry];
  used[id][carry] = true;
  for (int f = 0, max_ = (7); f < max_; ++f)
    for (int s = 0, max_ = (7); s < max_; ++s) {
      if (f + s > 6) continue;
      int n = 4 * f + 7 * s;
      int c = n / 10;
      int r = n % 10;
      if (carry < c) continue;
      int req = (num[id] - '0') - r;
      if (carry > c) req += 10 * (carry - c);
      if (req < 0 || req > 10) continue;
      bool res = DP(id + 1, req);
      if (res) {
        fours[id][carry] = f;
        sevens[id][carry] = s;
        nextt[id][carry] = req;
        return dp[id][carry] = true;
      }
    }
  return dp[id][carry] = false;
}
int main() {
  long long N;
  int T;
  scanf("%d", &T);
  for (int i = 0, max_ = (T); i < max_; ++i) {
    cin >> num;
    memset(used, false, sizeof(used));
    ;
    memset(dp, false, sizeof(dp));
    ;
    bool r = DP(0, 0);
    if (r) {
      long long r[6] = {0, 0, 0, 0, 0, 0};
      int carry = 0;
      long long exp = Pow(10, (int)(num).size() - 1);
      for (int i = 0, max_ = ((int)(num).size()); i < max_; ++i) {
        for (int j = 0, max_ = (fours[i][carry]); j < max_; ++j)
          r[j] += 4 * exp;
        for (int j = 0, max_ = (sevens[i][carry]); j < max_; ++j)
          r[j + fours[i][carry]] += 7 * exp;
        carry = nextt[i][carry];
        exp /= 10;
      }
      printf("%I64d %I64d %I64d %I64d %I64d %I64d\n", r[0], r[1], r[2], r[3],
             r[4], r[5]);
    } else
      printf("-1\n");
  }
  return 0;
}
