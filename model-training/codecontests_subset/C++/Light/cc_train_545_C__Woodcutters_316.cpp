#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, x, h, i, c = 2, p = 0, q;
  cin >> n;
  vector<pair<int, int> > vec;
  for (i = 0; i < n; i++) {
    cin >> x >> h;
    vec.push_back(make_pair(x, h));
  }
  for (i = 1; i < n - 1; i++) {
    if ((vec[i].first - vec[i].second) > vec[i - 1].first &&
        (vec[i].first - vec[i].second) > p) {
      c++;
    } else if ((vec[i].first + vec[i].second) < vec[i + 1].first) {
      c++;
      p = (vec[i].first + vec[i].second);
    }
  }
  if (n == 1)
    cout << "1" << endl;
  else
    cout << c << endl;
  return 0;
}
