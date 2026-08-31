#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s;
  string ll;
  cin >> s;
  int l = s.size();
  int a[27] = {0};
  for (int i = 0; i < l; i++) {
    a[s[i] - 96] += 1;
  }
  int i = 0;
  for (i = 1; i < 27; i++) {
    if (a[i] % k != 0) break;
  }
  if (i < 27) {
    cout << -1 << endl;
  } else {
    for (int i = 1; i < 27; i++) ll.append(a[i] / k, i + 96);
  }
  for (int i = 0; i < k; i++) cout << ll;
  return 0;
}
