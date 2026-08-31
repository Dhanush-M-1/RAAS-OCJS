#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, time, a[100001];
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  time = min(1000000 - a[1], a[n] - 1);
  for (int i = 1; i <= n; i++)
    if (i != 1)
      time = min(time, min(max(a[i - 1] - 1, 1000000 - a[i]),
                           max(a[i] - 1, 1000000 - a[i + 1])));
  cout << time;
}
