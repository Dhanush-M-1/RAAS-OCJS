#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<int> v;
  v.push_back(1);
  int n;
  while (1) {
    char c;
    scanf("%c", &c);
    if (c == '?') continue;
    if (c == '=') {
      cin >> n;
      break;
    }
    if (c == '-') v.push_back(-1);
    if (c == '+') v.push_back(1);
  }
  int pl = 0, mi = 0, k = v.size();
  for (int i = 0; i < k; i++) {
    if (v[i] < 0)
      mi++;
    else
      pl++;
  }
  if (n > (pl * n - mi * 1)) {
    cout << "Impossible" << endl;
    return 0;
  }
  if (n < (pl * 1 - mi * n)) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  int ans[1010];
  for (int i = 1; i <= k; i++) {
    if (v[i - 1] == -1)
      ans[i] = n;
    else
      ans[i] = 1;
  }
  int dif = n - (pl * 1 - mi * n);
  for (int i = 1; i <= k; i++) {
    if (dif == 0) break;
    if (v[i - 1] == -1) {
      while (ans[i] > 1) {
        ans[i]--;
        dif--;
        if (dif == 0) break;
      }
      if (dif == 0) break;
    } else {
      while (ans[i] < n) {
        ans[i]++;
        dif--;
        if (dif == 0) break;
      }
    }
  }
  cout << ans[1] << " ";
  for (int i = 2; i <= k; i++) {
    if (v[i - 1] == -1)
      cout << "- ";
    else
      cout << "+ ";
    cout << ans[i] << " ";
  }
  cout << "= " << n << endl;
}
