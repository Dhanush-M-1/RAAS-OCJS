#include <bits/stdc++.h>
using namespace std;
vector<int> pl, mn;
string buf;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  string s;
  getline(cin, s);
  int cnt_pl = 1, cnt_mn = 0;
  buf += '+';
  for (int i = 0; i < ((int)(s.size())); i++) {
    if (s[i] == '+') {
      buf += '+';
      cnt_pl++;
    }
    if (s[i] == '-') {
      buf += '-';
      cnt_mn++;
    }
  }
  pl.assign(cnt_pl, 0);
  mn.assign(cnt_mn, 0);
  int ind = 0;
  while (s[ind] != '=') {
    ind++;
  }
  ind++;
  while (s[ind] == ' ') {
    ind++;
  }
  int n = 0;
  for (int i = ind; i < ((int)(s.size())); i++) {
    if (s[i] < '0' || '9' < s[i]) {
      continue;
    }
    n *= 10;
    n += s[i] - '0';
  }
  int bufn = n;
  n -= (cnt_pl - cnt_mn);
  int ind_mn = 0, ind_pl = 0;
  while (n != 0) {
    if (n < 0) {
      while (ind_mn < ((int)(mn.size())) && mn[ind_mn] == bufn - 1) {
        ind_mn++;
      }
      if (ind_mn == ((int)(mn.size()))) {
        cout << "Impossible\n";
        return 0;
      } else {
        mn[ind_mn]++;
      }
      n++;
    } else {
      while (ind_pl < ((int)(pl.size())) && pl[ind_pl] == bufn - 1) {
        ind_pl++;
      }
      if (ind_pl == ((int)(pl.size()))) {
        cout << "Impossible\n";
        return 0;
      } else {
        pl[ind_pl]++;
      }
      n--;
    }
  }
  cout << "Possible\n";
  ind_pl = 0;
  ind_mn = 0;
  for (int i = 0; i < ((int)(buf.size())); i++) {
    if (i != 0) {
      cout << buf[i] << " ";
    }
    if (buf[i] == '+') {
      cout << pl[ind_pl++] + 1;
    } else {
      cout << mn[ind_mn++] + 1;
    }
    cout << " ";
  }
  cout << "= " << bufn << endl;
  return 0;
}
