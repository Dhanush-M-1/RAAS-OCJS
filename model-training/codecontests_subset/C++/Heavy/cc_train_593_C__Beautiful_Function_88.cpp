#include <bits/stdc++.h>
using namespace std;
const int N = 53;
pair<int, int> a[N];
inline int read() {
  register int x;
  cin >> x;
  return x;
}
string Left, Mid, Right, ans1, ans2, num;
int main() {
  register int n = read(), r;
  for (register int i = 0; i < n; ++i)
    a[i].first = read(), a[i].second = read(), r = read();
  Left = "(((1-abs((t-", Mid = ")))+abs((abs((t-", Right = "))-1)))";
  for (register int i = 0; i < n - 1; ++i) ans1 += "(", ans2 += "(";
  for (register int i = 0; i < n; ++i) {
    num = to_string(i),
    ans1 +=
        Left + num + Mid + num + Right + "*" + to_string(a[i].first >> 1) + ")",
    ans2 += Left + num + Mid + num + Right + "*" + to_string(a[i].second >> 1) +
            ")";
    if (i) ans1 += ")", ans2 += ")";
    if (i != n - 1) ans1 += "+", ans2 += "+";
  }
  cout << ans1 << endl << ans2 << endl;
  return 0;
}
