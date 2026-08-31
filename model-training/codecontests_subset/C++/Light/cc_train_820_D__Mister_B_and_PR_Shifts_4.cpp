#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e15;
const int MAXN = 2e6;
long long p[MAXN], d[MAXN];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> p[i];
  }
  long long k, ans2 = INF;
  long long ans = 0;
  long long s = 0;
  for (int i = 1; i <= n; i++) {
    if (p[i] > i) {
      d[p[i] - i]++;
      ans += p[i] - i;
      s++;
    }
  }
  if (ans < ans2) {
    ans2 = ans;
    k = 0;
  }
  for (int i = 1; i < n; i++) {
    long long ans3 = 0;
    ans3 += p[n - i + 1] - 1;
    if (i + p[n - i + 1] - 1 < n) {
      d[i + p[n - i + 1] - 1]++;
    }
    ans3 += ans - s;
    s = s + 1 - d[i];
    ans = ans3;
    if (ans < ans2) {
      ans2 = ans;
      k = i;
    }
  }
  cout << 2 * ans2 << ' ' << k << endl;
}
