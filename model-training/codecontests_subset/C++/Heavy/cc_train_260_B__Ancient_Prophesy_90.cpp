#include <bits/stdc++.h>
using namespace std;
void prv(vector<int> v) {
  int n = v.size();
  for (int i = 0; i < n; i++) cout << v[i] << " ";
}
void swap(long long int &a, long long int &b) {
  int tm = a;
  a = b;
  b = tm;
}
bool comp(const pair<int, int> &p1, const pair<int, int> &p2) {
  if (p1.first > p2.first)
    return 1;
  else
    return 0;
}
const int N = 3e5 + 5;
void findPrefix(string pattern, int m, int prefArray[]) {
  int length = 0;
  prefArray[0] = 0;
  for (int i = 1; i < m; i++) {
    if (pattern[i] == pattern[length]) {
      length++;
      prefArray[i] = length;
    } else {
      if (length != 0) {
        length = prefArray[length - 1];
        i--;
      } else
        prefArray[i] = 0;
    }
  }
}
int kmpPattSearch(string mainString, string pattern) {
  int n, m, i = 0, j = 0, fr = 0;
  n = mainString.size();
  m = pattern.size();
  int prefixArray[m];
  findPrefix(pattern, m, prefixArray);
  while (i < n) {
    if (mainString[i] == pattern[j]) {
      i++;
      j++;
    }
    if (j == m) {
      fr++;
      j = prefixArray[j - 1];
    } else if (i < n && pattern[j] != mainString[i]) {
      if (j != 0)
        j = prefixArray[j - 1];
      else
        i++;
    }
  }
  return fr;
}
string crts(int d, int m, int y) {
  string t;
  t.clear();
  while (y != 0) {
    t.push_back(y % 10 + '0');
    y = y / 10;
  }
  t.push_back('-');
  while (m != 0) {
    t.push_back(m % 10 + '0');
    m = m / 10;
  }
  if (t.size() == 6) t.push_back('0');
  t.push_back('-');
  while (d != 0) {
    t.push_back(d % 10 + '0');
    d = d / 10;
  }
  if (t.size() == 9) t.push_back('0');
  reverse((t).begin(), (t).end());
  return t;
}
void solve() {
  string s, ans;
  cin >> s;
  int mx = 0;
  for (int i = 2013; i < 2016; ++i) {
    for (int j = 1; j <= 12; j++) {
      int k;
      if (j == 2)
        k = 28;
      else if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 ||
               j == 12)
        k = 31;
      else
        k = 30;
      for (int l = 1; l <= k; l++) {
        string t;
        int frq;
        t = crts(l, j, i);
        frq = kmpPattSearch(s, t);
        if (frq > mx) {
          mx = frq;
          ans = t;
        }
      }
    }
  }
  cout << ans;
}
signed int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
    cout << "\n";
  }
  return 0;
}
