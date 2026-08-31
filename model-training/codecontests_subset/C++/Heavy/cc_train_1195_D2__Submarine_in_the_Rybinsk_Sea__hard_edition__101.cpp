#include <bits/stdc++.h>
using namespace std;
const long long int inf = 1e17;
const long long int mod = 998244353;
const long long int MOD = 998244353;
template <class c>
struct rge {
  c b, e;
};
template <class c>
rge<c> range(c i, c j) {
  return rge<c>{i, j};
}
template <class c>
auto dud(c *x) -> decltype(cerr << *x, 0);
template <class c>
char dud(...);
struct debug {
  template <class c>
  debug &operator<<(const c &) {
    return *this;
  }
};
vector<char *> tokenizer(const char *args) {
  char *token = new char[111];
  strcpy(token, args);
  token = strtok(token, ", ");
  vector<char *> v({token});
  while ((token = strtok(NULL, ", "))) v.push_back(token);
  return reverse(v.begin(), v.end()), v;
}
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
void debugg(vector<char *> args) { cerr << "\b\b "; }
#pragma clang diagnostic pop
template <typename Head, typename... Tail>
void debugg(vector<char *> args, Head H, Tail... T) {
  debug() << " [" << args.back() << ": " << H << "] ";
  args.pop_back();
  debugg(args, T...);
}
template <typename T>
T power(T a, T b) {
  if (b == 0) return 1;
  if (b == 1)
    return a;
  else {
    T res = (power(a, b / 2));
    if (b % 2)
      return (res * res * a);
    else
      return res * res;
  }
}
template <typename T>
T power(T a, T b, T modulo) {
  if (b == 0) return 1;
  if (b == 1)
    return a;
  else {
    T res = (power(a, b / 2, modulo) % modulo);
    if (b % 2)
      return ((((res % modulo) * (res % modulo)) % modulo) * (a % modulo)) %
             modulo;
    else
      return ((res % modulo) * (res % modulo)) % modulo;
  }
}
template <typename T>
T gcd(T a, T b) {
  if (b == 0) {
    return a;
  }
  return gcd(b, a % b);
}
void factorial(vector<long long int> &fact, long long int n) {
  fact.resize(n + 1, 1);
  fact[0] = 1;
  fact[1] = 1;
  for (int i = 2; i <= n; ++i) {
    fact[i] = ((fact[i - 1] % mod) * (i % mod)) % mod;
  }
}
long long int mod_inv(long long int a) {
  return (power<long long int>(a, mod - 2, mod)) % mod;
}
long long int ncr(long long int n, long long int r,
                  vector<long long int> &fact) {
  if (r > n or n < 0 or r < 0) return 0LL;
  return (((fact[n] % mod) * (mod_inv(fact[n - r]) % mod)) % mod *
          (mod_inv(fact[r]) % mod)) %
         mod;
}
vector<long long int> cnt(20, 0);
long long int as_i(long long int n) {
  vector<long long int> d;
  long long int ans = 0ll;
  while (n > 0) {
    d.emplace_back(n % 10);
    n /= 10;
  }
  for (long long int j = 1; j <= 10; ++j) {
    n = cnt[j];
    if (n == 0) continue;
    string s;
    long long int p = 0;
    long long int k = 0, l = 0;
    long long int i = 0;
    while (((long long int)(s).size()) != ((long long int)(d).size()) + j and
           k < ((long long int)(d).size()) and l < j) {
      if (p) {
        s.push_back('1');
        k++;
      } else {
        s.push_back('0');
        l++;
      }
      i++;
      p = p ^ 1;
    }
    while (((long long int)(s).size()) != ((long long int)(d).size()) + j and
           k < ((long long int)(d).size())) {
      s.push_back('1');
      k++;
      i++;
    }
    while (((long long int)(s).size()) != ((long long int)(d).size()) + j and
           l < j) {
      s.push_back('1');
      l++;
      i++;
    }
    {};
    long long int val = 0;
    for (int m = 0;
         m < ((long long int)(s).size()) and val < ((long long int)(d).size());
         ++m) {
      if (s[m] == '0') continue;
      ans = (ans + n * power<long long int>(10, m, mod) * d[val] % mod) % mod;
      val++;
    }
  }
  return ans;
}
long long int as_j(long long int n) {
  vector<long long int> d;
  long long int ans = 0ll;
  while (n > 0) {
    d.emplace_back(n % 10);
    n /= 10;
  }
  for (long long int j = 1; j <= 10; ++j) {
    n = cnt[j];
    if (n == 0) continue;
    string s;
    long long int p = 0;
    long long int k = 0, l = 0;
    long long int i = 0;
    while (((long long int)(s).size()) != ((long long int)(d).size()) + j and
           k < ((long long int)(d).size()) and l < j) {
      if (p) {
        s.push_back('0');
        l++;
      } else {
        s.push_back('1');
        k++;
      }
      i++;
      p = p ^ 1;
    }
    {};
    while (((long long int)(s).size()) != ((long long int)(d).size()) + j and
           k < ((long long int)(d).size())) {
      s.push_back('1');
      k++;
      i++;
    }
    while (((long long int)(s).size()) != ((long long int)(d).size()) + j and
           l < j) {
      s.push_back('0');
      l++;
      i++;
    }
    {};
    long long int val = 0;
    for (int m = 0;
         m < ((long long int)(s).size()) and val < ((long long int)(d).size());
         ++m) {
      if (s[m] == '0') continue;
      ans = (ans + n * power<long long int>(10, m, mod) * d[val] % mod) % mod;
      val++;
    }
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long int n;
  cin >> n;
  vector<long long int> v(n - 1 + 1);
  for (auto i = 0; i <= n - 1; i++) {
    cin >> v[i];
  };
  long long int ans = 0ll;
  map<long long int, long long int> mp;
  for (int i = 0; i < n; ++i) {
    long long int x = v[i];
    long long int d = 0;
    while (x > 0) {
      d++;
      x /= 10;
    }
    mp[d]++;
  }
  for (auto &[a, b] : mp) {
    cnt[a] = b;
  }
  for (int i = 0; i < n; ++i) {
    ans = (ans + as_i(v[i])) % mod;
    ans = (ans + as_j(v[i])) % mod;
  }
  ans %= mod;
  cout << ((ans)) << "\n";
  ;
  return 0;
}
