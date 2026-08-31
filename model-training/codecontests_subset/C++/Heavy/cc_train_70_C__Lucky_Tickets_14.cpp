#include <bits/stdc++.h>
using namespace std;
template <class T>
const T& max(const T& a, const T& b, const T& c) {
  return max(a, max(b, c));
}
template <class T>
const T& min(const T& a, const T& b, const T& c) {
  return min(a, min(b, c));
}
void sc(int& a) { scanf("%d", &a); }
void sc(long long& a) { scanf("%lld", &a); }
void sc(int& a, int& b) {
  sc(a);
  sc(b);
}
void sc(long long& a, long long& b) {
  sc(a);
  sc(b);
}
void sc(int& a, int& b, int& c) {
  sc(a, b);
  sc(c);
}
void sc(long long& a, long long& b, long long& c) {
  sc(a, b);
  sc(c);
}
void prl(int a) { printf("%d\n", a); }
void prl(long long a) { printf("%lld\n", a); }
void prl() { printf("\n"); }
void prs(int a) { printf("%d ", a); }
void prs(long long a) { printf("%lld ", a); }
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long lcm(long long a, long long b) { return (a * b) / gcd(a, b); }
long long poww(long long a, long long b) {
  if (b == 0) return 1;
  long long tmp = poww(a, b / 2);
  return (b & 1 ? a * tmp * tmp : tmp * tmp);
}
long long sumOfDigs(string s) {
  long long sum = 0;
  for (int i = 0; i < s.length(); i++) sum += s[i] - '0';
  return sum;
}
long long sumOfDigs(long long n) {
  return (n < 10 ? n : n % 10 + sumOfDigs(n / 10));
}
string itos(long long i) {
  string s = "";
  while (i) {
    s += char(i % 10 + '0');
    i /= 10;
  }
  reverse(s.begin(), s.end());
  return s;
}
long long stoi(string& s) {
  long long tot = 0;
  for (int i = (int)s.length() - 1, j = 1; i >= 0; i--, j *= 10) {
    tot += j * (s[i] + '0');
  }
  return tot;
}
int months[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
using namespace std;
long long mod = 1e9 + 7;
void tt() { freopen("test.txt", "r", stdin); }
long long modpower(long long x, long long y, long long p) {
  x %= mod;
  if (!y) return 1;
  long long res = 1;
  if (y & 1) {
    res *= x;
    res %= p;
  }
  long long z = modpower(x, y / 2, p);
  z %= p;
  z *= z;
  z %= mod;
  res *= z;
  res %= p;
  return res;
}
map<double, int> mpx, mpy;
int rev(int num) {
  int tot = 0;
  while (num) {
    tot = tot * 10 + (num % 10);
    num /= 10;
  }
  return tot;
}
int main() {
  int mx, my, w;
  cin >> mx >> my >> w;
  for (int i = 1; i <= mx; i++) {
    mpx[i * 1.0 / rev(i)]++;
  }
  int x = mx, y = 0;
  int poss = 0;
  int finx = -1, finy = -1;
  int cnt = 0;
  while (x >= 1 && y <= my) {
    if (cnt < w) {
      y++;
      double temp = rev(y) * 1.0 / y;
      cnt += mpx[temp];
      mpy[temp]++;
    } else {
      if (!poss || (1ll * finx * finy > 1ll * x * y)) {
        poss = 1;
        finx = x, finy = y;
      }
      double temp = x * 1.0 / rev(x);
      cnt -= mpy[temp];
      mpx[temp]--;
      x--;
    }
  }
  if (!poss) {
    return cout << -1 << endl, 0;
  }
  cout << finx << " " << finy << endl;
  return 0;
}
