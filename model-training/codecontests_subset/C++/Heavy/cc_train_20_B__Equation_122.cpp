#include <bits/stdc++.h>
using namespace std;
vector<double> v;
long long n, m, i, j, t, a, b, c, k;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << -1 << endl;
    return 0;
  } else if (a == 0 && b == 0) {
    cout << 0 << endl;
    return 0;
  } else if (b * b - 4 * a * c < 0) {
    cout << 0 << endl;
    return 0;
  } else if (b * b - 4 * a * c == 0) {
    v.push_back(-(b * 1.0) / (2 * a));
  } else if (a == 0 && c == 0) {
    v.push_back(0.0);
  } else if (c == 0) {
    v.push_back(0.0);
    v.push_back(-b * 1.0 / a);
  } else if (a == 0) {
    v.push_back(-c * 1.0 / b);
  } else if (b == 0) {
    v.push_back(sqrt(-c * 1.0 / a));
    v.push_back(-sqrt(-c * 1.0 / a));
  } else {
    v.push_back((-b + sqrt(b * b - 4 * a * c)) / (2 * a));
    v.push_back((-b - sqrt(b * b - 4 * a * c)) / (2 * a));
  }
  cout << v.size() << endl;
  sort(v.begin(), v.end());
  for (i = 0; i < v.size(); i++) printf("%0.6f\n", v[i]);
  return 0;
}
