#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  scanf("%d %d", &n, &k);
  long long ans = 0;
  priority_queue<int, vector<int>, greater<int>> q1, q2, q3;
  int ct1 = 0;
  int ct2 = 0;
  for (int i = 1; i <= n; i++) {
    long long t;
    int a, b;
    scanf("%lld %d %d", &t, &a, &b);
    if (a == 1) ct1++;
    if (b == 1) ct2++;
    if (a == 1 && b == 0) {
      q1.push(t);
    }
    if (a == 0 && b == 1) {
      q2.push(t);
    }
    if (a == 1 && b == 1) {
      q3.push(t);
    }
  }
  int hehe = min(ct1, ct2);
  if (hehe < k) {
    printf("-1");
    return 0;
  }
  for (int kk = 1; kk <= k; kk++) {
    if (!q1.empty() && !q2.empty()) {
      int now = q1.top() + q2.top();
      if (!q3.empty()) {
        int now2 = q3.top();
        if (now < now2) {
          ans += now;
          q1.pop();
          q2.pop();
        } else {
          ans += now2;
          q3.pop();
        }
      } else {
        ans += now;
        q1.pop();
        q2.pop();
      }
    } else {
      if (!q3.empty()) {
        int now2 = q3.top();
        ans += now2;
        q3.pop();
      }
    }
  }
  printf("%lld\n", ans);
  return 0;
}
