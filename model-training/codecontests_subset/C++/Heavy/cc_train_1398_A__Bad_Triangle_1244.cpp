#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const long long long_max = 9223372036854775807;
const long long inf = INT_MAX;
void pr(long long n) { cout << (n) << "\n"; }
void pr(string s) { cout << (s) << "\n"; }
void pr(string s, string s2) { cout << (s) << " " << (s2) << "\n"; }
void pr(pair<long long, long long> p) {
  cout << (p).first << " " << (p).second << "\n";
};
void pr(long long a, long long b) { cout << (a) << " " << (b) << "\n"; }
void pr(long long a, long long b, long long c) {
  cout << (a) << " " << (b) << " " << (c) << "\n";
}
void pr(long long a, long long b, long long c, long long d) {
  cout << (a) << " " << (b) << " " << (c) << " " << (d) << "\n";
}
void pr(long long a, long long b, long long c, long long d, long long e) {
  cout << (a) << " " << (b) << " " << (c) << " " << (d) << " " << (e) << "\n";
}
void pr(vector<long long> v) {
  for (int i = 0; i < v.size(); ++i) cout << v[i] << " ";
  cout << "\n";
}
void pr(vector<string> v) {
  for (int i = 0; i < v.size(); ++i) cout << v[i] << " ";
  cout << "\n";
}
void decimal(int);
long long min(long long, long long);
long long max(long long, long long);
long long multi(long long, long long);
long long add(long long, long long);
long long subtract(long long, long long);
long long modpower(long long, long long);
long long gcd(long long, long long);
long long modinv(long long, long long);
long long power(long long, long long);
long long divi(long long, long long);
void subsetsUtil(vector<long long>&, vector<vector<long long> >&,
                 vector<long long>&, long long);
vector<vector<long long> > subsets(vector<long long>&);
long long ncrmod(long long, long long, long long);
long long ncr(long long, long long);
long long npr(long long, long long);
long long nprmod(long long, long long);
vector<string> permutations(string);
void makeCombiUtil(vector<vector<long long> >&, vector<long long>&, long long,
                   long long, long long);
