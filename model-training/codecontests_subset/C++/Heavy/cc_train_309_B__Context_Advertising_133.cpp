#include <bits/stdc++.h>
using namespace std;
string i_s(int x) {
  if (x == 0) return "0";
  string ret = "";
  while (x) {
    ret = ret + (char)(x % 10 + '0');
    x /= 10;
  }
  reverse(ret.begin(), ret.end());
  return ret;
}
string add(string a, string b) {
  if (a == "") a = "0";
  if (b == "") b = "0";
  if (a.length() < b.length()) swap(a, b);
  while (b.length() < a.length()) {
    b = '0' + b;
  }
  for (int i = 0; i < a.length(); i++) {
    a[i] = a[i] + (b[i] - '0');
  }
  bool big = false;
  for (int i = a.length() - 1; i >= 0; i--) {
    if (big) {
      a[i]++;
    }
    big = false;
    if (a[i] > '9') {
      a[i] = a[i] - 10;
      big = true;
    }
  }
  if (big) a = '1' + a;
  return a;
}
string mul(string a, string b) {
  vector<int> va, vb;
  if (a == "0" || b == "0") return "0";
  string ans;
  for (int i = 0; i < a.length(); i++) {
    va.push_back(a[i] - '0');
  }
  for (int i = 0; i < b.length(); i++) {
    vb.push_back(b[i] - '0');
  }
  reverse(va.begin(), va.end());
  reverse(vb.begin(), vb.end());
  vector<int> res;
  res.clear();
  res.resize(1005);
  for (int i = 0; i < a.length(); i++) {
    for (int j = 0; j < b.length(); j++) {
      res[i + j] += (va[i] * vb[j]);
    }
  }
  for (int i = 0; i < 1005; i++) {
    if (res[i] > 9) {
      res[i + 1] += (res[i] / 10);
      res[i] %= 10;
    }
  }
  for (int i = 0; i < 1005; i++) {
    ans += (res[i] + '0');
  }
  reverse(ans.begin(), ans.end());
  int k = 0;
  while (ans[k] == '0') {
    k++;
  }
  ans = ans.substr(k);
  return ans;
}
int n, c, r, ans;
int l[1000005], res[1000005], sum[1000005];
int st[1000005][21];
string s[1000005];
int main() {
  cin >> n >> r >> c;
  for (int i = 0; i < n; i++) cin >> s[i], l[i] = s[i].size();
  for (int i = 0; i < n; i++) sum[i] = l[i] + (i ? sum[i - 1] + 1 : 0);
  for (int i = 0; i < n; i++) {
    int &pos = st[i][0];
    pos = upper_bound(sum, sum + n, (i ? (sum[i - 1] + 1) : 0) + c) - sum;
    pos = max(pos, i);
  }
  for (int j = 1; j < 21; j++)
    for (int i = 0; i < n; i++) {
      if (st[i][j - 1] == n)
        st[i][j] = n;
      else
        st[i][j] = st[st[i][j - 1]][j - 1];
    }
  st[n][0] = n;
  for (int i = 0; i < n; i++) {
    int j = i;
    for (int k = 20; k >= 0; --k)
      if (r >> k & 1) {
        j = st[j][k];
        if (j == n) break;
      }
    ans = max(ans, j - i);
    res[i] = j;
  }
  for (int i = 0; i < n; i++)
    if (res[i] - i == ans) {
      int len = 0;
      for (int j = i; j < res[i]; j++) {
        if (j == i) {
          cout << s[j];
          len += l[j];
          continue;
        }
        if (len + l[j] + 1 > c) {
          puts("");
          cout << s[j];
          len = l[j];
        } else {
          cout << " " << s[j];
          len += l[j] + 1;
        }
      }
      return 0;
    }
  return 0;
}
