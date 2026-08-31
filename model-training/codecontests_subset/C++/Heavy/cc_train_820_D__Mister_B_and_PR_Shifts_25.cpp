#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long n;
  cin >> n;
  vector<long long> a(n);
  for (long long i = 0; i < n; i++) cin >> a[i];
  vector<long long> turns_positive_on(n);
  for (long long i = 0; i < n; i++) {
    turns_positive_on[a[i] - 1] = (a[i] - i - 1 + n) % n;
  }
  vector<vector<long long>> transition_map(n, vector<long long>({}));
  for (long long i = 0; i < n; i++) {
    transition_map[turns_positive_on[i]].push_back((i + 1));
  }
  long long curr = 0;
  for (long long i = 0; i < n; i++) curr += abs(a[i] - (i + 1));
  long long ans = curr;
  long long shiftID = 0;
  long long incr = 0;
  long long decr = 0;
  for (long long i = 0; i < n; i++) {
    if (a[i] <= (i + 1))
      incr++;
    else
      decr++;
  }
  long long lastPtr = (n - 1);
  for (long long shift = 1; shift < n; shift++) {
    long long last = a[lastPtr];
    curr += incr;
    curr -= decr;
    assert(incr);
    curr--;
    curr -= (abs(n - last));
    curr += (abs(1 - last));
    lastPtr--;
    incr--;
    decr++;
    decr -= (long long)(transition_map[shift].size());
    incr += (long long)(transition_map[shift].size());
    if (curr < ans) {
      ans = curr;
      shiftID = shift;
    }
  }
  cout << (ans) << ' ' << (shiftID) << ' ' << "\n";
  return 0;
}
