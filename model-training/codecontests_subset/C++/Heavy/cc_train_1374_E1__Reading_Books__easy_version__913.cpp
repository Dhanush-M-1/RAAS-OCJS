#include <bits/stdc++.h>
using namespace std;
template <class T>
int size(const T& x) {
  return x.size();
}
using namespace std;
void solve(int test_case) {
  int n, k;
  cin >> n >> k;
  vector<int> tBoth, tAlice, tBob;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1) tBoth.push_back(t);
    if (a == 1 && b == 0) tAlice.push_back(t);
    if (a == 0 && b == 1) tBob.push_back(t);
  }
  if (k > (tBoth.size() + tAlice.size()) ||
      (k > (tBoth.size() + tBob.size()))) {
    cout << -1 << endl;
    return;
  }
  sort(begin(tBoth), end(tBoth));
  sort(begin(tAlice), end(tAlice));
  sort(begin(tBob), end(tBob));
  int iboth = 0, isep = 0;
  long long ret = 0, read = 0;
  while (read < k) {
    long long tbothcand = -1;
    if (iboth < tBoth.size()) {
      tbothcand = tBoth[iboth];
    }
    long long tsepcand = -1;
    if (isep < min(tAlice.size(), tBob.size())) {
      tsepcand = tAlice[isep] + tBob[isep];
    }
    if (tsepcand == -1 || (tbothcand != -1 && tbothcand < tsepcand)) {
      ret += tbothcand;
      iboth++;
      read++;
    } else {
      ret += tsepcand;
      isep++;
      read++;
    }
  }
  cout << ret << endl;
}
int main() {
  int T = 1;
  for (int test_case = 1; test_case <= T; test_case++) {
    solve(test_case);
  }
  return 0;
}
