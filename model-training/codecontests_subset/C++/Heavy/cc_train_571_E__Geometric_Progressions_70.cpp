#include <bits/stdc++.h>
using namespace std;
const int Max_N(105);
int N, _A[Max_N], _B[Max_N];
map<int, long long int> A[Max_N], B[Max_N];
long long int limit;
long long int gcd(long long int a, long long int b) {
  return b == 0LL ? a : gcd(b, a % b);
}
inline long long int lcm(long long int a, long long int b) {
  return a / gcd(a, b) * b;
}
void GG() {
  printf("-1");
  exit(0);
}
void calc(int n, map<int, long long int> &S) {
  for (int p = 2, e; p * p <= n; ++p)
    if (n % p == 0) {
      e = 0;
      while (n % p == 0) n /= p, ++e;
      S[p] = e;
    }
  if (n > 1) S[n] = 1;
}
set<int> S;
void merge(int a, int b) {
  S.clear();
  for (map<int, long long int>::iterator it = A[a].begin(); it != A[a].end();
       ++it)
    S.insert(it->first);
  for (map<int, long long int>::iterator it = B[a].begin(); it != B[a].end();
       ++it)
    S.insert(it->first);
  for (map<int, long long int>::iterator it = A[b].begin(); it != A[b].end();
       ++it)
    S.insert(it->first);
  for (map<int, long long int>::iterator it = B[b].begin(); it != B[b].end();
       ++it)
    S.insert(it->first);
}
namespace PrintAns {
const int MOD(1000000000 + 7);
constexpr int Mult(int a, int b) { return a * 1LL * b % MOD; }
int power(int a, long long int n) {
  int Ret(1);
  while (n) {
    if (n & 1LL) Ret = Mult(Ret, a);
    a = Mult(a, a), n >>= 1LL;
  }
  return Ret;
}
void printAns(long long int x) { printf("%d", Mult(_A[1], power(_B[1], x))); }
}  // namespace PrintAns
void print(long long int x1) {
  if (x1 < 0LL) GG();
  for (int i = 2; i <= N; ++i) {
    merge(1, i);
    set<long long int> qwq;
    for (set<int>::iterator it = S.begin(); it != S.end(); ++it) {
      int p = *it;
      long long int xi = B[1][p] * x1 + A[1][p] - A[i][p];
      if (B[i][p] == 0LL)
        if (xi == 0LL)
          continue;
        else
          GG();
      if (xi < 0LL) GG();
      if (xi % B[i][p]) GG();
      qwq.insert(xi / B[i][p]);
    }
    if (qwq.size() > 1) GG();
  }
  PrintAns::printAns(x1), exit(0);
}
constexpr long long int Abs(long long int x) { return x >= 0LL ? x : -x; }
pair<long long int, long long int> get(pair<long long int, long long int> a) {
  if (a.second < 0LL) a.second = -a.second, a.first = -a.first;
  if (a.first == 0LL)
    a.second = 1LL;
  else {
    long long int d = gcd(Abs(a.first), Abs(a.second));
    a.first /= d, a.second /= d;
  }
  return a;
}
inline pair<long long int, long long int> operator-(
    const pair<long long int, long long int> &a,
    const pair<long long int, long long int> &b) {
  long long int l = lcm(a.second, b.second);
  return get(make_pair(a.first * (l / a.second) - b.first * (l / b.second), l));
}
inline pair<long long int, long long int> operator/(
    const pair<long long int, long long int> &a,
    const pair<long long int, long long int> &b) {
  return get(make_pair(a.first * b.second, a.second * b.first));
}
void exgcd(long long int a, long long int b, long long int &x,
           long long int &y) {
  if (b == 0LL)
    x = 1LL, y = 0LL;
  else
    exgcd(b, a % b, y, x), y -= x * (a / b);
}
inline long long int inverse(long long int a, long long int MOD) {
  long long int invx, invy;
  exgcd(a, MOD, invx, invy);
  return (invx % MOD + MOD) % MOD;
}
inline long long int Add(long long int a, long long int b, long long int MOD) {
  return a + b >= MOD ? a + b - MOD : a + b;
}
inline long long int Mult(long long int a, long long int b, long long int MOD) {
  return a * b % MOD;
}
long long int A1, MOD1;
inline void merge(long long int A2, long long int MOD2) {
  long long int d = gcd(MOD1, MOD2), sub = (((A2 - A1) % MOD2 + MOD2) % MOD2);
  if (sub % d) GG();
  long long int k1, k2;
  exgcd(MOD1, MOD2, k1, k2), k1 *= sub / d;
  A1 = k1 * MOD1 + A1, MOD1 = lcm(MOD1, MOD2), A1 = (A1 % MOD1 + MOD1) % MOD1;
}
inline void insert(long long int k, long long int A2, long long int MOD2) {
  k = (k % MOD2 + MOD2) % MOD2;
  A2 = (A2 % MOD2 + MOD2) % MOD2;
  if (k == 0LL)
    if (A2 == 0LL)
      return;
    else
      GG();
  long long int d = gcd(k, MOD2);
  if (A2 % d) GG();
  k /= d, A2 /= d, MOD2 /= d;
  A2 = Mult(A2, inverse(k, MOD2), MOD2);
  merge(A2, MOD2);
}
int main() {
  scanf("%d", &N);
  for (int i = 1; i <= N; ++i)
    scanf("%d%d", _A + i, _B + i), calc(_A[i], A[i]), calc(_B[i], B[i]);
  A1 = 0LL, MOD1 = 1LL;
  for (int i = 2; i <= N; ++i) {
    merge(1, i);
    map<pair<long long int, long long int>, pair<long long int, long long int> >
        rec;
    for (set<int>::iterator it = S.begin(); it != S.end(); ++it) {
      int p = *it;
      if (B[i][p] == 0LL)
        if (B[1][p] == 0LL) {
          if (A[1][p] != A[i][p]) GG();
        } else
          print((A[i][p] - A[1][p]) / B[1][p]);
      else {
        rec[get(make_pair(B[1][p], B[i][p]))] =
            get(make_pair(A[1][p] - A[i][p], B[i][p]));
        if (A[i][p] - A[1][p] > 0LL) {
          if (B[1][p] == 0LL) GG();
          limit = max(limit, (A[i][p] - A[1][p]) / B[1][p]);
          while (B[1][p] * limit < A[i][p] - A[1][p]) ++limit;
        }
        insert(B[1][p], A[i][p] - A[1][p], B[i][p]);
      }
    }
    if (rec.size() >= 2) {
      pair<long long int, long long int> k1 = rec.begin()->first,
                                         b1 = rec.begin()->second;
      pair<long long int, long long int> k2 = rec.rbegin()->first,
                                         b2 = rec.rbegin()->second;
      pair<long long int, long long int> x = (b2 - b1) / (k1 - k2);
      if (x.second != 1LL) GG();
      print(x.first);
    }
  }
  long long int k = (limit - A1) / MOD1;
  k = max(k, 0LL);
  while (k * MOD1 + A1 < limit) ++k;
  print(k * MOD1 + A1);
  return 0;
}
