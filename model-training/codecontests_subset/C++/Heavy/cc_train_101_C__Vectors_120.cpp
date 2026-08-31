#include <bits/stdc++.h>
using namespace std;
void setIO(string s = "") {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin.exceptions(cin.failbit);
  if (s.size()) {
    freopen((s + ".in").c_str(), "r", stdin);
    freopen((s + ".out").c_str(), "w", stdout);
  }
}
long long int Ax, Ay;
long long int Bx, By, Cx, Cy;
void solve() {
  long long int n, m, j, l, k, i;
  cin >> Ax >> Ay >> Bx >> By >> Cx >> Cy;
  for (i = 0; i < 4; i++) {
    long long int dx = Bx - Ax;
    long long int dy = By - Ay;
    if (dx == 0 && dy == 0) {
      cout << "YES";
      cout << "\n";
      return;
    }
    long long int u = dx * Cx + dy * Cy;
    long long int v = dx * Cy - dy * Cx;
    long long int w = Cx * Cx + Cy * Cy;
    if (w != 0 && u % w == 0 && v % w == 0) {
      cout << "YES";
      cout << "\n";
      return;
    }
    Ax *= -1;
    swap(Ax, Ay);
  }
  cout << "NO";
  cout << "\n";
  return;
}
int main() {
  setIO();
  long long int totalTestCase = 1;
  for (long long int testCase = 1; testCase <= totalTestCase; testCase++) {
    solve();
  }
  return 0;
}
