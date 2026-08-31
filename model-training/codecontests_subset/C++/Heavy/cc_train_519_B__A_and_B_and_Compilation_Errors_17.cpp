#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c, i, j, k, e, n, x, y, p, d, su, t;
  map<long long int, long long int> ss, ff, tt;
  vector<long long int> v;
  vector<long long int>::iterator it;
  cin >> t;
  for (i = 1; i <= t; i++) {
    cin >> a;
    v.push_back(a);
    ss[a]++;
  }
  for (i = 0; i < t - 1; i++) {
    cin >> b;
    tt[b]++;
  }
  for (i = 0; i < t - 2; i++) {
    cin >> b;
    ff[b]++;
  }
  for (i = 0; i < t; i++) {
    if (ss[v[i]] != tt[v[i]]) {
      cout << v[i] << endl;
      it = find(v.begin(), v.end(), v[i]);
      v.erase(it);
      ss[i]--;
      break;
    }
  }
  for (i = 0; i < t - 1; i++) {
    if (tt[v[i]] != ff[v[i]]) {
      cout << v[i] << endl;
      break;
    }
  }
}
