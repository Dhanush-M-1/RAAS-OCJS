#include <bits/stdc++.h>
using namespace std;
int mod = 1e9 + 7;
long double eps = 1e-12;
int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};
int n, res = 0, k = 0, h, ans = 0, m;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int lcm(int x, int y) { return (x * y) / gcd(x, y); }
int pot(int a, int b) {
  if (b < 0) return 0;
  int r = 1;
  while (b) {
    if (b % 2) r = (r * a) % mod;
    a = (a * a) % mod;
    b /= 2;
  }
  return r % mod;
}
void pr(int a[], int n) {
  for (int i = 1; i <= n; i++) cout << a[i] << " ";
  cout << '\n';
}
void read(int a[], int n) {
  for (int i = 1; i <= n; i++) cin >> a[i];
}
void yes() { cout << "YES\n"; }
void no() { cout << "NO\n"; }
vector<int> v[300015];
void add_edge(int x, int y) {
  v[x].push_back(y);
  v[y].push_back(x);
}
string s2, ch = "", s[5205], s1 = "", t;
vector<pair<string, int> > vs;
vector<pair<pair<int, int>, int> > vvv, vvv2;
vector<pair<int, int> > vv[300015], vv2;
int dp[5205][5205];
string HexToBin(char c) {
  switch (toupper(c)) {
    case '0':
      return "0000";
    case '1':
      return "0001";
    case '2':
      return "0010";
    case '3':
      return "0011";
    case '4':
      return "0100";
    case '5':
      return "0101";
    case '6':
      return "0110";
    case '7':
      return "0111";
    case '8':
      return "1000";
    case '9':
      return "1001";
    case 'A':
      return "1010";
    case 'B':
      return "1011";
    case 'C':
      return "1100";
    case 'D':
      return "1101";
    case 'E':
      return "1110";
    case 'F':
      return "1111";
  }
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int i = 0, x = 0, z = 0, y = 0, j = 0, q, mx = 0, mm, idx = 0, ok = 0, l = 0,
      r, negatif = 0, positif = 0;
  set<int>::iterator itw, ith;
  set<int>::iterator it;
  multiset<int> mst, mst2;
  cin >> n;
  for (i = 0; i <= (int)(n - 1); i++) {
    s[i] = "";
    for (j = 0; j < (n / 4); j++) {
      char c;
      cin >> c;
      s[i] += HexToBin(c);
    }
  }
  for (i = 1; i <= (int)(n); i++) {
    for (j = 1; j <= (int)(n); j++) {
      dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
      if (s[i - 1][j - 1] == '1') {
        dp[i][j]++;
      }
    }
  }
  vector<int> v;
  for (i = 1; i <= n; i++) {
    if (n % i == 0) v.push_back(i);
  }
  for (l = ((int)((v).size())) - 1; l >= 0; l--) {
    x = v[l];
    int flag = 1;
    for (i = x; i <= n; i += x) {
      for (j = x; j <= n; j += x) {
        int nb1 = dp[i][j] - dp[i - x][j] - dp[i][j - x] + dp[i - x][j - x];
        int nb0 = x * x - nb1;
        if (nb1 != (x * x) && nb0 != (x * x)) {
          flag = 0;
          break;
        }
      }
      if (!flag) break;
    }
    if (flag) return cout << x, 0;
  }
  return 0;
}
