#include <bits/stdc++.h>
using namespace std;
vector<int> mns, pls;
string s;
int num, dir, i, now, n, j;
int x[1000020], ans[1000200];
int main() {
  cin >> s;
  dir = 1;
  while (s != "=") {
    num++;
    x[num] = dir;
    if (dir)
      pls.push_back(num);
    else
      mns.push_back(num);
    cin >> s;
    if (s == "+") {
      dir = 1;
      cin >> s;
    }
    if (s == "-") {
      dir = 0;
      cin >> s;
    }
  }
  cin >> n;
  now = -n + pls.size() - mns.size();
  for (i = 1; i <= num; i++) ans[i] = 1;
  if (now < 0) {
    for (j = 0; j < pls.size(); j++) {
      ans[pls[j]] += min(n - 1, -now);
      now += min(n - 1, -now);
    }
  }
  if (now > 0) {
    for (j = 0; j < mns.size(); j++) {
      ans[mns[j]] += min(n - 1, now);
      now -= min(n - 1, now);
    }
  }
  if (now != 0) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  cout << ans[1];
  for (j = 2; j <= num; j++)
    if (x[j])
      cout << " + " << ans[j];
    else
      cout << " - " << ans[j];
  cout << " = " << n << endl;
}
