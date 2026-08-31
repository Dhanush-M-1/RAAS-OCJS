#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, n, i, fl = 0;
  scanf("%d", &k);
  string st, res = "";
  cin >> st;
  n = st.size();
  int ar[1000] = {0};
  for (i = 0; i < n; i++) {
    ar[st[i] - 'a']++;
  }
  for (i = 0; i < 26; i++) {
    if (ar[i] % k != 0 && ar[i] > 0) {
      fl = 1;
      break;
    }
  }
  if (fl == 1) {
    printf("-1\n");
    return 0;
  }
  while (k > 0) {
    for (i = 0; i < 26; i++) {
      int t = ar[i] / k;
      for (int j = 0; j < t; j++) {
        res += (i + 'a');
        ar[i]--;
      }
    }
    k--;
  }
  cout << res << endl;
}
