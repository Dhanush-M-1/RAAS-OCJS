#include <bits/stdc++.h>
using namespace std;
bool is_prime(long long n) {
  for (long long i = 2; i * i <= n; ++i) {
    if (n % i == 0) {
      return false;
    }
  }
  return true;
}
vector<long long> fact(long long n) {
  n = abs(n);
  vector<long long> ans;
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      ans.push_back(i);
      ans.push_back(n / i);
    }
  }
  return ans;
}
inline long long getPow(long long a, long long b) {
  long long res = 1ll, tp = a;
  while (b) {
    if (b & 1ll) {
      res *= tp;
    }
    tp *= tp;
    b >>= 1ll;
  }
  return res;
}
long long vec_mult(long long x1, long long y1, long long x2, long long y2,
                   long long x3, long long y3) {
  return abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));
}
void ok() {
  cout << "YES" << endl;
  exit(0);
}
void no() {
  cout << "NO" << endl;
  exit(0);
}
inline long long nxt() {
  long long x;
  cin >> x;
  return x;
}
const long long N = 3e5 + 5, inf = 8e18;
int days[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  long long n = nxt();
  vector<vector<long long>> g(n);
  for (int i = 1; i < n; i++) {
    long long t1 = nxt() - 1, t2 = nxt() - 1;
    g[t1].push_back(t2);
    g[t2].push_back(t1);
  }
  map<long long, long long> mp;
  for (auto x : g) {
    if (x.size() == 2) {
      no();
    }
  }
  ok();
  return 0;
}
