#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
template <class c>
struct rge {
  c b, e;
};
template <class c>
rge<c> range(c h, c n) {
  return {h, n};
}
template <class c>
auto dud(c* r) -> decltype(cerr << *r);
template <class c>
char dud(...);
struct muu {
  template <class c>
  muu& operator<<(const c&) {
    return *this;
  }
  muu& operator()() { return *this; }
};
const int K = 507;
const int N = 1e5 + 7;
int n, k;
int blo = K;
int a[N];
const int mod = 998244353;
int num[N];
pair<int, int> prz[K];
int off[K];
int sum[K][N];
long long qq[K];
int war[N];
int dp[N];
int ost1[N];
int ost2[N];
void changeOff(int i, int c) {
  if (c == 1 && k >= off[i]) qq[i] = (qq[i] - sum[i][k - off[i]] + mod) % mod;
  off[i] += c;
  if (c == -1 && k >= off[i]) qq[i] = (qq[i] + sum[i][k - off[i]]) % mod;
}
void czysc(int i) {
  qq[i] = 0;
  for (int j = prz[i].first; j <= prz[i].second; ++j) {
    sum[i][war[j]] = 0;
    war[j] += off[i];
  }
  off[i] = 0;
}
void przelicz(int i) {
  for (int j = prz[i].first; j <= prz[i].second; ++j) {
    sum[i][war[j]] += dp[j - 1];
    sum[i][war[j]] %= mod;
    if (war[j] <= k) {
      qq[i] += dp[j - 1];
      qq[i] %= mod;
    }
  }
}
void add(int i, int j, int c) { war[j] += c; }
void insert(int i, int j, int v) {
  dp[j] = v;
  czysc(i);
  przelicz(i);
}
int query(int i) {
  (muu() << __FUNCTION__ << "#" << 87 << ": ") << "["
                                                  "i"
                                                  ": "
                                               << (i)
                                               << "] "
                                                  "["
                                                  "qq[i]"
                                                  ": "
                                               << (qq[i]) << "] ";
  return (qq[i] % mod + mod) % mod;
}
void wstaw(int a, int b, int c) {
  (muu() << __FUNCTION__ << "#" << 92 << ": ") << "["
                                                  "a"
                                                  ": "
                                               << (a)
                                               << "] "
                                                  "["
                                                  "b"
                                                  ": "
                                               << (b)
                                               << "] "
                                                  "["
                                                  "c"
                                                  ": "
                                               << (c) << "] ";
  int i = num[a];
  czysc(i);
  for (int j = a; j <= b && j <= prz[i].second; ++j) {
    add(i, j, c);
  }
  przelicz(i);
  i++;
  while (i < num[b]) {
    changeOff(i, c);
    i++;
  }
  if (i == num[b]) {
    czysc(i);
    for (int j = prz[i].first; j <= b; ++j) {
      add(i, j, c);
    }
    przelicz(i);
  }
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
  blo = min(blo, n);
  for (int i = 1; i <= n; ++i) {
    num[i] = (blo * (i - 1)) / n;
  }
  for (int i = 1; i <= n; ++i) {
    prz[num[i]].second = i;
  }
  for (int i = n; i > 0; --i) {
    prz[num[i]].first = i;
  }
  int wynik = 0;
  dp[0] = 1;
  for (int i = 1; i <= n; ++i) {
    int x = a[i];
    if (ost1[x]) {
      wstaw(ost2[x] + 1, ost1[x], -1);
    }
    wstaw(ost1[x] + 1, i, 1);
    ost2[x] = ost1[x];
    ost1[x] = i;
    long long res = 0;
    for (int j = 0; j < blo; ++j) {
      res += query(j);
    }
    res %= mod;
    wynik = res;
    (muu() << __FUNCTION__ << "#" << 142 << ": ") << "["
                                                     "i"
                                                     ": "
                                                  << (i)
                                                  << "] "
                                                     "["
                                                     "wynik"
                                                     ": "
                                                  << (wynik) << "] ";
    insert(num[i], i, wynik);
  }
  printf("%d\n", wynik);
  return 0;
}
