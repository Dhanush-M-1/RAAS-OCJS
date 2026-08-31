#include <bits/stdc++.h>
using namespace std;
const int N = 3000010;
int n, a[N];
int maxr[N];
long long ans, cur;
int id, ansid;
int tmax, tmin, zero;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  ansid = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i] > i)
      maxr[a[i] - i]++, tmax++;
    else if (a[i] < i)
      tmin++;
    else
      zero++;
    ans += abs(i - a[i]);
  }
  cur = ans;
  for (int i = 1; i < n; i++) {
    if (a[n - i + 1] == n) {
      cur -= tmax;
      tmax++;
      tmin += zero - 1;
      cur += tmin;
      zero = maxr[i];
      tmax -= maxr[i];
      maxr[i] = 0;
      cur += n - 1;
    } else if (a[n - i + 1] == 1) {
      cur -= tmax;
      tmin--;
      tmin += zero;
      cur += tmin;
      zero = maxr[i] + 1;
      tmax -= maxr[i];
      maxr[i] = 0;
      cur -= n - 1;
    } else {
      cur -= tmax;
      tmax++;
      maxr[a[n - i + 1] - 1 + i]++;
      tmin--;
      tmin += zero;
      cur += tmin;
      zero = maxr[i];
      tmax -= maxr[i];
      maxr[i] = 0;
      cur -= n - a[n - i + 1];
      cur += a[n - i + 1] - 1;
    }
    if (cur < ans) {
      ans = cur;
      ansid = i;
    }
  }
  cout << ans << " " << ansid << endl;
  return 0;
}
