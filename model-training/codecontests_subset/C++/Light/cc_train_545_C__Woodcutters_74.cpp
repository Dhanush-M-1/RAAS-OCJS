#include <bits/stdc++.h>
using namespace std;
double const PI = 3.141592653;
const int OO = 1000000000 + 9;
void fast() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL), cout.tie(NULL);
}
int main() {
  fast();
  int n;
  cin >> n;
  vector<pair<int, int>> v(n);
  for (auto& i : v) {
    cin >> i.first >> i.second;
  }
  int mx = 0;
  for (int i = 1; i < n - 1; i++) {
    if (v[i].first - v[i].second > v[i - 1].first) {
      mx++;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      mx++, v[i].first += v[i].second;
    }
  }
  cout << (n == 1 ? 1 : mx + 2);
  return 0;
}
