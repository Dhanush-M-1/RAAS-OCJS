#include <bits/stdc++.h>
using namespace std;
int arr[5300][5300], n;
bool valid(int x) {
  int i, j, t, k, p;
  for (i = 0; i < n / x; i++) {
    for (j = 0; j < n / x; j++) {
      t = arr[i * x][j * x];
      for (k = 0; k < x; k++) {
        for (p = 0; p < x; p++)
          if (arr[i * x + k][j * x + p] != t) return false;
      }
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int i, l, t, j;
  string s;
  vector<int> v;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> s;
    l = s.size();
    for (j = 0; j < l; j++) {
      if (s[j] >= '0' && s[j] <= '9')
        t = s[j] - '0';
      else
        t = s[j] - 'A' + 10;
      arr[i][j * 4 + 3] = (t & 1) ? 1 : 0;
      arr[i][j * 4 + 2] = (t & 2) ? 1 : 0;
      arr[i][j * 4 + 1] = (t & 4) ? 1 : 0;
      arr[i][j * 4] = (t & 8) ? 1 : 0;
    }
  }
  for (i = 2; i <= n; i++) {
    if (n % i == 0) {
      v.push_back(i);
    }
  }
  reverse(v.begin(), v.end());
  l = v.size();
  for (i = 0; i < l; i++) {
    if (valid(v[i])) {
      cout << v[i] << endl;
      return 0;
    }
  }
  cout << 1 << endl;
  return 0;
}
