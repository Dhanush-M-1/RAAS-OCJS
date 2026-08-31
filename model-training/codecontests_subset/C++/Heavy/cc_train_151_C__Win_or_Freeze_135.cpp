#include <bits/stdc++.h>
using namespace std;
struct debugger {
  vector<string> vars;
  template <typename T>
  debugger &operator,(const T v) {
    stringstream ss;
    ss << v, vars.push_back(ss.str());
    return *this;
  }
  void printall() {
    int j = 0, l = vars.size();
    for (int i = 0; i < (l - 1); i++) {
      if (i) cout << ", ";
      for (j; j < vars[l - 1].size(); j++) {
        if (vars[l - 1][j] == ',') {
          j++;
          break;
        }
        cout << vars[l - 1][j];
      }
      cout << " = " << vars[i];
    }
    vars.clear();
  }
} Dbug;
int CI(int &_x) { return scanf("%d", &_x); }
int CI(int &_x, int &_y) { return scanf("%d %d", &_x, &_y); }
int CI(int &_x, int &_y, int &_z) { return scanf("%d %d %d", &_x, &_y, &_z); }
int CI(int &_a, int &_b, int &_c, int &_d) {
  return scanf("%d %d %d %d", &_a, &_b, &_c, &_d);
}
template <typename T>
void getarray(T a[], int b, int e) {
  for (int i = b; i < e + b; i++) cin >> a[i];
}
template <typename T>
void printarray(T a[], int b, int e) {
  for (int i = b; i < e - 1 + b; i++) cout << a[i] << " ";
  if (e - 1 + b >= 0) cout << a[e - 1 + b] << endl;
}
template <typename T>
void printV(vector<T> v) {
  int sz = v.size();
  if (sz) cout << v[0];
  for (int i = 1; i < sz; i++) cout << " " << v[i];
  puts("");
}
template <typename T>
T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <typename T>
T BigMod(T b, T p, T m) {
  if (p == 0) return 1;
  if (p % 2 == 0) {
    T s = BigMod(b, p / 2, m);
    return ((s % m) * (s % m)) % m;
  }
  return ((b % m) * (BigMod(b, p - 1, m) % m)) % m;
}
template <typename T>
T ModInv(T b, T m) {
  return BigMod(b, m - 2, m);
}
template <class T>
inline void read(T &x) {
  bool Minus = 0;
  char c;
  for (c = getchar(); c <= 32; c = getchar())
    ;
  if (c == '-') Minus = 1, c = getchar();
  for (x = 0; c > 32; c = getchar()) x = x * 10 + c - '0';
  if (Minus) x = -x;
}
char getc() {
  char c;
  for (c = getchar(); c <= 32; c = getchar())
    ;
  return c;
}
const double EPS = 1e-9;
const int INF = (1 << 30) - 1;
const long long int LINF = (1ll << 62) - 1;
int dr8[8] = {1, -1, 0, 0, 1, -1, -1, 1};
int dc8[8] = {0, 0, -1, 1, 1, 1, -1, -1};
int dr4[4] = {0, 0, 1, -1};
int dc4[4] = {-1, 1, 0, 0};
int kn8r[8] = {1, 2, 2, 1, -1, -2, -2, -1};
int kn8c[8] = {2, 1, -1, -2, -2, -1, 1, 2};
int main() {
  int i, j, k, l, n, m, q, a, b, c;
  long long int N;
  cin >> N;
  long long int ii, sqN = sqrt(N);
  long long int total_factor = 0;
  vector<long long int> prime_factors;
  for (ii = 2; ii <= sqN; ii++) {
    if (N % ii == 0) {
      prime_factors.push_back(ii);
      while (N % ii == 0) {
        total_factor++;
        N /= ii;
      }
    }
  }
  if (N != 1) {
    total_factor++;
    prime_factors.push_back(N);
  }
  if (total_factor <= 1) {
    cout << 1 << "\n" << 0 << "\n";
    return 0;
  }
  if (total_factor == 2) {
    cout << 2 << "\n";
    return 0;
  }
  cout << 1 << "\n";
  if (prime_factors.size() >= 2)
    cout << prime_factors[0] * prime_factors[1] << "\n";
  else
    cout << prime_factors[0] * prime_factors[0] << "\n";
  return 0;
}
