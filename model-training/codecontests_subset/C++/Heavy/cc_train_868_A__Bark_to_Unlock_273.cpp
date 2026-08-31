#include <bits/stdc++.h>
#pragma GCC optimize("O2")
using namespace std;
const int MAX = 3e5 + 5;
const long long MAX2 = 11;
const int MOD = 1000000000 + 7;
const long long INF = 20000;
const int dr[] = {1, 0, -1, 0, 1, 1, -1, -1};
const int dc[] = {0, 1, 0, -1, 1, -1, 1, -1};
const double pi = acos(-1);
const double eps = 1e-9;
long long n, x[MAX], y, z, sz, cnt, tmp;
bool v[MAX];
string s, t;
char a, b, c[MAX], d[MAX];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> a >> b;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> c[i] >> d[i];
    if (c[i] == a && d[i] == b) return cout << "YES", 0;
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (d[i] == a && c[j] == b) return cout << "YES", 0;
    }
  cout << "NO";
  return 0;
}
