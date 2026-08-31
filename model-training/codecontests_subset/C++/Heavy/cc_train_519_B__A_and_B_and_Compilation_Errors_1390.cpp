#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1e5 + 10;
long long freq1[maxn];
long long freq2[maxn];
long long freq3[maxn];
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  for (long long j = 1; j <= n; j++) {
    cin >> freq1[j];
  }
  for (long long j = 1; j <= n - 1; j++) {
    cin >> freq2[j];
  }
  for (long long j = 1; j <= n - 2; j++) {
    cin >> freq3[j];
  }
  sort(freq1 + 1, freq1 + n + 1);
  sort(freq2 + 1, freq2 + n);
  sort(freq3 + 1, freq3 + n - 1);
  long long flag = 1, flag1 = 1;
  for (long long j = 1; j <= n; j++) {
    if (freq1[j] != freq2[j]) {
      cout << freq1[j] << "\n";
      break;
    }
  }
  for (long long j = 1; j <= n - 1; j++) {
    if (freq2[j] != freq3[j]) {
      cout << freq2[j] << "\n";
      break;
    }
  }
}
