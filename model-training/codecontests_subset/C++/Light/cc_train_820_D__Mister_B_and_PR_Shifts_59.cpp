#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 7;
const long long longinf = 1LL << 60;
const long long mod = 1e9 + 7;
const long long mod2 = 998244353;
const long double eps = 1e-10;
template <typename T1, typename T2>
inline void chmin(T1 &a, T2 b) {
  if (a > b) a = b;
}
template <typename T1, typename T2>
inline void chmax(T1 &a, T2 b) {
  if (a < b) a = b;
}
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<int> P(n);
  for (int i = (int)(0); i < (int)(n); i++) cin >> P[i];
  vector<int> cnt(n);
  for (int i = (int)(0); i < (int)(n); i++) cnt[(P[i] - i - 1 + n) % n]++;
  long long tmp = 0;
  long long mn = longinf;
  int mni = 0;
  int h = 0, l = 0;
  for (int i = (int)(0); i < (int)(n); i++) {
    tmp += abs(P[i] - i - 1);
    (P[i] - i - 1 > 0 ? h : l)++;
  }
  for (int i = (int)(0); i < (int)(n); i++) {
    if (mn > tmp) {
      mn = tmp;
      mni = i;
    }
    tmp -= abs(P[n - 1 - i] - n);
    tmp += abs(P[n - 1 - i] - 1);
    tmp += (l - 1) - h;
    l += cnt[(i + 1) % n];
    h -= cnt[(i + 1) % n];
    l--;
    h++;
  }
  cout << mn << ' ' << mni << '\n';
  return 0;
}
