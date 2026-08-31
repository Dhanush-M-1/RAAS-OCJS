#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  long long n;
  cin >> n;
  long long p[n], to_zero[n], numl = 0, numg = 0;
  fill(to_zero, to_zero + n, 0);
  for (int i = 0; i < n; i++) cin >> p[i], p[i]--;
  for (int i = 0; i < n; i++) {
    if (i <= p[i])
      to_zero[p[i] - i]++;
    else if (i > p[i])
      to_zero[n - i + p[i]]++;
  }
  int shift = 0;
  long long curr = 0, min_ans;
  for (long long i = 0; i < n; i++) {
    curr += labs(p[i] - i);
    if (i < p[i])
      numl++;
    else
      numg++;
  }
  min_ans = curr;
  for (long long k = 1; k < n; k++) {
    curr += numg - numl + 2 * p[n - k] - n;
    numl -= to_zero[k] - 1;
    numg = n - numl;
    if (curr < min_ans) min_ans = curr, shift = k;
  }
  cout << min_ans << " " << shift << endl;
  ;
  return 0;
}
