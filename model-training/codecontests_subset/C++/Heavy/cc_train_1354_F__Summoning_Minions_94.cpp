#include <bits/stdc++.h>
using namespace std;
using vi = vector<long long>;
using vvi = vector<vi>;
using vvvi = vector<vvi>;
using vvvvi = vector<vvvi>;
using vp = vector<pair<long long, long long> >;
using vvp = vector<vp>;
using vb = vector<bool>;
using vvb = vector<vb>;
const long long inf = 1001001001001001001;
const long long INF = 1001001001;
const long long mod = 1000000007;
const double eps = 1e-10;
template <class T>
bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
void out(T a) {
  cout << a << '\n';
}
template <class T>
void outp(T a) {
  cout << '(' << a.first << ',' << a.second << ')' << '\n';
}
template <class T>
void outvp(T v) {
  for (long long i = 0; i < (long long)(v.size()); i++)
    cout << '(' << v[i].first << ',' << v[i].second << ')';
  cout << '\n';
}
template <class T>
void outvvp(T v) {
  for (long long i = 0; i < (long long)(v.size()); i++) outvp(v[i]);
}
template <class T>
void outv(T v) {
  for (long long i = 0; i < (long long)(v.size()); i++) {
    if (i) cout << ' ';
    cout << v[i];
  }
  cout << '\n';
}
template <class T>
void outvv(T v) {
  for (long long i = 0; i < (long long)(v.size()); i++) outv(v[i]);
}
template <class T>
bool isin(T x, T l, T r) {
  return (l) <= (x) && (x) <= (r);
}
template <class T>
void yesno(T b) {
  if (b)
    out("yes");
  else
    out("no");
}
template <class T>
void YesNo(T b) {
  if (b)
    out("Yes");
  else
    out("No");
}
template <class T>
void YESNO(T b) {
  if (b)
    out("YES");
  else
    out("NO");
}
template <class T>
void noyes(T b) {
  if (b)
    out("no");
  else
    out("yes");
}
template <class T>
void NoYes(T b) {
  if (b)
    out("No");
  else
    out("Yes");
}
template <class T>
void NOYES(T b) {
  if (b)
    out("NO");
  else
    out("YES");
}
void outs(long long a, long long b) {
  if (a >= inf - 100)
    out(b);
  else
    out(a);
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long modpow(long long a, long long b) {
  long long res = 1;
  a %= mod;
  while (b) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return res;
}
int main() {
  long long t;
  cin >> t;
  for (long long tt = 0; tt < (long long)(t); tt++) {
    long long n, k;
    cin >> n >> k;
    vp v(n);
    for (long long i = 0; i < (long long)(n); i++)
      cin >> v[i].first >> v[i].second;
    vp s(n);
    for (long long i = 0; i < (long long)(n); i++)
      s[i] = pair<long long, long long>(v[i].second, i);
    sort(s.begin(), s.end());
    reverse(s.begin(), s.end());
    if (k == 1) {
      out(1);
      long long res = 0;
      for (long long i = 0; i < (long long)(n); i++) chmax(res, v[i].first);
      for (long long i = 0; i < (long long)(n); i++)
        if (v[i].first == res) {
          out(i + 1);
          break;
        }
      continue;
    }
    vvi dp(n + 1, vi(k + 1, -inf));
    dp[0][0] = 0;
    for (long long i = 0; i < (long long)(n); i++) {
      long long id = s[i].second;
      for (long long j = 0; j < (long long)(k + 1); j++) {
        if (dp[i][j] == -inf) continue;
        chmax(dp[i + 1][j], dp[i][j] + v[id].second * (k - 1));
        if (j != k)
          chmax(dp[i + 1][j + 1],
                dp[i][j] + v[id].first + v[id].second * (k - 1 - j));
      }
    }
    vi ans, b;
    long long c;
    long long t = k;
    for (int i = n; i; i--) {
      long long id = s[i - 1].second;
      if (dp[i - 1][t] + v[id].second * (k - 1) == dp[i][t])
        b.emplace_back(id + 1);
      else {
        if (t == 1)
          c = id + 1;
        else
          ans.emplace_back(id + 1);
        t--;
      }
    }
    for (long long x : b) {
      ans.emplace_back(x);
      ans.emplace_back(-x);
    }
    ans.emplace_back(c);
    out(ans.size());
    outv(ans);
  }
}
