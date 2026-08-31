#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
int n, r, c, num[1000010][30], sum[1000010], mx = 0, sta;
string s[1000010];
vector<vector<string> > ans;
vector<string> t;
bool check(int mid, int i) {
  return sum[i + mid - 1] - sum[i - 1] + mid - 1 <= c;
}
int main() {
  cin >> n >> r >> c;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
    sum[i] = sum[i - 1] + s[i].size();
  }
  for (int i = 1; i <= n; i++) {
    int lb = 0, ub = n - i + 1, mid;
    while (lb < ub) {
      mid = (lb + ub + 1) / 2;
      if (check(mid, i))
        lb = mid;
      else
        ub = mid - 1;
    }
    num[i][0] = lb;
  }
  for (int i = 1; i <= 22; i++)
    for (int j = 1; j <= n; j++)
      num[j][i] = num[j][i - 1] + num[j + num[j][i - 1]][i - 1];
  for (int i = 1; i <= n; i++) {
    int tmp = r, cc = 0, now = i;
    while (tmp > 0) {
      if (tmp % 2 == 1) now += num[now][cc];
      cc++;
      tmp /= 2;
    }
    now--;
    if (mx < now - i + 1) {
      mx = now - i + 1;
      sta = i;
    }
  }
  int len = -1;
  for (int i = sta; i < sta + mx; i++) {
    if (len + s[i].size() + 1 > c) {
      ans.push_back(t);
      t.clear();
      t.push_back(s[i]);
      len = s[i].size();
    } else {
      len += s[i].size() + 1;
      t.push_back(s[i]);
    }
  }
  ans.push_back(t);
  for (int i = 0; i < ans.size(); i++) {
    for (int j = 0; j < ans[i].size(); j++) {
      cout << ans[i][j];
      if (j < ans[i].size() - 1) cout << ' ';
    }
    cout << endl;
  }
  return 0;
}
