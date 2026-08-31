#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline string toString(T a) {
  ostringstream os("");
  os << a;
  return os.str();
}
template <typename T>
inline long long toLong(T a) {
  long long res;
  istringstream os(a);
  os >> res;
  return res;
}
template <typename T>
inline T SQ(T a) {
  return a * a;
}
template <typename T>
inline T gcd(T a, T b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
template <typename T>
inline unsigned long long bigmod(T a, T b, T m) {
  if (b == 0)
    return 1;
  else if (b % 2 == 0)
    return S(bigmod(a, b / 2, m)) % m;
  else
    return (a % m * bigmod(a, b - 1, m)) % m;
}
template <typename T>
inline vector<string> parse(T str) {
  vector<string> res;
  string s;
  istringstream os(str);
  while (os >> s) res.push_back(s);
  return res;
}
template <typename T>
inline unsigned long long dist(T A, T B) {
  unsigned long long res =
      (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
  return res;
}
template <typename T>
inline double cosAngle(T a, T b, T c) {
  double res = a * a + b * b - c * c;
  res = res / (2 * a * b);
  res = acos(res);
  return res;
}
template <typename T>
inline T power(T base, int po) {
  T res = 1;
  if (base == 0) return 0;
  for (int i = (0); i < (po); i++) res *= base;
  return res;
}
template <typename T>
inline bool isOn(T mask, T pos) {
  return mask & (1 << pos);
}
template <typename T>
inline int Off(T mask, T pos) {
  return mask ^ (1 << pos);
}
template <typename T>
inline int On(T mask, T pos) {
  return mask | (1 << pos);
}
int arr[1005];
int frn[1005], bck[1005];
bool vis[1005];
bool st;
int pos;
int dp[2005];
int main() {
  int i, j, k;
  int x, y;
  int n;
  cin >> n >> pos;
  for (int i = (1); i < (n + 1); i++) {
    cin >> x;
    if (x) frn[i] = x, bck[x] = i;
  }
  memset(dp, 0, sizeof dp);
  dp[0] = 1;
  for (int i = pos; i <= pos; i++) {
    if (vis[i]) continue;
    int cur = 0;
    x = i;
    while (x) {
      vis[x] = 1;
      cur++;
      x = frn[x];
    }
    y = cur;
    x = bck[i];
    while (x) {
      vis[x] = 1;
      x = bck[x];
    }
  }
  vector<int> v;
  for (int i = 1; i <= n; i++) {
    if (vis[i]) continue;
    int cur = 0;
    x = i;
    while (x) {
      vis[x] = 1;
      cur++;
      x = frn[x];
    }
    x = bck[i];
    while (x) {
      vis[x] = 1;
      cur++;
      x = bck[x];
    }
    v.push_back(cur);
  }
  int Sz = v.size();
  dp[y] = 1;
  for (int i = (0); i < (Sz); i++) {
    for (j = n; j >= 1; j--) {
      if (dp[j]) dp[j + v[i]] = 1;
    }
  }
  for (int i = (1); i < (n + 1); i++) {
    if (dp[i]) cout << i << endl;
  }
}
