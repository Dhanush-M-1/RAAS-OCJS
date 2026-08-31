#include <bits/stdc++.h>
using namespace std;
const int N = 55;
pair<int, int> a[N];
int main() {
  int n;
  scanf("%d", &n);
  int r;
  for (int i = 0; i < n; ++i) {
    scanf("%d%d%d", &a[i].first, &a[i].second, &r);
  }
  string left = "(((1-abs((t-", mid = ")))+abs((abs((t-", right = "))-1)))";
  string ans1 = "";
  string ans2 = "";
  for (int i = 0; i < n - 1; ++i) {
    ans1 += "(";
    ans2 += "(";
  }
  for (int i = 0; i < n; ++i) {
    string num = to_string(i);
    ans1 +=
        left + num + mid + num + right + "*" + to_string(a[i].first / 2) + ")";
    ans2 +=
        left + num + mid + num + right + "*" + to_string(a[i].second / 2) + ")";
    if (i != 0) ans1 += ")", ans2 += ")";
    if (i != n - 1) ans1 += "+", ans2 += "+";
  }
  cout << ans1 << endl;
  cout << ans2 << endl;
  return 0;
}
