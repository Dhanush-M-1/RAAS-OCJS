#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;
long long POW(long long a, long long b, long long MMM = MOD) {
  long long ret = 1;
  for (; b; b >>= 1, a = (a * a) % MMM)
    if (b & 1) ret = (ret * a) % MMM;
  return ret;
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) {
  if (a == 0 || b == 0) return a + b;
  return a * (b / gcd(a, b));
}
int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
int ddx[] = {0, 0, 1, 1, 1, -1, -1, -1}, ddy[] = {1, -1, 1, 0, -1, 1, 0, -1};
string s[1000000];
int n, r, c, to[1000001][20];
pair<int, int> p[1000000];
int res(int l) {
  int now = l;
  for (int(i) = (19); (i) >= (0); (i) -= (1)) {
    if (r & (1 << i)) {
      now = to[now][i];
    }
  }
  return now - l;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> r >> c;
  for (int(i) = (0); (i) <= (n - 1); (i) += (1)) cin >> s[i];
  p[0].first = 0, p[0].second = s[0].length() - 1;
  for (int(i) = (1); (i) <= (n - 1); (i) += (1)) {
    p[i].first = p[i - 1].second + 2;
    p[i].second = p[i].first + s[i].length() - 1;
  }
  to[n][0] = n;
  int rr = 0;
  for (int(i) = (0); (i) <= (n - 1); (i) += (1)) {
    if (s[i].length() > c) {
      to[i][0] = i;
      rr = i + 1;
    } else {
      while (rr < n && p[rr].second - p[i].first + 1 <= c) rr++;
      to[i][0] = rr;
    }
  }
  for (int(j) = (1); (j) <= (19); (j) += (1))
    for (int(i) = (0); (i) <= (n); (i) += (1))
      to[i][j] = to[to[i][j - 1]][j - 1];
  int ans = -1, what = -1;
  for (int(i) = (0); (i) <= (n - 1); (i) += (1)) {
    int t = res(i);
    if (t > ans) {
      ans = t;
      what = i;
    }
  }
  for (int(i) = (0); (i) <= (r - 1); (i) += (1)) {
    for (int(j) = (what); (j) <= (to[what][0] - 1); (j) += (1)) {
      if (j != what) cout << ' ';
      cout << s[j];
    }
    cout << '\n';
    what = to[what][0];
  }
}
