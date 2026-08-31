#include <bits/stdc++.h>
using namespace std;
template <typename T>
T sqr(T x) {
  return x * x;
}
template <typename T>
T abs(T x) {
  return x < 0 ? -x : x;
}
template <typename T>
T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
const int INF = (int)1e+9 + 7;
const int d[28] = {0,  4,  7,  8,  11, 12, 14, 15, 16, 18, 19, 20, 21, 22,
                   23, 24, 25, 26, 27, 28, 29, 30, 32, 33, 35, 36, 39, 42};
int n;
long long p[19];
vector<long long> ans;
map<pair<long long, int>, bool> cache;
pair<int, int> f[100];
bool rec(long long q) {
  if (!q) return true;
  for (int i = 0; i < 28; i++) {
    if ((q - d[i]) % 10 || d[i] > q)
      continue;
    else {
      ans.push_back(d[i]);
      if (rec((q - d[i]) / 10)) return true;
      ans.pop_back();
    }
  }
  return false;
}
int main() {
  p[0] = 1;
  for (int i = 1; i <= 18; i++) p[i] = p[i - 1] * 10;
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++) f[i * 4 + j * 7] = pair<int, int>(i, j);
  cin >> n;
  for (int i = 0; i < n; i++) {
    long long a;
    cin >> a;
    ans.clear();
    if (rec(a)) {
      long long q[6];
      memset(q, 0, sizeof(q));
      for (int i = 0; i < ans.size(); i++) {
        for (int j = 0; j < f[ans[i]].first; j++) q[j] += 4 * p[i];
        for (int j = f[ans[i]].first; j < f[ans[i]].first + f[ans[i]].second;
             j++)
          q[j] += 7 * p[i];
      }
      for (int j = 0; j < 6; j++) cout << q[j] << ' ';
    } else
      cout << -1;
    cout << endl;
  }
}
