#include <bits/stdc++.h>
using namespace std;
const int MAXN = 110;
long long t, n, l, r, now;
vector<int> q;
int main() {
  cin >> t;
  while (t--) {
    while (q.size()) q.pop_back();
    cin >> n >> l >> r;
    now = 1;
    for (long long i = (1); i <= (n - 1); i++) {
      if (now > r) break;
      if (now + 2 * (n - i) - 1 < l) {
        now = now + 2 * (n - i);
        continue;
      }
      if (now >= l && now + 2 * (n - i) - 1 <= r) {
        for (long long j = (i + 1); j <= (n); j++)
          q.push_back(i), q.push_back(j);
      } else if (now >= l) {
        long long cnt = now;
        for (long long j = (i + 1); j <= (n); j++) {
          q.push_back(i);
          cnt++;
          if (cnt > r) break;
          q.push_back(j);
          cnt++;
          if (cnt > r) break;
        }
      } else if (now + 2 * (n - i) - 1 <= r) {
        long long cnt = now + 2 * (n - i) - 1;
        for (long long j = (n); j >= (i + 1); j--) {
          q.push_back(j);
          cnt--;
          if (cnt < l) break;
          q.push_back(i);
          cnt--;
          if (cnt < l) break;
        }
        reverse(q.begin(), q.end());
      } else {
        long long cnt = now;
        for (long long j = (i + 1); j <= (n); j++) {
          if (cnt >= l && cnt <= r) q.push_back(i);
          cnt++;
          if (cnt >= l && cnt <= r) q.push_back(j);
          cnt++;
        }
        break;
      }
      now = now + 2 * (n - i);
    }
    if (r == n * (n - 1) + 1) q.push_back(1);
    for (vector<int>::iterator it = q.begin(); it != q.end(); it++) {
      printf("%d ", *it);
    }
    printf("\n");
  }
  return 0;
}
