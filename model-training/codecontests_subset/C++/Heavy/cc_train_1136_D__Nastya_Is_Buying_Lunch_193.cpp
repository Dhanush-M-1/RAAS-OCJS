#include <bits/stdc++.h>
using namespace std;
long long int i, j, ft;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long int n, m;
  cin >> n >> m;
  long long int a[n];
  for (i = 0; i < (n); i++) {
    long long int b;
    cin >> b;
    a[i] = b - 1;
  }
  vector<long long int> v[n];
  vector<long long int> number;
  long long int num = a[n - 1];
  for (i = 0; i < (m); i++) {
    long long int b, c;
    cin >> b >> c;
    b--;
    c--;
    v[c].push_back(b);
    if (b == num) number.push_back(c);
    if (c == num) number.push_back(b);
  }
  vector<long long int> vv;
  long long int sum = 0;
  long long int allow = 1;
  vector<long long int> allowed(n, 0);
  for (auto it = v[a[n - 1]].begin(); it != v[a[n - 1]].end(); it++) {
    allowed[*it]++;
  }
  for (long long int i = n - 2; i >= 0; i--) {
    if (allowed[a[i]] != allow) {
      for (auto it = v[a[i]].begin(); it != v[a[i]].end(); it++) {
        allowed[*it]++;
      }
      allow++;
    } else {
      sum++;
    }
  }
  cout << sum << "\n";
  return 0;
}
