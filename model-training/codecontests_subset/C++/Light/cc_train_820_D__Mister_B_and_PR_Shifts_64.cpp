#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
bool Max(T1& a, T2 b) {
  return a < b ? a = b, 1 : 0;
}
template <typename T1, typename T2>
bool Min(T1& a, T2 b) {
  return a > b ? a = b, 1 : 0;
}
const int N = 1000001;
long long _a[3 * N], *a = _a + 2 * N;
long long pos[N];
void solve() {
  long long n, v;
  cin >> n;
  long long less = 0;
  long long dif = 0;
  for (int i = 1; i <= (n); ++i) {
    cin >> v;
    a[i - v]++;
    pos[i] = i - v;
    less += i < v;
    dif += abs(i - v);
  }
  long long mini = 0;
  long long ans = dif;
  long long cur = 0;
  for (int i = 1; i <= (n - 1); ++i) {
    dif += 2 * (cur - pos[n + 1 - i]) + n;
    a[pos[n + 1 - i] - n]++;
    less++;
    dif += n - 2 * less;
    if (Min(ans, dif)) mini = i;
    less -= a[--cur];
  }
  cout << ans << ' ' << mini << '\n';
}
void init() {}
int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.setf(ios::fixed);
  cout.precision(20);
  init();
  solve();
  return 0;
}
