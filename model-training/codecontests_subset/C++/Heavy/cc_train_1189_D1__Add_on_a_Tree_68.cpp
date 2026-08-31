#include <bits/stdc++.h>
using namespace std;
long long in[100005];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, x, y;
  cin >> n;
  for (long long i = 0; i < n - 1; i++) {
    cin >> x >> y;
    in[x]++;
    in[y]++;
  }
  long long cnt = 0;
  bool first = 1;
  for (long long i = 1; i < n + 1; i++) {
    if (in[i] == 1) cnt++;
    if (in[i] == 2) {
      first = 0;
      break;
    }
  }
  if (first == 0) {
    cout << "NO"
         << "\n";
    return 0;
  }
  if ((cnt * (cnt - 1)) / 2 >= n - 1) {
    cout << "YES"
         << "\n";
  } else {
    cout << "NO"
         << "\n";
  }
  return 0;
}
