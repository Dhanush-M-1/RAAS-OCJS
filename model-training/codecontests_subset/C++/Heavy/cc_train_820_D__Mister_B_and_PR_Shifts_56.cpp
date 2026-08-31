#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.sync_with_stdio(false);
  long long n;
  cin >> n;
  vector<long long> p(n);
  vector<long long> passing(n);
  long long before = 0;
  long long after = 0;
  long long sum = 0;
  for (int i = 0; i < int(n); ++i) {
    cin >> p[i];
    --p[i];
    ++passing[(p[i] - i + n) % n];
    if (p[i] < i)
      ++after;
    else
      ++before;
    sum += abs(p[i] - i);
  }
  long long minSum = sum;
  long long best = 0;
  for (int i = 0; i < int(n); ++i) {
    if (sum < minSum) {
      minSum = sum;
      best = i;
    }
    before -= passing[i];
    after += passing[i];
    sum -= before;
    sum += after;
    long long last = n - 1 - i;
    ++before;
    --after;
    sum += p[last] - ((n)-p[last]);
  }
  cout << minSum << " " << best << endl;
}
