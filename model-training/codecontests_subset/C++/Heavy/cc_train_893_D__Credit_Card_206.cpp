#include <bits/stdc++.h>
using namespace std;
long long arr[800001];
long long suf[800001];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t;
  t = 1;
  while (t--) {
    long long n, d;
    cin >> n >> d;
    vector<long long> v1;
    for (long long i = 0; i < n; i++) {
      long long num;
      cin >> num;
      v1.push_back(num);
      if (i > 0) {
        arr[i] += arr[i - 1];
      }
      arr[i] += num;
    }
    for (long long i = n - 1; i >= 0; i--) {
      if (i == n - 1) {
        suf[i] = arr[i];
      } else {
        suf[i] = max(suf[i + 1], arr[i]);
      }
    }
    long long used = 0;
    long long ans = 0;
    for (long long i = 0; i < n; i++) {
      if (v1[i] != 0) {
        if (arr[i] + used > d) {
          cout << "-1";
          return 0;
        }
        continue;
      }
      if (v1[i] == 0 && arr[i] + used >= 0) {
        continue;
      }
      long long max1 = suf[i] + used;
      long long tmp = d - max1;
      if (arr[i] + tmp + used < 0) {
        cout << "-1";
        return 0;
      }
      used += tmp;
      ans++;
    }
    cout << ans;
  }
  return 0;
}
