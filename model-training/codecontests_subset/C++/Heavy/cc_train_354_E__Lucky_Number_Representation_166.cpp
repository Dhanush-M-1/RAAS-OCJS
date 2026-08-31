#include <bits/stdc++.h>
using namespace std;
struct edge {
  int u, v;
  long long w;
};
long long MOD = 1000000007;
long long _MOD = 1000000009;
double EPS = 1e-10;
bool f(int i, int c, vector<int>& a, vector<vector<bool> >& vis,
       vector<unsigned long long>& b) {
  if (i == 19) return !c;
  if (vis[i][c]) return false;
  vis[i][c] = true;
  for (int x = 0; x <= 6; x++)
    for (int y = x; y <= 6; y++) {
      int z = (y - x) * 4 + (6 - y) * 7 + c;
      if (z % 10 == a[i] && f(i + 1, z / 10, a, vis, b)) {
        for (int k = 0; k < 6; k++) {
          b[k] *= 10;
          if (x <= k && k < y) b[k] += 4;
          if (y <= k) b[k] += 7;
        }
        return true;
      }
    }
  return false;
}
int main() {
  int T;
  cin >> T;
  while (T--) {
    long long n;
    cin >> n;
    vector<int> a(19);
    for (int t = 0; t < 19; t++) {
      a[t] = n % 10;
      n /= 10;
    }
    vector<vector<bool> > vis(19, vector<bool>(10));
    vector<unsigned long long> b(6);
    if (f(0, 0, a, vis, b)) {
      for (int k = 0; k < 6; k++) cout << b[k] << ' ';
      cout << endl;
    } else
      cout << -1 << endl;
  }
}
