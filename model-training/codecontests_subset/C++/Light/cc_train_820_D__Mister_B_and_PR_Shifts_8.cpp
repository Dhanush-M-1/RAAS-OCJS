#include <bits/stdc++.h>
using namespace std;
int n, a[1000000], ans, status[1000000];
long long sum, dev, tot;
vector<int> ins[1000005];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    a[i]--;
    sum += abs(a[i] - i);
    if (i == n - 1)
      status[i] = 2 * a[i] - n + 1;
    else
      status[i] = a[i] > i ? -1 : 1;
    tot += status[i];
    ins[a[i] > i ? a[i] - i : a[i] - i + n].push_back(i);
    ins[n - i - 1].push_back(i);
    ins[n - i].push_back(i);
  }
  dev = sum;
  ans = 0;
  for (int i = 1; i < n; i++) {
    sum += tot;
    if (sum < dev) {
      dev = sum;
      ans = i;
    }
    int sz = ins[i].size();
    for (int j = 0; j < sz; j++) {
      int k = ins[i][j];
      tot -= status[k];
      status[k] = abs(a[k] - (i + k + 1) % n) - abs(a[k] - (i + k) % n);
      tot += status[k];
    }
  }
  cout << dev << ' ' << ans << endl;
  return 0;
}
