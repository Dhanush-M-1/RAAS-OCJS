#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
int rev(int n) {
  int ret = 0;
  while (n != 0) {
    ret = (10 * ret) + (n % 10);
    n /= 10;
  }
  return ret;
}
int main() {
  int mx, my, w;
  int i, j, k, t;
  int ax, ay;
  vector<int> v;
  map<pair<int, int>, vector<int> > mp;
  scanf("%d%d%d", &mx, &my, &w);
  for (i = 1; i <= my; i++) {
    j = rev(i);
    k = gcd(i, j);
    mp[make_pair(i / k, j / k)].push_back(i);
  }
  vector<int> vec(my + 1, 0);
  vector<vector<int> > vv;
  vv.push_back(v);
  for (i = 1; i <= mx; i++) {
    j = rev(i);
    k = gcd(i, j);
    v = mp[make_pair(j / k, i / k)];
    for (j = 0; j < v.size(); j++) vec[v[j]]++;
    vv.push_back(v);
  }
  long long ans = -1;
  for (i = mx, j = 0, k = 0; i > 0; i--) {
    if (k < w && j < my) {
      do {
        j++;
        k += vec[j];
      } while (k < w && j < my);
    }
    if (k >= w && (ans == -1 || ans > (long long)i * j)) {
      ans = (long long)i * j;
      ax = i;
      ay = j;
    }
    for (t = 0; t < vv[i].size(); t++) {
      if (vv[i][t] <= j) k--;
      vec[vv[i][t]]--;
    }
  }
  if (ans == -1)
    printf("-1\n");
  else
    printf("%d %d\n", ax, ay);
  return 0;
}
