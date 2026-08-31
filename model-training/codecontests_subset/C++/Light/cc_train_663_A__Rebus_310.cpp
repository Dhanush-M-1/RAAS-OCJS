#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, l, x, sum = 0, n;
  char ch;
  vector<char> sign;
  vector<int> q;
  int pos = 1;
  int neg = 0;
  int max_possible;
  int min_possible;
  sign.push_back(1);
  while (1) {
    scanf("%c", &ch);
    if (ch == '+') {
      pos++;
      sign.push_back(1);
    } else if (ch == '-') {
      neg++;
      sign.push_back(-1);
    } else if (ch == '=')
      break;
    else if (ch == '?')
      q.push_back(2);
  }
  scanf("%d", &n);
  int flag = 0;
  for (i = 0; i < q.size(); i++) {
    flag = 0;
    if (sign[i] == 1)
      pos--;
    else
      neg--;
    max_possible = pos * n - neg * 1;
    min_possible = pos * 1 - neg * n;
    for (x = 1; x <= n; x++) {
      if ((n - sum - x * sign[i]) <= max_possible &&
          (n - sum - x * sign[i]) >= min_possible) {
        flag = 1;
        break;
      }
    }
    if (flag == 0) break;
    sum += x * sign[i];
    q[i] = x;
  }
  if (flag == 1) {
    cout << "Possible" << endl;
    k = 1;
    for (i = 0; i < q.size(); i++) {
      if (sign[k] == 1)
        ch = '+';
      else
        ch = '-';
      if (i != q.size() - 1)
        cout << q[i] << " " << ch << " ";
      else
        cout << q[i] << " ";
      k++;
    }
    cout << '=' << " " << n << endl;
  } else
    cout << "Impossible" << endl;
  return 0;
}
