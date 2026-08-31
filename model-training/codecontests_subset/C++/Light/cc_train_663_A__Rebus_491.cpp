#include <bits/stdc++.h>
using namespace std;
const int N = 1e6;
vector<int> make(int num, int n, int x) {
  vector<int> v;
  for (int i = 1; i <= n; i++) {
    int mx = (num - (n - i));
    int now = min(mx, x);
    v.push_back(now);
    num -= now;
  }
  return v;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  string s;
  getline(cin, s);
  int pl = 1, mn = 0;
  for (int i = 0; i < s.size(); i++) {
    char x = s[i];
    if (x == '+') pl++;
    if (x == '-') mn++;
  }
  stringstream str(s);
  string num;
  while (str >> num)
    ;
  stringstream srt(num);
  int n;
  srt >> n;
  int plo = pl, phi = pl * n;
  int mlo = mn + n, mhi = mn * n + n;
  if (phi < mlo || plo > mhi) cout << "Impossible" << endl, exit(0);
  int pt = max(plo, mlo);
  vector<int> v1 = make(pt, pl, n);
  vector<int> v2 = make(pt - n, mn, n);
  cout << "Possible" << endl;
  int pr = 0, pt1 = 0, pt2 = 0;
  for (int i = 0; i < s.size(); i++) {
    char x = s[i];
    if (x == '?') {
      if (!pr)
        cout << v1[pt1++];
      else
        cout << v2[pt2++];
    } else {
      if (x == '+') pr = 0;
      if (x == '-') pr = 1;
      cout << x;
    }
  }
  cout << endl;
  return 0;
}
