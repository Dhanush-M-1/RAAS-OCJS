#include <bits/stdc++.h>
using namespace std;
long long int solve() {
  long long int n, k;
  cin >> n >> k;
  vector<long long int> first, second, both;
  int av = 0, bv = 0;
  while (n--) {
    long long int t, a, b;
    cin >> t >> a >> b;
    if (a && b)
      both.push_back(t), av++, bv++;
    else if (a)
      first.push_back(t), av++;
    else if (b)
      second.push_back(t), bv++;
  }
  if (av < k || bv < k) return -1;
  sort(first.begin(), first.end());
  sort(second.begin(), second.end());
  sort(both.begin(), both.end());
  av = k, bv = k;
  int ia = 0, is = 0, ib = 0, sf = first.size(), ss = second.size(),
      sb = both.size();
  long long int ans = 0;
  while (av > 0 && bv > 0) {
    if (ib < sb and
        ((ia >= sf || is >= ss) || both[ib] < first[ia] + second[is])) {
      ans += both[ib++];
      av--;
      bv--;
    } else {
      ans += first[ia++] + second[is++];
      av--;
      bv--;
    }
  }
  return ans;
}
int main() { cout << solve(); }
