#include <bits/stdc++.h>
using namespace std;
long long INF = 1 << 28;
const double pi = acos(-1.0);
int fx[] = {1, -1, 0, 0};
int fy[] = {0, 0, 1, -1};
int dir[4][2] = {1, 0, -1, 0, 0, -1, 0, 1};
int knight[8][2] = {1, 2, 1, -2, 2, 1, 2, -1, -1, 2, -1, -2, -2, 1, -2, -1};
const long double EPS = 1e-7;
long long gcd(long long a, long long b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
bool cmp(int a, int b) { return a < b; }
int on(int mask, int st) { return mask | (1 << st); }
int off(int mask, int st) { return mask & (~(1 << st)); }
bool check(int mask, int st) { return mask & (1 << st); }
long long inf = 1e12;
long long MOD = 1e9 + 7;
long long mod = 1e9 + 7;
int main() {
  int n;
  scanf("%d", &n);
  string s;
  cin >> s;
  int f = 1;
  for (int i = 1; i < n; i++) {
    if (s[i - 1] > s[i]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
