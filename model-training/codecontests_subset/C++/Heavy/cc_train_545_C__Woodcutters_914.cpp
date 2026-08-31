#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n = -1;
  cin >> n;
  long long int a = min((long long int)2, n);
  vector<array<long long int, 3>> t;
  int x, h;
  for (int i = 0; i < n; i++) {
    cin >> x >> h;
    t.push_back({x, h, 1});
  }
  sort(t.begin(), t.end());
  for (int i = 1; i < n - 1; i++) {
    if (t.at(i).at(2) && t.at(i).at(0) - t.at(i).at(1) > t.at(i - 1).at(0)) {
      a++;
    } else if (t.at(i).at(0) + t.at(i).at(1) < t.at(i + 1).at(0)) {
      a++;
      if (t.at(i).at(0) + t.at(i).at(1) >=
          t.at(i + 1).at(0) - t.at(i + 1).at(1)) {
        t.at(i + 1).at(2) = 0;
      }
    }
  }
  cout << a << endl;
  return 0;
}
