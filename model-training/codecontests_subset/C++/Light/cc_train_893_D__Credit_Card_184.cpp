#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int n, d;
int a[N];
int main() {
  scanf("%d%d", &n, &d);
  long long sm = 0;
  for (int i = 0; i < n; ++i) {
    scanf("%d", &a[i]);
    sm += a[i];
    if (a[i] == 0 && sm < 0) sm = 0;
    if (sm > d) {
      cout << -1;
      return 0;
    }
  }
  long long sum = 0;
  int cnt = 0, check = 0;
  for (int i = 0; i < n; ++i) {
    sum += a[i];
    if (sum > d) {
      check -= (sum - d);
      sum = d;
      if (check < 0) {
        cout << -1;
        return 0;
      }
    }
    if (a[i] == 0 && sum < 0) {
      cnt++;
      sum = check = d;
    }
  }
  cout << cnt;
}
