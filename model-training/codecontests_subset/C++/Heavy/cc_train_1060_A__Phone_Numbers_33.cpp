#include <bits/stdc++.h>
using namespace std;
long long powmod(long long a, long long b, long long mod) {
  if (b == 0 || a == 1) {
    if (mod == 1)
      return 0;
    else
      return 1;
  }
  if (b % 2 == 0) {
    long long k = powmod(a, b / 2, mod);
    return (k * k) % mod;
  } else {
    long long k = powmod(a, b / 2, mod);
    return ((k * k) % mod * a) % mod;
  }
}
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  if (b == 0) return a;
  if (a > b)
    return gcd(a % b, b);
  else
    return gcd(b % a, a);
}
int prime(int p) {
  for (int i = 2; i * i <= p; i++) {
    if (p % i == 0 && i < p) return i;
  }
  return 1;
}
long long sqr(long long i) { return i * i; }
void r(long long &a) { cin >> a; }
void r(long long &a, long long &b) { cin >> a >> b; }
void r(long long &a, long long &b, long long &c) { cin >> a >> b >> c; }
void r(long long &a, long long &b, long long &c, long long &d) {
  cin >> a >> b >> c >> d;
}
void r(long long &a, long long &b, long long &c, long long &d, long long &e) {
  cin >> a >> b >> c >> d >> e;
}
void r(long long &a, long long &b, long long &c, long long &d, long long &e,
       long long &f) {
  cin >> a >> b >> c >> d >> e >> f;
}
void r(vector<long long> &a) {
  for (int i = 0; i < a.size(); i++) r(a[i]);
}
void r(vector<vector<long long>> &a) {
  for (int i = 0; i < a.size(); i++) r(a[i]);
}
void w(long long a) { cout << a << "\n"; }
void w(char a) { cout << a; }
void w(long long a, long long b) { cout << a << " " << b << "\n"; }
void w(long long a, long long b, long long c) {
  cout << a << " " << b << " " << c << "\n";
}
void w(long long a, long long b, long long c, long long d) {
  cout << a << " " << b << " " << c << " " << d << "\n";
}
void w(vector<long long> a) {
  for (int i = 0; i < a.size(); i++) cout << a[i] << " ";
  cout << "\n";
}
void w(vector<vector<long long>> a) {
  for (int i = 0; i < a.size(); i++) w(a[i]);
  cout << "\n";
}
void r(pair<long long, long long> &a) { cin >> a.first >> a.second; }
void w(pair<long long, long long> a) {
  cout << a.first << " " << a.second << "\n";
}
void r(vector<pair<long long, long long>> &a) {
  for (int i = 0; i < a.size(); i++) r(a);
}
void w(vector<pair<long long, long long>> a) {
  for (int i = 0; i < a.size(); i++) w(a[i]);
  cout << "\n";
}
void r(string &a) { cin >> a; }
void r(char &a) { cin >> a; }
void w(string a) { cout << a << "\n"; }
void sort(vector<long long> &a) { sort(a.begin(), a.end()); }
void sort(vector<pair<long long, long long>> &a) { sort(a.begin(), a.end()); }
void rev(vector<long long> &a) { reverse(a.begin(), a.end()); }
void rev(vector<pair<long long, long long>> &a) { reverse(a.begin(), a.end()); }
void rev(string &a) { reverse(a.begin(), a.end()); }
void solve(int ppppppppp = 1) {
  long long a;
  string s;
  r(a);
  r(s);
  long long num = 0;
  for (int i = 0; i < a; i++) num += s[i] == '8';
  w(min(num, a / 11));
  return;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tututu;
  tututu = 1;
  for (int qwerty = 0; qwerty < tututu; qwerty++) solve();
  return 0;
}
