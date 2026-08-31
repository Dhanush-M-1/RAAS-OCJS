#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, ans(0);
  scanf("%d", &a);
  vector<int> home(a), guest(a);
  for (int i = 0; i < a; ++i) {
    cin >> home[i] >> guest[i];
    for (int j = 0; j < i; j++) {
      if ((home[i] == guest[j])) ++ans;
      if (home[j] == guest[i]) ++ans;
    }
  }
  cout << ans << "\n";
  return 0;
}
