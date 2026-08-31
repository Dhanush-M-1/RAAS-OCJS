#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
int p[N], add[N];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, best = 0;
  long long sum = 0, Min;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> p[i];
  int nrdecr = 0, nrincr = 0;
  for (int i = 1; i <= n; i++) {
    sum += abs(p[i] - i);
    if (i >= p[i])
      add[n - (i - p[i])]++;
    else
      add[p[i] - i]++;
    if (i < n) {
      if (i < p[i])
        nrdecr++;
      else
        nrincr++;
    }
  }
  Min = sum;
  for (int i = 1; i < n; i++) {
    sum += nrincr - nrdecr;
    sum -= abs(p[n + 1 - i] - n);
    sum += abs(p[n + 1 - i] - 1);
    nrincr += add[i] - 1;
    nrdecr -= add[i] - 1;
    if (sum < Min) {
      Min = sum;
      best = i;
    }
  }
  cout << Min << " " << best;
}
