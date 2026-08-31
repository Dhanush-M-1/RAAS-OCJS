#include <bits/stdc++.h>
using namespace std;
void takeFrom(vector<long long> &x, long long &cnt, long long &ans) {
  ans += x.back();
  x.pop_back();
  cnt++;
}
void takeFrom(vector<long long> &x, long long &cntA, long long &cntB,
              long long &ans) {
  ans += x.back();
  x.pop_back();
  cntA++;
  cntB++;
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long n, k;
  cin >> n >> k;
  vector<long long> a, b, ab;
  long long countAlice = 0, countBob = 0;
  for (long long i = 0; i < n; i++) {
    long long tym, alice, bob;
    cin >> tym >> alice >> bob;
    if (alice > 0 && bob > 0) {
      ab.push_back(tym);
      countAlice++;
      countBob++;
    } else if (alice) {
      a.push_back(tym);
      countAlice++;
    } else if (bob) {
      b.push_back(tym);
      countBob++;
    }
  }
  if (countAlice < k || countBob < k) return cout << -1, 0;
  sort(a.begin(), a.end());
  reverse(a.begin(), a.end());
  sort(b.begin(), b.end());
  reverse(b.begin(), b.end());
  sort(ab.begin(), ab.end());
  reverse(ab.begin(), ab.end());
  long long ans = 0;
  countAlice = countBob = 0;
  while (countAlice < k || countBob < k) {
    if (countAlice < k && countBob < k) {
      if (!a.empty() && !b.empty()) {
        if (ab.empty()) {
          takeFrom(a, countAlice, ans);
          takeFrom(b, countBob, ans);
        } else {
          if (a.back() + b.back() < ab.back()) {
            takeFrom(a, countAlice, ans);
            takeFrom(b, countBob, ans);
          } else {
            takeFrom(ab, countAlice, countBob, ans);
          }
        }
      } else {
        takeFrom(ab, countAlice, countBob, ans);
      }
    } else if (countAlice < k) {
      if (a.empty()) {
        takeFrom(ab, countAlice, countBob, ans);
      } else {
        if (ab.empty()) {
          takeFrom(a, countAlice, ans);
        } else {
          if (a.back() < ab.back()) {
            takeFrom(a, countAlice, ans);
          } else {
            takeFrom(ab, countAlice, countBob, ans);
          }
        }
      }
    } else if (countBob < k) {
      if (b.empty()) {
        takeFrom(ab, countAlice, countBob, ans);
      } else {
        if (ab.empty()) {
          takeFrom(b, countBob, ans);
        } else {
          if (b.back() < ab.back()) {
            takeFrom(b, countBob, ans);
          } else {
            takeFrom(ab, countAlice, countBob, ans);
          }
        }
      }
    }
  }
  cout << ans << '\n';
}
