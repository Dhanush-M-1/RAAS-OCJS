#include <bits/stdc++.h>
using namespace std;
const int maxn = 10e5;
int fl[maxn], fr[maxn], s[maxn], pos[maxn], h[maxn];
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> pos[i] >> h[i];
  fl[0] = 1;
  if (n == 1 || pos[0] + h[0] < pos[1]) fr[0] = 1;
  s[0] = 0;
  for (int i = 1; i < n; i++) {
    int pmax = max(max(fl[i - 1], fr[i - 1]), s[i - 1]);
    s[i] = pmax;
    if (i + 1 < n && pos[i] + h[i] < pos[i + 1]) fr[i] = pmax + 1;
    if (i == n - 1) {
      fr[i] = pmax + 1;
    }
    if (pos[i] - h[i] > pos[i - 1] &&
        !(pos[i] - h[i] > pos[i - 1] + h[i - 1])) {
      fl[i] = max(fl[i - 1], s[i - 1]) + 1;
    }
    if (pos[i] - h[i] > pos[i - 1] + h[i - 1]) {
      fl[i] = pmax + 1;
    }
  }
  cout << max(max(fr[n - 1], fl[n - 1]), s[n - 1]);
  return 0;
}
