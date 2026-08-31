#include <bits/stdc++.h>
using namespace std;
const long long mx = 1e5 + 5;
pair<long long, long long> a[mx];
long long n, s = 1;
bool c[mx];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  memset(c, 0, sizeof(c));
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].first >> a[i].second;
  }
  a[n + 1].first = 1e15;
  sort(a + 1, a + n + 1);
  for (int i = 2; i <= n; i++) {
    if (c[i - 1]) {
      if (a[i - 1].first + a[i - 1].second < a[i].first - a[i].second)
        s++;
      else if (a[i].first + a[i].second < a[i + 1].first) {
        c[i] = true;
        s++;
      }
    } else {
      if (a[i].first - a[i].second > a[i - 1].first)
        s++;
      else if (a[i].first + a[i].second < a[i + 1].first) {
        c[i] = true;
        s++;
      }
    }
  }
  cout << s;
}
