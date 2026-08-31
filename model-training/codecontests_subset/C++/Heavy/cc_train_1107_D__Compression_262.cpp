#include <bits/stdc++.h>
const int maxx = 1e5 + 100;
const int mod = 10007;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
using namespace std;
int n, m, T;
int pre[5210][5210];
int ans, l, r;
string s;
int tot, x, t;
void move(int pos) {
  while (t < 4) {
    pre[pos][tot--] = (x >> t & 1);
    t++;
  }
  return;
}
void solve(int pos) {
  tot = 1, x, t;
  for (int i = 0; i < s.size(); i++) {
    tot = (i + 1) * 4;
    t = 0;
    if (s[i] == '1')
      x = 1, move(pos);
    else if (s[i] == '2')
      x = 2, move(pos);
    else if (s[i] == '3')
      x = 3, move(pos);
    else if (s[i] == '4')
      x = 4, move(pos);
    else if (s[i] == '5')
      x = 5, move(pos);
    else if (s[i] == '6')
      x = 6, move(pos);
    else if (s[i] == '7')
      x = 7, move(pos);
    else if (s[i] == '8')
      x = 8, move(pos);
    else if (s[i] == '9')
      x = 9, move(pos);
    else if (s[i] == 'A')
      x = 10, move(pos);
    else if (s[i] == 'B')
      x = 11, move(pos);
    else if (s[i] == 'C')
      x = 12, move(pos);
    else if (s[i] == 'D')
      x = 13, move(pos);
    else if (s[i] == 'E')
      x = 14, move(pos);
    else if (s[i] == 'F')
      x = 15, move(pos);
    else
      x = 0, move(pos);
  }
}
bool check(int x) {
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      int X = i + x - 1, Y = j + x - 1;
      int sum = pre[X][Y] - pre[X][j - 1] - pre[i - 1][Y] + pre[i - 1][j - 1];
      if (sum != 0 && sum != x * x) return false;
    }
  }
  return true;
}
int main() {
  int i, j, k;
  while (scanf("%d", &n) == 1) {
    ans = -inf;
    memset(pre, 0, sizeof pre);
    for (i = 1; i <= n; i++) {
      cin >> s;
      solve(i);
    }
    for (i = 1; i <= n; i++)
      for (j = 1; j <= n; j++) pre[i][j] += pre[i][j - 1];
    for (j = 1; j <= n; j++)
      for (i = 1; i <= n; i++) pre[i][j] += pre[i - 1][j];
    for (i = n; i >= 1; i--) {
      if (n % i) continue;
      int ok = 1;
      for (j = 1; j <= n; j += i) {
        for (k = 1; k <= n; k += i) {
          int X = j + i - 1, Y = k + i - 1;
          int sum =
              pre[X][Y] - pre[X][k - 1] - pre[j - 1][Y] + pre[j - 1][k - 1];
          ok &= (sum == 0 || sum == i * i);
        }
      }
      if (ok) ans = max(ans, i);
    }
    cout << ans << endl;
  }
  return 0;
}
