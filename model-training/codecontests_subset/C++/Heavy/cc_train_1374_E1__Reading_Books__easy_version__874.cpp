#include <bits/stdc++.h>
using namespace std;
long long n, k;
int main() {
  scanf("%lld%lld", &n, &k);
  vector<long long> v, ali, bob;
  for (int i = 0; i < n; i++) {
    long long t, x, y;
    scanf("%lld%lld%lld", &t, &x, &y);
    if (x == 1 && y == 1)
      v.push_back(t);
    else if (x == 1 && y == 0)
      ali.push_back(t);
    else if (x == 0 && y == 1)
      bob.push_back(t);
  }
  sort(ali.begin(), ali.end());
  sort(bob.begin(), bob.end());
  long long mn = min(ali.size(), bob.size());
  for (int i = 0; i < mn; i++) v.push_back(ali[i] + bob[i]);
  sort(v.begin(), v.end());
  if (v.size() < k)
    printf("-1\n");
  else {
    long long ans = 0;
    for (int i = 0; i < k; i++) ans += v[i];
    printf("%lld", ans);
  }
  return 0;
}
