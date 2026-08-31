#include <stdio.h>
#include <string.h>
#include <algorithm>
#include <iostream>
#include <math.h>
#include <assert.h>
#include <vector>
#include <queue>
#include <string>
#include <map>
#include <set>

using namespace std;
typedef long long ll;
typedef unsigned int uint;
typedef unsigned long long ull;
static const double EPS = 1e-9;
static const double PI = acos(-1.0);

#define REP(i, n) for (int i = 0; i < (int)(n); i++)
#define FOR(i, s, n) for (int i = (s); i < (int)(n); i++)
#define FOREQ(i, s, n) for (int i = (s); i <= (int)(n); i++)
#define FORIT(it, c) for (__typeof((c).begin())it = (c).begin(); it != (c).end(); it++)
#define MEMSET(v, h) memset((v), h, sizeof(v))

const int MOD = 10000;
string A;
string B;
int M;
short dp[2][502][502][11][2];

void Minus() {
  int index = B.size() - 1;
  while (true) {
    if (B[index] != 0) {
      B[index]--;
      break;
    }
    B[index] = 9;
    index--;
  }
  if (index == 0 && B[0] == 0) {
    B = B.substr(1);
  }
}

int calc(bool ban, int upper, int depth, int rest, int prev, int up) {
  if (!ban && dp[upper][depth][rest][prev][up] != -1) { return dp[upper][depth][rest][prev][up]; }
  if (depth == (int)B.size()) {
    return rest == 0;
  }
  int l = 0;
  int r = 9;
  if (ban) { l = 1; }
  if (upper) { r = B[depth] - '0'; }
  if (up) {
    l = prev + 1;
  } else {
    r = min(r, prev - 1);
  }
  int ret = 0;
  if (l <= r) {
    int v = up ? l : r;
    int nupper = upper && v == B[depth] - '0';
    int nrest = (rest * 10 + v) % M;
    ret += calc(false, nupper, depth + 1, nrest, v, up ^ 1);
    ret += calc(ban, upper, depth, rest, v, up);
  }
  if (ban) { return ret % MOD; }
  return dp[upper][depth][rest][prev][up] = ret % MOD;
}
int ZigZag(int depth) {
  if (depth == (int)B.size() - 1) {
    if (B.size() == 1) { return calc(true, 1, depth, 0, 10, 0); }
    return calc(true, 0, depth, 0, 10, 0);
  }
  int ans = 0;
  if (depth == 0) {
    ans = calc(true, 1, 0, 0, 10, 0) + calc(true, 1, 0, 0, 0, 1);
  } else {
    ans = calc(true, 0, depth, 0, 10, 0) + calc(true, 0, depth, 0, 0, 1);
  }
  return ans % MOD;
}

int main() {
  while (cin >> A >> B >> M) {
    int ans = 0;
    MEMSET(dp, -1);
    FOR(i, 0, B.size()) {
      ans = (ans + ZigZag(i)) % MOD;
    }
    swap(A, B);
    Minus();
    MEMSET(dp, -1);
    FOR(i, 0, B.size()) {
      ans = (ans - ZigZag(i) + MOD) % MOD;
    }
    cout << ans << endl;
  }
}