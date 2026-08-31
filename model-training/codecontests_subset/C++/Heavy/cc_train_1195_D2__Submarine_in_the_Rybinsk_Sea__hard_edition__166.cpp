#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  long long arr[n];
  for (long long i = 0; i < n; i++) cin >> arr[i];
  long long powa[25];
  powa[0] = 1;
  for (long long i = 1; i < 25; i++) {
    powa[i] = powa[i - 1] * 10;
    powa[i] %= 998244353;
  }
  long long store[n][12];
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    for (long long j = 1; j < 12; j++) {
      long long temp = arr[i];
      long long cnt = 0;
      long long tempo = 0;
      long long mul = 1;
      while (cnt < j && temp > 0) {
        tempo += ((temp % 10) * mul) % 998244353;
        tempo %= 998244353;
        mul *= 100;
        mul %= 998244353;
        temp /= 10;
        cnt++;
      }
      tempo *= 11;
      tempo %= 998244353;
      tempo += (((2 * temp) % 998244353) * (powa[2 * j])) % 998244353;
      tempo %= 998244353;
      store[i][j] = tempo;
    }
  }
  long long bcnt[n];
  unordered_map<long long, long long> hold;
  for (long long i = 0; i < n; i++) {
    long long temp = arr[i];
    long long cnt = 0;
    while (temp != 0) {
      temp /= 10;
      cnt++;
    }
    hold[cnt]++;
    bcnt[i] = cnt;
  }
  for (long long i = 0; i < n; i++) {
    for (auto it = hold.begin(); it != hold.end(); it++) {
      ans += (it->second * (store[i][it->first])) % 998244353;
      ans %= 998244353;
    }
  }
  cout << ans;
  return 0;
}
