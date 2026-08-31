#include <bits/stdc++.h>
using namespace std;
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T &x) {
  int f = 0;
  cerr << '{';
  for (auto &i : x) cerr << (f++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
long long binpow(long long x, long long y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = (res * x);
    y = y >> 1;
    x = (x * x);
  }
  return res;
}
long long binpowmod(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long mod_inverse(long long n, long long p) {
  return binpowmod(n, p - 2, p);
}
long long gcd(long long x, long long y) {
  if (y == 0) return x;
  return gcd(y, x % y);
}
bool comp_pairs_by_s(pair<long long, long long> &x,
                     pair<long long, long long> &y) {
  return x.second < y.second;
}
bool isPowerOfTwo(long long x) { return x && (!(x & (x - 1))); }
class cmp {
 public:
  bool operator()(pair<int, int> A, pair<int, int> B) {
    if (abs(A.first - A.second) == abs(B.first - B.second))
      return A.first > B.first;
    return abs(A.first - A.second) < abs(B.first - B.second);
  }
};
void swap(int &x, int &y) {
  int temp = x;
  x = y;
  y = temp;
}
unsigned int onesComplement(unsigned int n) {
  int number_of_bits = floor(log2(n)) + 1;
  return ((1 << number_of_bits) - 1) ^ n;
}
bool comp1(pair<int, int> x, pair<int, int> y) { return x.second < y.second; }
void solve() {
  int n;
  cin >> n;
  vector<long long> dp(10, -100000000000000);
  dp[0] = 0;
  long long ans = 0;
  while (n--) {
    int k;
    cin >> k;
    vector<long long> card[3];
    for (int i = 0; i < 3; ++i) card[i].clear();
    for (int i = 0; i < k; ++i) {
      long long c, d;
      cin >> c >> d;
      card[--c].push_back(d);
    }
    for (int i : {0, 1, 2})
      sort(card[i].begin(), card[i].end(), greater<long long>());
    vector<long long> tmpdp(10, -100000000000000);
    tmpdp[0] = dp[0];
    auto updDP = [&](long long maxd, long long last, int cnt) {
      for (int i = 0; i < 10; ++i) {
        if ((i + cnt) >= 10 and dp[i] != -100000000000000)
          tmpdp[(i + cnt) % 10] =
              max(tmpdp[(i + cnt) % 10], dp[i] + maxd + last);
        else if (dp[i] != -100000000000000)
          tmpdp[(i + cnt) % 10] = max(tmpdp[(i + cnt) % 10], dp[i] + maxd);
      }
    };
    updDP(0, 0, 0);
    if (card[0].size()) updDP(card[0][0], card[0][0], 1);
    if (card[1].size()) updDP(card[1][0], card[1][0], 1);
    if (card[2].size()) updDP(card[2][0], card[2][0], 1);
    if (card[0].size() >= 2) updDP(card[0][0] + card[0][1], card[0][0], 2);
    if (card[0].size() and card[1].size())
      updDP(card[0][0] + card[1][0], max(card[0][0], card[1][0]), 2);
    if (card[0].size() >= 3)
      updDP(card[0][0] + card[0][1] + card[0][2], card[0][0], 3);
    dp = tmpdp;
    for (int i = 0; i < 10; ++i) ans = max(ans, dp[i]);
    ;
  }
  cout << ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout << fixed << setprecision(15);
  solve();
}
