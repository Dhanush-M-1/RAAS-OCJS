#include <bits/stdc++.h>
using namespace std;
int mem[20][5];
int sz;
int ara[3];
int cc[20];
int okay[44];
int dp(int len, int c) {
  if (len == sz) return !c;
  int ret = mem[len][c];
  if (ret != -1) return ret;
  ret = 0;
  for (int i = 0; i < 43; i++) {
    if (!okay[i]) continue;
    if ((c + i) % 10 == cc[len]) ret |= dp(len + 1, (c + i) / 10);
    if (ret) break;
  }
  return mem[len][c] = (bool)ret;
}
vector<int> vec;
void path(int len, int c) {
  if (len == sz) return;
  for (int i = 0; i < 43; i++) {
    if (!okay[i]) continue;
    if ((c + i) % 10 == cc[len] && mem[len][c] == dp(len + 1, (c + i) / 10)) {
      vec.push_back(i);
      path(len + 1, (c + i) / 10);
      return;
    }
  }
  return;
}
vector<int> v[44];
bool ok(int cnt, int sum, int x) {
  if (!cnt) return (sum == 0);
  for (int i = 0; i < 3; i++) {
    if (ok(cnt - 1, sum - ara[i], x)) {
      v[x].push_back(ara[i]);
      return 1;
    }
  }
  return 0;
}
int main() {
  ara[0] = 0;
  ara[1] = 4;
  ara[2] = 7;
  for (int i = 0; i < 43; i++) {
    okay[i] = ok(6, i, i);
  }
  long long n;
  int ts;
  cin >> ts;
  while (ts--) {
    cin >> n;
    int k = 0;
    while (n > 0ll) {
      cc[k++] = (n % 10ll);
      n /= 10ll;
    }
    sz = k;
    memset(mem, -1, sizeof mem);
    if (dp(0, 0)) {
      vec.clear();
      path(0, 0);
      long long ans[6];
      memset(ans, 0ll, sizeof ans);
      for (int i = vec.size() - 1; i >= 0; i--) {
        int x = vec[i];
        for (int j = 0; j < 6; j++) ans[j] = (ans[j] * 10ll) + v[x][j];
      }
      for (int i = 0; i < 6; i++) cout << ans[i] << " ";
      cout << endl;
    } else
      cout << -1 << endl;
  }
  return 0;
}
