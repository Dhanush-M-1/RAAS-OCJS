#include <bits/stdc++.h>
using namespace std;
int main() {
  char curr;
  vector<int> p;
  int ms = 0, ps = 0, n, curr_sum;
  p.push_back(1);
  ps++;
  while (curr != '=') {
    cin >> curr;
    if ((curr == ' ') || (curr == '?')) continue;
    if (curr == '-') {
      p.push_back(-1);
      ms++;
    }
    if (curr == '+') {
      p.push_back(1);
      ps++;
    }
  }
  cin >> n;
  curr_sum = ps * n - ms;
  if (curr_sum < n) {
    cout << "Impossible" << endl;
    return 0;
  }
  curr_sum = ps - ms * n;
  if (curr_sum > n) {
    cout << "Impossible" << endl;
    return 0;
  }
  vector<int> ans(p.size());
  curr_sum = 0;
  for (int i = 0; i < p.size(); ++i) {
    if (p[i] == 1)
      ans[i] = n;
    else
      ans[i] = -1;
    curr_sum += ans[i];
  }
  int i = 0;
  while (curr_sum != n) {
    if (p[i] == -1) {
      if (ans[i] > (-n)) {
        ans[i]--;
        curr_sum--;
      } else {
        ++i;
        continue;
      }
    } else {
      if (ans[i] > (1)) {
        ans[i]--;
        curr_sum--;
      } else {
        ++i;
        continue;
      }
    }
  }
  cout << "Possible" << endl;
  cout << ans[0] << " ";
  for (int i = 1; i < p.size(); ++i) {
    if (p[i] == 1)
      cout << "+ ";
    else
      cout << "- ";
    cout << abs(ans[i]) << " ";
  }
  cout << "= " << n;
}
