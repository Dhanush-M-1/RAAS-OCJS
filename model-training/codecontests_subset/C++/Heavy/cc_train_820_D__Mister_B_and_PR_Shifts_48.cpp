#include <bits/stdc++.h>
using namespace std;
int ara[1000004];
long long cnt[1000004];
int main() {
  int n;
  scanf("%d", &n);
  long long positive = 0, negative = 0;
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &ara[i]);
    if (ara[i] <= i + 1) {
      positive++;
      cnt[ara[i] - i - 1 + n]++;
    } else {
      negative++;
      cnt[ara[i] - i - 1]++;
    }
    ans += abs(ara[i] - i - 1);
  }
  long long mini = ans, to = 0;
  for (int i = 1; i < n; i++) {
    ans += positive;
    ans -= negative;
    ans--;
    ans -= abs(ara[n - i] - n) - abs(ara[n - i] - 1);
    negative++;
    positive--;
    positive += cnt[i];
    negative -= cnt[i];
    if (mini > ans) {
      mini = ans;
      to = i;
    }
  }
  cout << mini << " " << to << endl;
  return 0;
}
