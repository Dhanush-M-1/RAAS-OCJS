#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, k;
  cin >> n >> k;
  vector<long long> ones, twos, threes;
  for (long long i = 0; i < n; i++) {
    long long t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1) {
      threes.push_back(t);
    } else {
      if (a == 1) ones.push_back(t);
      if (b == 1) twos.push_back(t);
    }
  }
  long long ans = -1;
  sort((ones).begin(), (ones).end());
  sort((twos).begin(), (twos).end());
  sort((threes).begin(), (threes).end());
  vector<long long> on(ones.size() + 1, 0);
  vector<long long> dos(twos.size() + 1, 0);
  vector<long long> tres(threes.size() + 1, 0);
  for (long long i = 0; i < ones.size(); i++) {
    on[i + 1] = on[i] + ones[i];
  }
  for (long long i = 0; i < twos.size(); i++) {
    dos[i + 1] = dos[i] + twos[i];
  }
  for (long long i = 0; i < threes.size(); i++) {
    tres[i + 1] = tres[i] + threes[i];
  }
  for (long long i = 0; i < tres.size(); i++) {
    long long k2 = i;
    long long k1 = k - i;
    if (k1 >= 0 && k1 < min(on.size(), dos.size())) {
      if (ans == -1) ans = tres[i] + on[k1] + dos[k1];
      ans = min(ans, tres[i] + on[k1] + dos[k1]);
    }
  }
  cout << ans << "\n";
}
