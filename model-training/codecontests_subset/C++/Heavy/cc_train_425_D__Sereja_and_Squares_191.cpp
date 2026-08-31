#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-11;
template <class T>
inline void Min(T &a, T b) {
  if (b < a) a = b;
}
template <class T>
inline void Max(T &a, T b) {
  if (b > a) a = b;
}
template <class T>
inline T gcd(T a, T b) {
  if (a < 0) return gcd(-a, b);
  if (b < 0) return gcd(a, -b);
  return (b == 0) ? a : gcd(b, a % b);
}
template <class T>
inline T lcm(T a, T b) {
  if (a < 0) return lcm(-a, b);
  if (b < 0) return lcm(a, -b);
  return a * (b / gcd(a, b));
}
template <class T>
inline T euclide(T a, T b, T &x, T &y) {
  if (a < 0) {
    T d = euclide(-a, b, x, y);
    x = -x;
    return d;
  }
  if (b < 0) {
    T d = euclide(a, -b, x, y);
    y = -y;
    return d;
  }
  if (b == 0) {
    x = 1;
    y = 0;
    return a;
  } else {
    T d = euclide(b, a % b, x, y);
    T t = x;
    x = y;
    y = t - (a / b) * y;
    return d;
  }
}
const int mod = (int)1e9 + 7;
const int inf = 0x7fffffff;
int n, x, y;
vector<int> ve[200001];
bool exist(int index, int xx) {
  return binary_search(ve[index].begin(), ve[index].end(), xx);
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &x, &y);
    ve[y].push_back(x);
  }
  for (int i = 0; i <= 100000; i++)
    if ((int)ve[i].size() > 0) sort(ve[i].begin(), ve[i].end());
  int tmp = sqrt((double)n);
  int ans = 0;
  for (int i = 0; i <= 100000; i++) {
    if ((int)ve[i].size() > tmp) {
      for (int j = i + 1; j <= 100000; j++) {
        int d = j - i;
        for (int k = 0; k < ve[j].size(); k++)
          if (exist(i, ve[j][k]) && exist(j, ve[j][k] + d) &&
              exist(i, ve[j][k] + d))
            ans++;
      }
    } else {
      for (int j = 0; j < ve[i].size(); j++)
        for (int k = j + 1; k < ve[i].size(); k++) {
          int d = ve[i][k] - ve[i][j];
          if (exist(i + d, ve[i][k]) && exist(i + d, ve[i][j])) ans++;
        }
    }
  }
  printf("%d\n", ans);
  return 0;
}
