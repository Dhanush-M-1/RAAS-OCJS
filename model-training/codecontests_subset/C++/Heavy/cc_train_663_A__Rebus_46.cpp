#include <bits/stdc++.h>
using namespace std;
int main() {
  char c;
  vector<int> vec;
  int cnt = 0, cp = 0, cm = 0, n, cur, cur1;
  cin >> c;
  while (c != '=') {
    if (c == '?') cnt++;
    if (c == '+') vec.push_back(1);
    if (c == '-') vec.push_back(0);
    cin >> c;
  }
  cin >> n;
  cur = n;
  cur1 = 1;
  for (int i = 0; i < cnt - 1; i++) {
    if (vec[i] == 1) {
      cur += n;
      cur1 += 1;
    } else {
      cur -= 1;
      cur1 -= n;
    }
  }
  if (cur < n || cur1 > n) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible" << endl;
  cout << max(1, n - (cur - n)) << " ";
  if (n - (cur - n) >= 1)
    cur = n;
  else
    cur -= n - 1;
  for (int i = 0; i < cnt - 1; i++) {
    if (vec[i] == 1) {
      cout << "+ ";
      cout << max(1, n - (cur - n)) << " ";
      if (n - (cur - n) >= 1)
        cur = n;
      else
        cur -= n - 1;
    } else {
      cout << "- ";
      cout << min(n, 1 + cur - n) << " ";
      if (1 + cur - n >= n)
        cur -= n - 1;
      else
        cur = n;
    }
  }
  cout << "= " << n;
  return 0;
}
