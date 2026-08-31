#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n;
  cin >> n;
  vector<long long int> x(n), h(n);
  for (long long int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  vector<pair<long long int, long long int> > a(n);
  a[0].first = 99999999999;
  a[n - 1].second = 99999999999;
  for (long long int i = 0; i < n - 1; i++) {
    a[i].second = x[i + 1] - x[i] - 1;
    a[i + 1].first = a[i].second;
  }
  long long int c = 0;
  for (long long int i = 0; i < n - 1; i++) {
    if (a[i].first >= h[i]) {
      c++;
    } else if (a[i].second >= h[i]) {
      a[i].second -= h[i];
      a[i + 1].first -= h[i];
      c++;
    }
  }
  cout << c + 1 << "\n";
}
