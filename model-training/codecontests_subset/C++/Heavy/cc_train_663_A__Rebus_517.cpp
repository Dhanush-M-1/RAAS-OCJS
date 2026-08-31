#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const double PI = acos(-1);
const int INF = (int)1e9 + 9;
const int MAXN = (int)3e5 + 7;
char ch[MAXN];
int val[11111];
int n;
string second;
int main() {
  getline(cin, second);
  char sign = '+';
  int i = 0;
  vector<int> pos, neg;
  for (i = 0; i < second.size(); i++) {
    if (second[i] == '=') break;
    if (second[i] == '+')
      sign = '+';
    else if (second[i] == '-')
      sign = '-';
    if (second[i] == '?') {
      if (sign == '+')
        pos.push_back(i);
      else
        neg.push_back(i);
    }
  }
  for (; i < second.size(); i++)
    if (isdigit(second[i])) n = n * 10 + second[i] - '0';
  int max_val = n * (int)pos.size() - (int)neg.size();
  int min_val = (int)pos.size() - n * (int)neg.size();
  if (min_val <= n && n <= max_val) {
    cout << "Possible\n";
    for (auto it : neg) val[it] = 1;
    int tot = -n;
    for (auto it : neg) {
      val[it] = 1;
      tot--;
    }
    for (auto it : pos) {
      val[it] = 1;
      tot++;
    }
    for (auto it : pos) {
      if (tot >= 0) break;
      int k = min(n - 1, -tot);
      val[it] += k;
      tot += k;
    }
    for (auto it : neg) {
      if (tot <= 0) break;
      int k = min(n - 1, tot);
      val[it] += k;
      tot -= k;
    }
    for (int i = 0; i < second.size(); i++) {
      bool skip = 0;
      for (auto it : pos)
        if (it == i) skip = 1;
      for (auto it : neg)
        if (it == i) skip = 1;
      if (!skip)
        cout << second[i];
      else
        cout << val[i];
    }
  } else {
    cout << "Impossible";
  }
  return 0;
}
