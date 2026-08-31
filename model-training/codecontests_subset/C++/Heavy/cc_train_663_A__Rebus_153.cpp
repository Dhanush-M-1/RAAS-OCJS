#include <bits/stdc++.h>
using namespace std;
void solve(int test_number);
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cout.setf(ios::fixed);
  cout.precision(9);
  cerr.setf(ios::fixed);
  cerr.precision(3);
  int n = 1;
  for (int i = 0; i < n; i++) {
    solve(i + 1);
  }
  return 0;
}
const int MAXN = 1010;
string s;
int a[MAXN];
int pos[MAXN];
int neg[MAXN];
void fail() {
  cout << "Impossible" << endl;
  exit(0);
}
void solve(int test_number) {
  getline(cin, s);
  int cnt_pos, cnt_neg;
  cnt_pos = cnt_neg = 0;
  for (char c : s) {
    if (c == '+')
      cnt_pos++;
    else if (c == '-')
      cnt_neg++;
  }
  string x;
  int cur = s.length() - 1;
  while (s[cur] != ' ') {
    x = s[cur] + x;
    cur--;
  }
  int res = atoi(x.c_str());
  while (s.back() != '=') s.erase(s.length() - 1, 1);
  s.erase(s.length() - 1, 1);
  x = "";
  for (char c : s) {
    if (c != ' ' && c != '?') x += c;
  }
  cnt_pos++;
  for (int i = 0; i < cnt_pos; i++) {
    pos[i] = 1;
  }
  for (int i = 0; i < cnt_neg; i++) {
    neg[i] = 1;
  }
  int bal = (cnt_pos - cnt_neg) - res;
  while (bal != 0) {
    if (bal > 0) {
      int p = 0;
      for (int i = 0; i < cnt_neg; i++) {
        if (neg[i] < neg[p]) p = i;
      }
      if (p >= cnt_neg) fail();
      neg[p]++;
      if (neg[p] > res) fail();
      bal--;
    } else {
      int p = 0;
      for (int i = 0; i < cnt_pos; i++) {
        if (pos[i] < pos[p]) p = i;
      }
      if (p >= cnt_pos) fail();
      pos[p]++;
      if (pos[p] > res) fail();
      bal++;
    }
  }
  cout << "Possible" << endl;
  int cp = 0, cn = 0;
  int n = cnt_neg + cnt_pos;
  cout << pos[0] << " ";
  cp = 1;
  for (int i = 0; i < n - 1; i++) {
    cout << x[i] << ' ';
    if (x[i] == '+')
      cout << pos[cp++] << " ";
    else
      cout << neg[cn++] << " ";
  }
  cout << "= " << res << endl;
}
