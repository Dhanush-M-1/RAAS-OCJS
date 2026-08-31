#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  double ad = a;
  double bd = b;
  double cd = c;
  if (a == 0 && b == 0 && c == 0) {
    cout << -1 << endl;
    return 0;
  }
  if (a == 0) {
    if (b == 0) {
      cout << 0 << endl;
      return 0;
    }
    printf("1\n%.9lf\n", -cd / bd);
  } else {
    long long D = b * b - 4LL * a * c;
    if (D < 0) {
      cout << 0 << endl;
      return 0;
    }
    if (D == 0) {
      cout << 1 << endl;
      printf("%.9lf\n", -bd / (2.0 * ad));
      return 0;
    }
    vector<double> v;
    v.push_back((-bd + sqrt((double)D)) / (2.0 * ad));
    v.push_back((-bd - sqrt((double)D)) / (2.0 * ad));
    sort(v.begin(), v.end());
    cout << 2 << endl;
    for (int i = 0; i < 2; i++) printf("%.9lf\n", v[i]);
  }
}
