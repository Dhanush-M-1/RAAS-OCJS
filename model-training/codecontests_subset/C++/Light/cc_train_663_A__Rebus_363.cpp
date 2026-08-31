#include <bits/stdc++.h>
using namespace std;
int main() {
  char c;
  int cnt = 1, arr[101], pos = 1, n, neg;
  arr[0] = 1;
  while (scanf("%c", &c) && c != '=') {
    if (c != '+' && c != '-') continue;
    arr[cnt] = (c == '+');
    pos += arr[cnt++];
  }
  cin >> n;
  neg = cnt - pos;
  if (pos * n < neg + n || (pos > neg * n + n)) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  int sum = 0;
  for (int i = 0; i < cnt; i++) {
    if (arr[i]) {
      if (i) cout << " + ";
      cout << min(n, max(1, ((n + neg - sum) / pos)));
      sum += min(n, max(1, ((n + neg - sum) / pos)));
      pos--;
    } else {
      cout << " - ";
      cout << min(n, max(1, ((pos * n - n) + sum) / neg));
      sum -= min(n, max(1, ((pos * n - n + sum) / neg)));
      neg--;
    }
  }
  printf(" = %d\n", n);
  return 0;
}
