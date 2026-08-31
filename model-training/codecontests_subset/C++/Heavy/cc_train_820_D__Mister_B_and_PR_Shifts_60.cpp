#include <bits/stdc++.h>
using namespace std;
long long n, ans, len, sumi, kl, k[2000100], p[2000100], sum, wapi[2000100],
    wai[2000100];
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &p[i]);
    wapi[max(0ll, i - p[i])] += p[i];
    wai[max(0ll, i - p[i])] += i;
    ++k[max(0ll, i - p[i])];
    sum += p[i];
  }
  for (int i = 1; i <= n; ++i) {
    p[i + n] = p[i];
    wapi[max(0ll, i + n - p[i])] += p[i];
    wai[max(0ll, i + n - p[i])] += i + n;
    ++k[max(0ll, i + n - p[i])];
  }
  len = 1e18;
  long long sumwapi = 0, sumwai = 0;
  for (int i = n * 2; i > n + 1; --i) {
    sumwapi += wapi[i];
    sumwai += wai[i];
    kl += k[i];
  }
  for (int i = n + 1; i; --i) {
    sumwapi += wapi[i] - wapi[i + n];
    sumwai += wai[i] - wai[i + n];
    kl += k[i] + k[i + n];
    long long s = 2 * (sumwai - i * kl + kl) - 2 * sumwapi;
    wapi[max(0ll, i + n - 1 - p[i + n - 1])] -= p[i + n - 1];
    wai[max(0ll, i + n - 1 - p[i + n - 1])] -= i + n - 1;
    --k[max(0ll, i + n - 1 - p[i + n - 1])];
    if (max(0ll, i + n - 1 - p[i + n - 1]) >= i) {
      sumwapi -= p[i + n - 1];
      sumwai -= i + n - 1;
      --kl;
    }
    if (s < len) {
      len = s;
      ans = n + 1 - i;
    }
  }
  cout << len << ' ' << ans;
}
