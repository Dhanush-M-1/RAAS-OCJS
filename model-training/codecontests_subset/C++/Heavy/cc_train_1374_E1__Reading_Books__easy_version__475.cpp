#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n, k;
  cin >> n >> k;
  vector<long long> alice;
  vector<long long> bob;
  vector<long long> combined;
  long long atotal = 0, btotal = 0;
  for (long long i = 0; i < n; ++i) {
    long long t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      combined.push_back(t);
    else if (a == 1)
      alice.push_back(t);
    else if (b == 1)
      bob.push_back(t);
    atotal += a;
    btotal += b;
  }
  sort(combined.begin(), combined.end());
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  long long score = 0;
  bool possible = true;
  if (atotal < k || btotal < k) {
    possible = false;
    cout << -1;
  }
  if (possible) {
    long long m = combined.size();
    m = min(k, m);
    for (long long i = 0; i < m; ++i) {
      score += combined[i];
    }
    long long pointer = 0;
    if (m < k) {
      for (long long j = 0; j < k - m; ++j) {
        score += alice[j];
        score += bob[j];
      }
      pointer = k - m;
    }
    long long asize = alice.size();
    long long bsize = bob.size();
    while (pointer < asize && pointer < bsize && pointer < k &&
           alice[pointer] + bob[pointer] < combined[k - 1 - pointer]) {
      score -= combined[k - 1 - pointer];
      score += alice[pointer];
      score += bob[pointer];
      pointer++;
    }
    cout << score;
  }
}
