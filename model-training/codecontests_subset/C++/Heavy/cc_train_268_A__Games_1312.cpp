#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int i, n, temp = 0, j, neg = 0, zer = 0, pos = 0, sum = 0, e = 0,
                      flag = 0, flag2 = 0, time = 0, disap = 0, m,
                      mi = 99999999, ma = -99999999, z = 0, k;
  long long int a = 0, b = 0;
  long long int c, d, s = 0, t = 0;
  long long int ct = 0;
  char inc;
  vector<long long int> v, v2, v3;
  long long int ar2[200001] = {0}, ar[100][100] = {0};
  string st, st2, st3, st4;
  vector<pair<int, int> > vp;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a >> b;
    vp.push_back(make_pair(a, b));
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (i == j) {
        continue;
      } else if (vp[i].second == vp[j].first) {
        sum += 1;
      }
    }
  }
  cout << sum;
  return 0;
}
