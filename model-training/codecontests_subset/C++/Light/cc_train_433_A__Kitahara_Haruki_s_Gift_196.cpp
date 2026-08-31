#include <bits/stdc++.h>
using namespace std;
map<long long, bool> tz;
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
int cnk(long long n, long long k, long long mod) {
  long long result = 1;
  int lal = 0;
  for (int lol = n; lal < k; lal++, lol--) {
    result *= lol;
    result %= mod;
  }
  return result;
}
const long long mod = 1e9 + 7;
vector<long long> graph[100000];
vector<pair<long long, long long> > vec1;
vector<pair<long long, long long> > vec2;
vector<long long> vec;
long long mas[100000];
vector<long long> nap[4];
bool masi[100000];
long long mas1[100];
long long mas2[100];
string s;
long long power(long long a, long long b) {
  long long res = 1;
  for (long long i = 0; i < b; i++) {
    res *= a;
  }
  return res;
}
bool comp(long long a, long long b) { return a > b; }
string tostr(long long a) {
  ostringstream out;
  out << a;
  return out.str();
}
map<string, long long> ochki;
int main() {
  long long a, b, k;
  cin >> a;
  long long a1 = 0, a2 = 0;
  for (long long lol = 0; lol < a; lol++) {
    cin >> k;
    if (k == 100) {
      a1++;
    } else
      a2++;
  }
  if (a2 % 2 == 0) {
    if (a1 % 2 == 0) {
      cout << "YES";
    } else
      cout << "NO";
  } else {
    if (a1 >= 2 && a1 % 2 == 0) {
      cout << "YES";
    } else
      cout << "NO";
  }
  return 0;
}
