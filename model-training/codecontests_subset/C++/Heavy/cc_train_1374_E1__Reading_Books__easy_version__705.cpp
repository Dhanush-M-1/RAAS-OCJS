#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int i, j, a, b, t;
  vector<int> time, temp1, temp2;
  for (i = 0; i < n; i++) {
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      time.push_back(t);
    else if (a == 1)
      temp1.push_back(t);
    else if (b == 1)
      temp2.push_back(t);
  }
  sort(temp1.begin(), temp1.end());
  sort(temp2.begin(), temp2.end());
  j = min(temp1.size(), temp2.size());
  for (i = 0; i < j; i++) time.push_back(temp1[i] + temp2[i]);
  sort(time.begin(), time.end());
  j = time.size();
  if (j < k) {
    cout << "-1\n";
  } else {
    int ans = 0;
    for (i = 0; i < k; i++) ans += time[i];
    cout << ans << endl;
  }
  return 0;
}
