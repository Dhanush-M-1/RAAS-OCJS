#include <bits/stdc++.h>
using namespace std;
void readtxt() {}
void fast() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
int32_t main() {
  fast();
  long long int n, k;
  cin >> n >> k;
  vector<long long int> a1b1, a1b0, a0b1;
  long long int ans = 0, t, a, b;
  for (long long int i = 0; i < n; i++) {
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      a1b1.push_back(t);
    else if (a == 1 && b == 0)
      a1b0.push_back(t);
    else if (a == 0 && b == 1)
      a0b1.push_back(t);
  }
  sort(a1b1.begin(), a1b1.end());
  sort(a1b0.begin(), a1b0.end());
  sort(a0b1.begin(), a0b1.end());
  auto it1 = a1b1.begin();
  auto it2 = a1b0.begin();
  auto it3 = a0b1.begin();
  long long int flag = 1;
  while (k--) {
    if (it1 == a1b1.end() && (it2 == a1b0.end() || it3 == a0b1.end())) {
      flag = 0;
      cout << -1 << endl;
      break;
    } else if (it2 == a1b0.end() || it3 == a0b1.end()) {
      ans += (*it1);
      it1++;
    } else if (it1 == a1b1.end()) {
      ans += (*it2) + (*it3);
      it2++;
      it3++;
    } else {
      if ((*it1) <= (*it2) + (*it3)) {
        ans += (*it1);
        it1++;
      } else {
        ans += (*it2) + (*it3);
        it2++;
        it3++;
      }
    }
  }
  if (flag == 1) cout << ans << endl;
}
