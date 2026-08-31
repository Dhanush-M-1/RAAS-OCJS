#include <bits/stdc++.h>
using namespace std;
int main() {
  string in;
  getline(cin, in);
  stringstream ss(in);
  int pos = 1;
  int neg = 0;
  vector<char> logger;
  while (true) {
    char c;
    ss >> c;
    if (c == '=') break;
    if (c == '+') {
      logger.push_back('+');
      pos++;
    }
    if (c == '-') {
      logger.push_back('-');
      neg++;
    }
  }
  int n;
  ss >> n;
  if ((pos * n - neg * 1 < n) || (pos * 1 - neg * n > n)) {
    cout << "Impossible" << endl;
  } else {
    cout << "Possible" << endl;
    int pre = 0;
    for (int i = 0; i < logger.size(); ++i) {
      int sign = 1;
      if ((i > 0) && (logger[i - 1] == '-')) {
        sign = -1;
      }
      if (sign == 1)
        pos--;
      else
        neg--;
      for (int x = 1; x <= n; ++x) {
        if ((pre + sign * x + pos * n - neg * 1 >= n) &&
            (pre + sign * x + pos * 1 - neg * n <= n)) {
          pre += sign * x;
          cout << x << " " << logger[i] << " ";
          break;
        }
      }
    }
    cout << abs(n - pre) << " = " << n << endl;
  }
  return 0;
}
