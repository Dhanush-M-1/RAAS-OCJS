#include <bits/stdc++.h>
using namespace std;
int A[1000001];
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> A[i];
  }
  map<int, int> change_v;
  int above = 0, below = 0;
  long long sum = 0;
  long long best_i = 0;
  for (int i = 0; i < n; i++) {
    int xs = A[i] - i - 1;
    int x = (xs > 0) ? xs : -1 * xs;
    if (xs < 0) {
      change_v[x]++;
    }
    if (xs < 0) {
      below++;
    } else {
      above++;
    }
    sum += x;
  }
  long long best_sum = sum;
  for (int i = 0; i < n - 1; i++) {
    long long xs = A[i] - n;
    long long x = (xs > 0) ? xs : -1 * xs;
    long long cnt = change_v[i + 1];
    if (xs < 0) {
      change_v[x + i + 1]++;
    }
    int cur_below_d = (A[i] - 1 < 0) ? 1 : 0;
    int cur_above_d = (A[i] - 1 >= 0) ? 1 : 0;
    sum -= below - cur_below_d;
    sum += above - cur_above_d;
    sum -= (A[i] - 1 > 0) ? A[i] - 1 : 1 - A[i];
    sum += x;
    above += cnt;
    below -= cnt;
    if (xs < 0 && A[i] - 1 >= 0) {
      below++;
      above--;
    }
    if (sum < best_sum) {
      best_i = i + 1;
      best_sum = sum;
    }
  }
  if (best_i != 0) {
    best_i = n - best_i;
  }
  cout << best_sum << " " << best_i;
}
