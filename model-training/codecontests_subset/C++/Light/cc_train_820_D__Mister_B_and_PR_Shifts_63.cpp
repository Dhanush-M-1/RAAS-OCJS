#include <bits/stdc++.h>
using namespace std;
long long mod = 1000000007LL;
long long base = 37;
long long large = 1000000000000000000LL;
long long labs(long long x) {
  if (x < 0) return -x;
  return x;
}
int main() {
  int n;
  cin >> n;
  vector<long long> p(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> p[i];
    p[i]--;
  }
  long long s = 0;
  for (int i = 0; i < n; i++) s += labs(p[i] - i);
  long long ans = s;
  vector<long long> adj;
  long long cnt = 0;
  vector<long long> eve(n + 1, 0);
  for (int i = 0; i < n; i++) {
    if (p[i] <= i) {
      cnt++;
      eve[n - i + p[i]]++;
    } else {
      eve[p[i] - i]++;
    }
  }
  int k = 0;
  for (int i = 1; i < n; i++) {
    s -= labs(p[n - i] - (n - 1));
    s += p[n - i];
    cnt--;
    s += cnt;
    s -= (1LL * (n - 1) - cnt);
    cnt += eve[i];
    if (s < ans) {
      ans = s;
      k = i;
    }
  }
  cout << ans << " " << k << endl;
  return 0;
}
