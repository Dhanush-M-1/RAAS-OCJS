#include<iostream>

using namespace std;

#define rep(i, n) for (int i = 0; i < int(n); ++i)

int main() {
  int q;
  cin >> q;
  while (q--) {
    int n, res = 0;
    cin >> n;
    while (n >= 10) {
      int mx = 0;
      for (int b = 10; b < n; b *= 10) {
	if (mx < (n / b) * (n % b)) {
	  mx = (n / b) * (n % b);
	}
      }
      n = mx;
      ++res;
    }
    cout << res << endl;
  }
  return 0;
}