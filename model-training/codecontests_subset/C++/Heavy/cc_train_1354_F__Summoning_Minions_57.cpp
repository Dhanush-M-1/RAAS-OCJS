#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1);
const double eps = 1e-12;
const int inf = 2000000000;
const long long int infLL = (long long int)1e18;
long long int MOD = 1000000007;
int MOD1 = 1000000007;
int MOD2 = 1000000009;
inline bool checkBit(long long int n, long long int i) {
  return n & (1LL << i);
}
inline long long int setBit(long long int n, long long int i) {
  return n | (1LL << i);
  ;
}
inline long long int resetBit(long long int n, long long int i) {
  return n & (~(1LL << i));
}
int dx[] = {0, 0, +1, -1};
int dy[] = {+1, -1, 0, 0};
inline bool EQ(double a, double b) { return fabs(a - b) < 1e-9; }
inline bool isLeapYear(long long int year) {
  return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
}
inline void normal(long long int &a) {
  a %= MOD;
  (a < 0) && (a += MOD);
}
inline long long int modMul(long long int a, long long int b) {
  a %= MOD, b %= MOD;
  normal(a), normal(b);
  return (a * b) % MOD;
}
inline long long int modAdd(long long int a, long long int b) {
  a %= MOD, b %= MOD;
  normal(a), normal(b);
  return (a + b) % MOD;
}
inline long long int modSub(long long int a, long long int b) {
  a %= MOD, b %= MOD;
  normal(a), normal(b);
  a -= b;
  normal(a);
  return a;
}
inline long long int modPow(long long int b, long long int p) {
  long long int r = 1LL;
  while (p) {
    if (p & 1) r = modMul(r, b);
    b = modMul(b, b);
    p >>= 1LL;
  }
  return r;
}
inline long long int modDiv(long long int a, long long int b) {
  return modMul(a, modPow(b, MOD - 2));
}
bool comp(const pair<long long int, pair<long long int, long long int> > &p1,
          const pair<long long int, pair<long long int, long long int> > &p2) {
  return p1.first > p2.first;
}
bool comp1(const pair<long long int, long long int> &p1,
           const pair<long long int, long long int> &p2) {
  if (p1.first == p2.first) {
    return p1.second > p2.second;
  }
  return p1.first < p2.first;
}
long long int converter(string a) {
  long long int i, mul = 1LL, r, t, ans = 0LL;
  if (a.length() == 0) return 0;
  for (i = a.length() - 1; i >= 0; i--) {
    t = a[i] - '0';
    r = t % 10;
    ans += (mul * r);
    mul = mul * 10;
  }
  return ans;
}
int msb(unsigned x) {
  union {
    double a;
    int b[2];
  };
  a = x;
  return (b[1] >> 20) - 1023;
}
const int MAX = 78;
int t, n, k;
pair<pair<long long int, long long int>, long long int> p[MAX];
long long int dp[MAX][MAX];
vector<long long int> good, bad;
long long int solve(int idx, int cnt) {
  if (idx == n + 1) {
    if (cnt != k) return -infLL;
    return 0;
  }
  if (dp[idx][cnt] != -1) return dp[idx][cnt];
  long long int ret = -infLL;
  if (cnt + 1 <= k) {
    ret = max(ret, cnt * p[idx].first.first + p[idx].first.second +
                       solve(idx + 1, cnt + 1));
  }
  ret = max(ret, ((k - 1) * p[idx].first.first) + solve(idx + 1, cnt));
  return dp[idx][cnt] = ret;
}
void trace(int idx, int cnt) {
  if (idx == n + 1) return;
  long long int ret1 = -infLL, ret2 = -infLL;
  if (cnt + 1 <= k)
    ret1 = cnt * p[idx].first.first + p[idx].first.second +
           solve(idx + 1, cnt + 1);
  ret2 = ((k - 1) * p[idx].first.first) + solve(idx + 1, cnt);
  if (ret1 >= ret2) {
    good.push_back(p[idx].second);
    trace(idx + 1, cnt + 1);
  } else {
    bad.push_back(p[idx].second);
    trace(idx + 1, cnt);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cout.unsetf(ios::floatfield);
  cout.precision(20);
  cout.setf(ios::fixed, ios::floatfield);
  ;
  cin >> t;
  while (t--) {
    good.clear();
    bad.clear();
    long long int maxi = 0, idx;
    cin >> n >> k;
    for (int i = 1; i <= n; ++i) {
      cin >> p[i].first.second >> p[i].first.first;
      p[i].second = i;
      if (p[i].first.second >= maxi) maxi = p[i].first.second, idx = i;
    }
    if (k == 1) {
      cout << 1 << '\n';
      cout << idx << '\n';
      continue;
    }
    sort(p + 1, p + n + 1);
    memset(dp, -1, sizeof(dp));
    long long int now = solve(1, 0);
    trace(1, 0);
    cout << good.size() + (2 * bad.size()) << '\n';
    for (int i = 0; i < good.size() - 1; ++i) {
      cout << good[i] << " ";
    }
    for (int i = 0; i < bad.size(); ++i) {
      cout << bad[i] << " " << -1 * bad[i] << " ";
    }
    cout << good[good.size() - 1] << '\n';
  }
  return 0;
}
