#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-10;
const double PI = acos(-1.0);
int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(false);
  int N;
  cin >> N;
  map<int, int> m1, m2, m3;
  for (int i = (0); i < (N); ++i) {
    int x;
    cin >> x;
    m1[x]++;
  }
  for (int i = (0); i < (N - 1); ++i) {
    int x;
    cin >> x;
    m2[x]++;
  }
  for (int i = (0); i < (N - 2); ++i) {
    int x;
    cin >> x;
    m3[x]++;
  }
  for (auto pii : m1) {
    if (m2[pii.first] < pii.second) cout << pii.first << endl;
  }
  for (auto pii : m2) {
    if (m3[pii.first] < pii.second) cout << pii.first << endl;
  }
  return 0;
}
