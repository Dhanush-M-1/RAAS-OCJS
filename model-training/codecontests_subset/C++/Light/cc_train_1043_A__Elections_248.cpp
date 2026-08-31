#include <bits/stdc++.h>
using namespace std;
int n, v = 0, s = 0, k, t;
vector<int> a;
int check(int k) {
  s = 0;
  for (int i = 0; i < n; ++i) {
    s += k - a[i];
  }
  if (s > v)
    return k;
  else
    check(k + 1);
}
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> t;
    a.push_back(t);
    v += t;
  }
  k = *max_element(a.begin(), a.end());
  cout << check(k);
}
