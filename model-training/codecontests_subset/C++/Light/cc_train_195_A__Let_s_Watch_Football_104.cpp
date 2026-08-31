#include <bits/stdc++.h>
using namespace std;
int main(int argc, const char* argv[]) {
  int a, b, c;
  cin >> a;
  cin >> b;
  cin >> c;
  if (a < b) {
    cout << 0;
    return 0;
  }
  float duration = c * (a - b);
  int t = ceil(duration / b);
  cout << t;
}
