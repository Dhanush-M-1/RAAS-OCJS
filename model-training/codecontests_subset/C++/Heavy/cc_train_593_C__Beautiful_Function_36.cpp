#include <bits/stdc++.h>
using namespace std;
string itos(long long n) {
  ostringstream o;
  o << n;
  return o.str();
}
void run() {
  int n;
  cin >> n;
  vector<pair<long long, long long> > c(n);
  long long r;
  for (int i = 0; i < n; i++) cin >> c[i].first >> c[i].second >> r;
  string x = "";
  string y = "";
  for (int i = 0; i < n; i++) {
    string a = "1";
    string b = "abs((t-" + itos(i) + "))";
    string base = "(" + a + "-" + b + ")+abs((" + b + "-" + a + "))";
    string x1 = "(" + itos(c[i].first / 2) + "*(" + base + "))";
    string y1 = "(" + itos(c[i].second / 2) + "*(" + base + "))";
    if (i == 0) {
      x = x1;
      y = y1;
    } else {
      x = "(" + x + "+" + x1 + ")";
      y = "(" + y + "+" + y1 + ")";
    }
  }
  cout << x << "\n";
  cout << y << "\n";
}
int main() {
  cout << fixed << setprecision(16);
  run();
  return 0;
}
