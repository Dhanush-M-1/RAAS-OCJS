#include <bits/stdc++.h>
using namespace std;
int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
int dx[] = {0, 0, 1, -1, 1, -1, 1, -1};
void file() {}
void fast() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(NULL);
}
long long mod = 998244353;
long long x, ans;
int n;
vector<long long> v1;
long long sum[11], sizes[11];
long long p(int cnt) {
  long long ret = 1;
  while (cnt--) {
    ret *= 10;
    ret %= mod;
  }
  return ret;
}
long long solve(int x, int sz, int start) {
  long long num = 0;
  int cnt = start;
  string str = to_string(x);
  reverse(str.begin(), str.end());
  int i = 0;
  for (; i < min((int)(str.size()), sz); i++) {
    num += (str[i] - '0') * p(cnt);
    num %= mod;
    cnt += 2;
  }
  cnt -= start;
  for (; i < (int)(str.size()); i++) {
    num += (str[i] - '0') * p(cnt);
    num %= mod;
    cnt++;
  }
  return num;
}
int main() {
  file();
  fast();
  cin >> n;
  v1.resize(n);
  for (int i = 0; i < n; i++) {
    cin >> v1[i];
    sizes[(int)(log10(v1[i]) + 1)]++;
    for (int j = 1; j <= 10; j++) {
      sum[j] += solve(v1[i], j, 1);
      sum[j] %= mod;
    }
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    long long num = 0;
    for (int j = 1; j <= 10; j++) {
      long long take = solve(v1[i], j, 0);
      take *= sizes[j];
      take %= mod;
      num += take;
      num %= mod;
    }
    ans += num;
    ans %= mod;
    ans += sum[(int)(log10(v1[i]) + 1)];
    ans %= mod;
  }
  cout << ans << "\n";
  return 0;
}
