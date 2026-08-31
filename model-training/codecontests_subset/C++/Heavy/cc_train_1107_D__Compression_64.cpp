#include <bits/stdc++.h>
using namespace std;
map<int, int> factors;
void primef(int n) {
  int cnt = 0;
  if (n % 2 == 0) {
    while (n % 2 == 0) cnt++, n /= 2;
    factors[2] = cnt;
  }
  for (int i = 3; i <= sqrt(n); i += 2) {
    cnt = 0;
    if (n % i == 0) {
      while (n % i == 0) n /= i, cnt++;
      factors[i] = cnt;
    }
  }
  if (n > 2) factors[n] = 1;
}
void inp(int n, int arr[]) {
  for (int i = 0; i < n; i++) cin >> arr[i];
}
vector<vector<int> > v(20);
void binary(int a) {
  int k = a;
  vector<int> vv;
  for (int i = 0; i < 4; i++) {
    vv.push_back(a % 2);
    a /= 2;
  }
  reverse((vv).begin(), (vv).end());
  v[k] = vv;
}
void solve() {
  int n;
  cin >> n;
  for (int i = 0; i < 16; i++) binary(i);
  int a[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n / 4; j++) {
      char c;
      cin >> c;
      int p;
      if (c >= 'A' && c <= 'F') {
        p = c - 'A' + 10;
      } else
        p = c - '0';
      for (int k = 0; k < 4; k++) {
        a[i][j * 4 + k] = v[p][k];
      }
    }
  }
  primef(n);
  int ans = 1;
  for (auto elem : factors) {
    int temp = 1;
    int el = 1;
    int tot = elem.second;
    while (tot--) {
      el *= elem.first;
      int check = 1;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          i++;
          j++;
          int ii = i / el + (i % el != 0);
          int jj = j / el + (j % el != 0);
          ii *= el;
          jj *= el;
          i--;
          j--;
          ii--;
          jj--;
          if (a[i][j] != a[ii][jj]) {
            check = 0;
            break;
          }
        }
        if (check == 0) break;
      }
      if (check) {
        temp = el;
      } else
        break;
    }
    ans *= temp;
  }
  cout << ans << '\n';
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
}
