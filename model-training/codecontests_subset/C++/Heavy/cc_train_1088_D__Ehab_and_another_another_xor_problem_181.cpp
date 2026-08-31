#include <bits/stdc++.h>
const int inf = (int)2e+9 + 2;
const int mod = (int)1e+5;
const int h_prime = 1103;
const double eps = 1e-6;
using namespace std;
vector<long long> primes;
vector<long long> HH, pp;
long double dist(pair<long double, long double> a,
                 pair<long double, long double> b) {
  return sqrtl((a.first - b.first) * (a.first - b.first) +
               (a.second - b.second) * (a.second - b.second));
}
long double len(pair<long double, long double> x) {
  return sqrtl(x.first * x.first + x.second * x.second);
}
long double angle(pair<long double, long double> a,
                  pair<long double, long double> b) {
  return acos((a.first * b.first + a.second * b.second) / (len(a) * len(b)));
}
long double ar_tr(pair<long double, long double> a,
                  pair<long double, long double> b) {
  return a.first * b.second - b.first * a.second;
}
long long get_hash(int l, int r) {
  long long res = HH[r];
  if (l) res -= HH[l - 1] * pp[r - l + 1];
  return res;
}
void init_hashes(string s) {
  long long hash = s[0];
  HH.push_back(hash);
  long long ppow = 1;
  for (size_t i = 0; i < s.length(); ++i) {
    pp.push_back(ppow);
    ppow *= h_prime;
  }
  for (size_t i = 1; i < s.length(); ++i) {
    hash *= h_prime;
    hash += s[i];
    HH.push_back(hash);
  }
}
inline long long gcd(long long x, long long y) {
  while (y) {
    x %= y;
    swap(x, y);
  }
  return x;
}
void init_primes(long long maxn) {
  vector<bool> np(maxn, false);
  np[0] = np[1] = true;
  for (int i = 2; i * i < maxn; ++i)
    if (!np[i]) {
      for (int j = i * i; j < maxn; j += i) np[j] = true;
      primes.push_back(i);
    }
}
long long binpow(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1) res *= a;
    a *= a;
    b /= 2;
  }
  return res;
}
long long to2(vector<long long>& a) {
  long long k = 1;
  long long ans = 0;
  for (int i = 0; i < a.size(); ++i) {
    ans += k * a[i];
    k *= 2;
  }
  return ans;
}
vector<long long> c1(30, 0), c2(30, 0);
long long get(long long a, long long b) {
  a += to2(c1);
  b += to2(c2);
  int ans;
  cout << "? " << a << ' ' << b << endl;
  cin >> ans;
  return ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  vector<long long> a(30, 0), b(30, 0);
  bool f = true;
  int used = -1;
  for (int i = 29; i >= 0; --i) {
    int ans1, ans2;
    ans1 = get(1 << i, 0);
    ans2 = get(0, 1 << i);
    if (ans1 != ans2) {
      if (ans1 == -1)
        a[i] = b[i] = 1;
      else
        a[i] = b[i] = 0;
    } else {
      if (ans1 == 0) {
        int ans3 = get(0, 0);
        if (ans3 == 1) {
          a[i] = 1;
          b[i] = 0;
        } else {
          a[i] = 0;
          b[i] = 1;
        }
      }
      if (used == -1) {
        int ans3 = get(0, 0);
        if (ans3 == 1) {
          a[i] = 1;
          b[i] = 0;
        } else {
          a[i] = 0;
          b[i] = 1;
        }
        used = 1;
      } else if (f) {
        a[i] = 1;
        b[i] = 0;
      } else {
        a[i] = 0;
        b[i] = 1;
      }
      if (ans1 == 1)
        f = true;
      else
        f = false;
    }
    c1[i] = a[i];
    c2[i] = b[i];
  }
  cout << "! " << to2(a) << ' ' << to2(b) << endl;
}
