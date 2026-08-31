#include <bits/stdc++.h>
using namespace std;
long long n, k, t, a, b, it1, it2, score, tim, f, s;
vector<long long> vec[4];
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> t >> a >> b;
    if (a == 1) f++;
    if (b == 1) s++;
    if (a == 0 && b == 0) continue;
    if (a == 1 && b == 1) {
      vec[1].push_back(t);
      continue;
    }
    if (a == 1) vec[2].push_back(t);
    if (b == 1) vec[3].push_back(t);
  }
  if (f < k || s < k) {
    cout << -1 << endl;
  } else {
    for (int i = 1; i <= 3; i++) {
      sort(vec[i].begin(), vec[i].end());
    }
    it1 = 0;
    it2 = 0;
    tim = 0;
    score = 0;
    while (score < k) {
      if (it1 == vec[1].size()) {
        tim += vec[2][it2] + vec[3][it2];
        it2++;
        score++;
        continue;
      }
      if (it2 == vec[2].size() || it2 == vec[3].size()) {
        tim += vec[1][it1];
        score++;
        it1++;
        continue;
      }
      if (vec[1][it1] < vec[2][it2] + vec[3][it2]) {
        tim += vec[1][it1];
        score++;
        it1++;
      } else {
        tim += vec[2][it2] + vec[3][it2];
        it2++;
        score++;
      }
    }
    cout << tim << endl;
  }
  return 0;
}
