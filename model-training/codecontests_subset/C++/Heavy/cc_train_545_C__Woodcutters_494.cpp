#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int> > v;
  int a, b, i;
  for (i = 0; i < n; i++) {
    cin >> a >> b;
    v.push_back({a, b});
  }
  int count = 2;
  if (n == 1 || n == 2) {
    cout << n << endl;
    return 0;
  }
  int valid = v[0].first;
  for (i = 1; i < n - 1; i++) {
    int pre = (v[i].first - v[i].second);
    int suf = v[i].first + v[i].second;
    if (pre > valid) {
      count++;
      valid = v[i].first;
      continue;
    } else if (suf < v[i + 1].first) {
      count++;
      valid = suf;
    } else {
      valid = v[i].first;
      continue;
    }
  }
  cout << count << endl;
}
