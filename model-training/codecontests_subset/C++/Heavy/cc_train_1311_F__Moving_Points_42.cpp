#include <bits/stdc++.h>
using namespace std;
pair<long long int, long long int> final[200001];
void up(long long int i, long long int x, long long int j) {
  while (i < 200001) {
    j == 0 ? final[i].first += x : final[i].second += x;
    i += (i & (-i));
  }
}
long long int q(long long int i, long long int j) {
  long long int ans = 0;
  while (i) {
    ans += (j == 0 ? final[i].first : final[i].second);
    i -= (i & (-i));
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n;
  cin >> n;
  long long int a[n];
  pair<long long int, long long int> b[n];
  for (long long int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (long long int i = 0; i < n; i++) {
    cin >> b[i].first;
    b[i].second = a[i];
  }
  sort(b, b + n);
  map<long long int, long long int> mapper;
  sort(a, a + n);
  for (long long int i = 0; i < n; i++) {
    mapper[a[i]] = i + 1;
  }
  long long int ans = 0;
  for (auto e : b) {
    long long int sp = e.first, pos = e.second;
    long long int ind = mapper[pos];
    long long int sum = q(ind - 1, 1);
    long long int points = q(ind - 1, 0);
    ans += pos * points - sum;
    up(ind, 1, 0);
    up(ind, pos, 1);
  }
  cout << ans;
}