vector<vector<long long> > makeCombi(long long, long long);
void printSubSeqRec(string, long long, long long, string);
void printSubSeq(string);
bool comp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first == b.first)
    return a.second < b.second;
  else
    return a.first < b.first;
}
long long numdigit(long long n) {
  long long cnt = 0;
  while (n > 0) {
    n /= 10;
    cnt++;
  }
  return cnt;
}
pair<long double, long long> powerldpair(long double, long long);
bool isprime(long long n) {
  if (n <= 1) return false;
  for (long long i = 2; i <= sqrt(n); ++i)
    if (n % i == 0) return false;
  return true;
}
bool revcomp(long long a, long long b) { return a > b; }
vector<long long> decToBinary(long long n);
void solve() {
  long long n;
  cin >> n;
  vector<long long> vec(n);
  for (long long i = 0; i < (n); ++i) cin >> vec[i];
  for (long long i = 0; i < (n - 2); ++i) {
    long long th = vec[i] + vec[i + 1];
    auto it = lower_bound(vec.begin() + i + 2, vec.end(), th);
    if (it != vec.end()) {
      pr(i + 1, i + 2, it - vec.begin() + 1);
      return;
    }
  }
  pr(-1);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
long long min(long long x, long long y) {
  if (x > y) return y;
  return x;
}
long long max(long long x, long long y) {
  if (x > y) return x;
  return y;
}
long long add(long long x, long long y) {
  return ((x % mod) + (y % mod) + mod) % mod;
}
long long multi(long long x, long long y) {
  return ((x % mod) * (y % mod)) % mod;
}
long long subtract(long long x, long long y) {
  return ((x % mod) - (y % mod) + mod) % mod;
}
long long divi(long long a, long long b) {
  return (a % mod * modpower(b, mod - 2) % mod) % mod;
}
long long modpower(long long x, long long y) {
  long long p = mod;
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long power(long long a, long long b) {
  long long prod = 1;
  while (b) {
    if (b & 1) {
      prod = (prod * a);
    }
    a = (a * a);
    b >>= 1;
  }
  return prod;
}
pair<long double, long long> powerldpair(long double a, long long b) {
  long double prod = 1;
  long long powten = 0;
  long long powtemp = 0;
  while (b) {
    if (b & 1) {
      prod = (prod * a);
      powten += powtemp;
      while (prod >= 10) {
        prod /= 10;
        powten++;
      }
    }
    a = (a * a);
    powtemp *= 2;
    while (a >= 10) {
      a /= 10;
      powtemp++;
    }
    b >>= 1;
  }
  return make_pair(prod, powten);
}
long long gcd(long long a, long long b) {
  if (b > a) swap(a, b);
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
void subsetsUtil(vector<long long>& A, vector<vector<long long> >& res,
                 vector<long long>& subset, long long index) {
  res.push_back(subset);
  for (long long i = index; i < A.size(); i++) {
    subset.push_back(A[i]);
    subsetsUtil(A, res, subset, i + 1);
    subset.pop_back();
  }
  return;
}
vector<vector<long long> > subsets(vector<long long>& A) {
  vector<long long> subset;
  vector<vector<long long> > res;
  long long index = 0;
  subsetsUtil(A, res, subset, index);
  return res;
}
void decimal(int n) {
  cout << fixed;
  cout << setprecision(n);
}
vector<long long> decToBinary(long long n) {
  long long binaryNum[65] = {0};
  int i = 0;
  while (n > 0) {
    binaryNum[i] = n % 2;
    n = n / 2;
    i++;
  }
  vector<long long> bin(65, 0);
  for (int j = i - 1; j >= 0; --j) {
    bin[j] = binaryNum[j];
  }
  return bin;
}
long long modinv(long long n, long long p) { return modpower(n, p - 2); }
long long ncrmod(long long n, long long r, long long p) {
  if (r == 0) return 1;
  long long fac[n + 1];
  fac[0] = 1;
  for (long long i = 1; i <= n; i++) fac[i] = fac[i - 1] * i % p;
  return (fac[n] * modinv(fac[r], p) % p * modinv(fac[n - r], p) % p) % p;
}
long long ncr(long long n, long long k) {
  long long res = 1;
  if (k > n - k) k = n - k;
  for (long long i = 0; i < k; ++i) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
long long npr(long long n, long long k) {
  long long P = 1;
  for (long long i = 0; i < k; i++) P *= (n - i);
  return P;
}
long long nprmod(long long n, long long k) {
  long long P = 1;
  for (long long i = 0; i < k; i++) P = multi(P, n - i);
  return P % mod;
}
vector<string> permutations(string str) {
  vector<string> vec;
  sort(str.begin(), str.end());
  do {
    vec.push_back(str);
  } while (next_permutation(str.begin(), str.end()));
  return vec;
}
void makeCombiUtil(vector<vector<long long> >& ans, vector<long long>& tmp,
                   long long n, long long left, long long k) {
  if (k == 0) {
    ans.push_back(tmp);
    return;
  }
  for (long long i = left; i <= n; ++i) {
    tmp.push_back(i);
    makeCombiUtil(ans, tmp, n, i + 1, k - 1);
    tmp.pop_back();
  }
}
vector<vector<long long> > makeCombi(long long n, long long k) {
  vector<vector<long long> > ans;
  vector<long long> tmp;
  makeCombiUtil(ans, tmp, n, 1, k);
  return ans;
}
void printSubSeqRec(string str, long long n, long long index = -1,
                    string curr = "") {
  if (index == n) return;
  cout << curr << "\n";
  for (long long i = index + 1; i < n; i++) {
    curr += str[i];
    printSubSeqRec(str, n, i, curr);
    curr = curr.erase(curr.size() - 1);
  }
  return;
}
void printSubSeq(string str) { printSubSeqRec(str, str.size()); }
