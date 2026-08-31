#include <bits/stdc++.h>
using namespace std;
long long a[1000006] = {}, b[1000006] = {}, c[1000006] = {};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  int i = 0, j = n - 1;
  int q = 1, w = 1000000;
  long long sec = 0;
  for (int k = 0; k < n;) {
    long long dis = (a[k] - q);
    long long ss = (w - a[n - 1]);
    if (dis < ss) {
      sec += dis;
      q = a[k];
      w = w - dis;
      k++;
    } else if (ss < dis) {
      sec += ss;
      w = a[n - 1];
      q = q + ss;
      n--;
    } else {
      sec += ss;
      w = a[n - 1];
      q = a[k];
      k++;
      n--;
    }
  }
  cout << sec << endl;
  return 0;
}
