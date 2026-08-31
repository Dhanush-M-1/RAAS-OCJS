#include <bits/stdc++.h>
using namespace std;
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T &x) {
  int f = 0;
  cerr << '{';
  for (auto &i : x) cerr << (f++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
vector<long long> prime;
long long vis[10000000];
void sieve() {
  long long i, j;
  memset(vis, 0, sizeof(vis));
  for (i = 2; i * i <= 10000000000000; i++) {
    if (vis[i] == 0) {
      vis[i] = 1;
      prime.push_back(i);
      for (j = i * i; j <= sqrt(10000000000000); j += i) {
        vis[j] = 1;
      }
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1, i, j, k, n, m, a, b, sz;
  char ch;
  string s;
  bool ok;
  while (t--) {
    cin >> n;
    m = n;
    sieve();
    a = b = -1;
    sz = prime.size();
    i = 0;
    while (i != sz) {
      if (n % prime[i] == 0) {
        n = n / prime[i];
        if (a == -1)
          a = prime[i];
        else if (b == -1) {
          b = prime[i];
          break;
        }
      } else
        i++;
    }
    if (i == sz) {
      if (a == -1) {
        a = 1;
        b = -1;
      } else if (b == -1 && n != 1) {
        b = n;
      }
    }
    if (a * b < 0) {
      cout << 1 << endl;
      cout << 0 << endl;
    } else if (a * b == m)
      cout << 2 << endl;
    else {
      cout << 1 << endl;
      cout << a * b << endl;
    }
  }
}
