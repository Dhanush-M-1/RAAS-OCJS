#include <algorithm>
#include <cmath>
#include <cstring>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stdlib.h>
#include <string>
#include <utility>
#include <vector>
#define rep(i, n) for (int i = 0; i < (n); i++)
#define loop(i, x, n) for (int i = (x); i < (n); i++)
#define all(v) (v).begin(), (v).end()
#define int long long
using namespace std;
const int MOD = 1e9 + 7;
const int INF = 1e9;
template<typename T> void cmax(T &a, T b) { a = max(a, b); }
template<typename T> void cmin(T &a, T b) { a = min(a, b); }

signed main() {
  int n;
  cin >> n;
  vector<int> a(n);
  map<int, int> m;
  rep(i, n) {
    cin >> a[i];
    m[a[i] % (n - 1)]++;
  }
  for (auto x : m) {
    int tmp = 0;
    if (2 <= x.second) {
      bool flag = false;
      rep(i, n) {
        if (a[i] % (n - 1) == x.first) {
          if (flag) cout << ' ';
          cout << a[i];
          flag = true;
          tmp++;
        }
        if (tmp == 2) {
          cout << endl;
          return 0;
        }
      }
    }
  }
  return 0;
}

