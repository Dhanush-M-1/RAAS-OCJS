#include <bits/stdc++.h>
using namespace std;
const bool online_judge = true;
const long long inf = 1LL << 60;
long long toInt(string s) {
  long long res;
  stringstream ss;
  ss << s;
  ss >> res;
  return res;
}
string toString(long long n) {
  stringstream ss;
  ss << n;
  return ss.str();
}
double EPS = 1e-9;
void run() {
  long long a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0) {
    if (c == 0)
      cout << -1 << endl;
    else
      cout << 0 << endl;
    return;
  }
  if (a == 0) {
    cout << 1 << endl;
    cout << fixed << setprecision(7) << (double)c / b * (-1);
    return;
  }
  long long D = b * b - 4 * a * c;
  if (D < 0) {
    cout << 0 << endl;
    return;
  }
  if (D == 0) {
    cout << 1 << endl;
    cout << (double)-b / (2 * a);
    return;
  }
  double d = sqrt(D);
  cout << 2 << endl;
  auto ans = {(double)(-b - d) / (2 * a), (double)(-b + d) / (2 * a)};
  cout << fixed << setprecision(7) << min(ans) << endl;
  cout << max(ans) << endl;
}
int main(int argc, char *argv[]) {
  run();
  return 0;
}
