#include <bits/stdc++.h>
using namespace std;
const int LIM = 1e5 + 5, MOD = 1e9 + 7;
const int maxn = 1000006;
long long solve(long long a, long long b) {
  if ((a == b) || (a == 0)) {
    return 0;
  } else {
    long long res;
    res = 1 + solve(a % (b / 2), b / 2);
    return res;
  }
}
long long ft[200005];
long long n;
void update(long long i, long long diff) {
  for (; i <= n; i = i + (i & (-i))) {
    ft[i] += diff;
  }
}
long long query(long long i) {
  long long sum = 0;
  for (; i > 0; i = i - (i & (-i))) {
    sum += ft[i];
  }
  return sum;
}
long long solve(long long z) {
  long long sum = 0, ret = 0, i;
  for (i = 20; i >= 0; i--) {
    if (((ret + (1 << i)) <= n) && ((ft[ret + (1 << i)] + sum) <= z)) {
      ret = ret + (1 << i);
      sum = sum + ft[ret];
    }
  }
  return (ret + 1);
}
int main() {
  long long i, j, k, m;
  cin >> n;
  long long res[n + 5];
  long long s[n + 5];
  for (i = 1; i <= n; i++) ft[i] = 0;
  for (i = 1; i <= n; i++) {
    update(i, i);
    cin >> s[i];
  }
  for (i = n; i >= 1; i--) {
    res[i] = solve(s[i]);
    update(res[i], -res[i]);
  }
  for (i = 1; i <= n; i++) {
    cout << res[i] << " ";
  }
  return 0;
}
