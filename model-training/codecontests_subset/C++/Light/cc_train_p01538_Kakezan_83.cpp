#include <iostream>
using namespace std;
int main() {
  int Q, N, s, t, l, ans;
  cin >> Q;
  for (int i = 0; i < Q; ++i) {
    cin >> N;
    s = N;
    ans = 0;
    while (s > 9) {
      ++ans;
      l = 10;
      t = 0;
      while (l < N) {
	t = max(t, (s%l)*(s/l));
	l *= 10;
      }
      s = t;
    }
    cout << ans << endl;
  }
  return 0;
}