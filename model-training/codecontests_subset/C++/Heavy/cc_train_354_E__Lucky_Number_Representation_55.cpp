#include <bits/stdc++.h>
using namespace std;
string s[7];
int n;
long long a[5001];
vector<pair<int, pair<int, int>>> mask[20];
pair<int, pair<int, int>> last[100];
vector<int> carry[20];
bool calc(long long x) {
  if (x <= 42) {
    int a = last[x].first, b = last[x].second.first, c = last[x].second.second;
    if (a + b + c) {
      for (int i = 1; i <= a; ++i) s[i] += '7';
      for (int i = a + 1; i <= a + b; ++i) s[i] += '4';
      for (int i = a + b + 1; i <= 6; ++i) s[i] += '0';
      return 1;
    };
  }
  long long cur = x;
  int mod = cur % 10;
  if (!carry[mod].size()) return 0;
  for (int i = 0; i < carry[mod].size(); ++i) {
    cur = x / 10;
    cur -= carry[mod][i];
    if (cur <= 0) continue;
    if (calc(cur)) {
      int a = mask[mod][i].first, b = mask[mod][i].second.first,
          c = mask[mod][i].second.second;
      for (int i = 1; i <= a; ++i) s[i] += '7';
      for (int i = a + 1; i <= a + b; ++i) s[i] += '4';
      for (int i = a + b + 1; i <= 6; ++i) s[i] += '0';
      return 1;
    }
  }
  return 0;
}
int main() {
  ios::sync_with_stdio(0);
  cin >> n;
  for (int a = 0; a <= 6; ++a) {
    for (int b = 0; b + a <= 6; ++b) {
      int x = 6 - a - b;
      int second = a * 7 + b * 4;
      carry[second % 10].push_back(second / 10);
      mask[second % 10].push_back(make_pair(a, make_pair(b, x)));
      last[second] = make_pair(a, make_pair(b, x));
    }
  }
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    for (int j = 1; j <= 6; ++j) s[j] = "";
    if (calc(a[i])) {
      for (int i = 1; i <= 6; ++i) {
        while (s[i].length() > 1 && s[i][0] == '0') s[i].erase(0, 1);
        cout << s[i] << ' ';
        ;
      }
    } else
      cout << -1;
    cout << "\n";
  }
}
