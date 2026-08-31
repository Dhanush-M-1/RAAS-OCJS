#include <bits/stdc++.h>
using namespace std;
char op[200], a[200];
int n;
int toInt(string x) {
  int ret = 0;
  for (int i = 0; i < x.size(); i++) {
    ret = ret * 10 + (x[i] - '0');
  }
  return ret;
}
int main() {
  int cnt = 0, cnt2 = 0;
  cnt++;
  string x, y;
  cin >> x;
  int al = 0;
  while (cin >> x >> y) {
    if (x == "=") {
      n = toInt(y);
      break;
    }
    op[al++] = x[0];
    if (x == "-")
      cnt2++;
    else
      cnt++;
  }
  int cur = n;
  vector<int> positive, negative;
  for (int i = 0; i < cnt; i++) positive.push_back(n), cur -= n;
  for (int i = 0; i < cnt2; i++) negative.push_back(n), cur += n;
  if (cur < 0) {
    for (int i = 0; i < cnt && cur < 0; i++) {
      if (cur + (n - 1) <= 0)
        cur += n - 1, positive[i] = 1;
      else
        positive[i] -= -cur, cur += -cur;
    }
  } else if (cur > 0) {
    for (int i = 0; i < cnt2 && cur > 0; i++) {
      if (cur - (n - 1) >= 0)
        cur -= n - 1, negative[i] = 1;
      else
        negative[i] -= cur, cur -= cur;
    }
  }
  if (cur != 0) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  int i = 1, j = 0;
  cout << positive[0];
  for (int k = 0; k < al; k++) {
    cout << " " << op[k] << " ";
    if (op[k] == '-')
      cout << negative[j++];
    else
      cout << positive[i++];
  }
  cout << " = " << n << "\n";
  return 0;
}
